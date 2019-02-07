package com.cnc.algorithms.ratelimit;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * There is a database table with 300 million records in it. You are in charge of writing a program that must
 * select a record from the database, change a field, and update the record back to the database. In order to do this,
 * you write a program that performs the select and update queries and use multiple threads to execute. The database, however,
 * can only handle a set number of queries per second. Write a rate limiter that can be used to control the number of queries
 * per second to our database.
 * <p>
 * TODO: instead of using another thread to decrement the request count, use a ConcurrentLinkedQueue
 * to save the last N requests. N would be the sample rate to perform the averaging.
 *
 * @author Evan Harris
 */
public class RequestCountBasedAveragingRateLimiter {

    private final ScheduledExecutorService scheduler;
    private AtomicInteger requestCount;
    private AtomicInteger throttleTimeInMs;
    private int throttleTimeIncrement = 100;
    private int maxRequestsPerSec = 50;
    private long lastCheckedDate;

    private RequestCountBasedAveragingRateLimiter() {
        this.scheduler = Executors.newScheduledThreadPool(1);

        final Runnable beeper = new Runnable() {
            public void run() {
                sampleRate();
            }
        };

        scheduler.scheduleAtFixedRate(beeper, 10, 1, TimeUnit.SECONDS);

        this.requestCount = new AtomicInteger();
        this.throttleTimeInMs = new AtomicInteger();
    }

    /**
     * Call this method on cron job. It will calculate the request per second and adjust the throttle time as needed
     */
    private synchronized void sampleRate() {
        long currentTime = System.currentTimeMillis();
        long timeSpan = currentTime - lastCheckedDate;
        lastCheckedDate = currentTime;
        long requestsPerSecond = this.requestCount.getAndSet(0) / (timeSpan / 1000);
        syncThrottleTime(requestsPerSecond);
    }

    public void aquire() throws InterruptedException {
        int throttleTime = getThrottleTimeInMs();
        if (throttleTime > 0) {
            Thread.sleep(throttleTime);
        }
        this.requestCount.getAndIncrement();
    }

    public boolean tryAquire() {
        if (getThrottleTimeInMs() > 0) {
            return false;
        }
        else {
            this.requestCount.getAndIncrement();
            return true;
        }
    }

    /**
     * Linear increase and decrease the throttle time to try and balance the rate
     *
     * @param requestsPerSec the measured request count per second
     */
    private void syncThrottleTime(long requestsPerSec) {
        int currentThrottleTime = this.throttleTimeInMs.get();
        if (requestsPerSec >= maxRequestsPerSec) {
            this.throttleTimeInMs.addAndGet(this.throttleTimeIncrement);
        }
        else if (currentThrottleTime > 0) {
            this.throttleTimeInMs.addAndGet(this.throttleTimeIncrement - (2 * this.throttleTimeIncrement));
        }
    }

    private int getThrottleTimeInMs() {
        return Math.max(0, this.throttleTimeInMs.get());
    }

}
