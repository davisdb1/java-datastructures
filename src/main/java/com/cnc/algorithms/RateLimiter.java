package com.cnc.algorithms;

import java.util.Date;
import java.lang.Math;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Evan Harris
 */
public class RateLimiter {

     private AtomicInteger requestCount;
     private AtomicInteger throttleTimeInMs;
     private int throttleTimeIncrement = 100;
     private int maxRequestsPerSec = 50;
     private final ScheduledExecutorService scheduler;

     private long lastCheckedDate;


     private RateLimiter(){
         this.scheduler = Executors.newScheduledThreadPool(1);

         final Runnable beeper = new Runnable() {
             public void run() {sampleRate(); }
         };

         scheduler.scheduleAtFixedRate(beeper, 10, 1, TimeUnit.SECONDS);

         this.requestCount = new AtomicInteger();
         this.throttleTimeInMs = new AtomicInteger();
     }

     /**
      * Call this method on cron job. It will calculate the request per second and adjust the throttle time as needed
      */
     private synchronized void sampleRate(){
         long currentTime = new Date().getTime();
         long timeSpan = currentTime - lastCheckedDate;
         lastCheckedDate = currentTime;
         long requestsPerSecond = this.requestCount.getAndSet(0) / (timeSpan / 1000);
         syncThrottleTime(requestsPerSecond);
     }

     public void aquire() throws InterruptedException {
         int throttleTime = getThrottleTimeInMs();
         if(throttleTime > 0){
             Thread.sleep(throttleTime);
         }
         this.requestCount.getAndIncrement();
     }

     public boolean tryAquire(){
         if(getThrottleTimeInMs() > 0){
             return false;
         }else{
             this.requestCount.getAndIncrement();
             return true;
         }
     }

     /**
      * Linear increase and decrease the throttle time to try and balance the rate
      * @param requestsPerSec the measured request count per second
      */
     private void syncThrottleTime(long requestsPerSec){
         int currentThrottleTime = this.throttleTimeInMs.get();
         if(requestsPerSec >= maxRequestsPerSec){
             this.throttleTimeInMs.addAndGet(this.throttleTimeIncrement);
         }else if(currentThrottleTime > 0){
             this.throttleTimeInMs.addAndGet(this.throttleTimeIncrement - (2 * this.throttleTimeIncrement));
         }
     }

     private int getThrottleTimeInMs() {
         return Math.max(0,this.throttleTimeInMs.get());
     }

}
