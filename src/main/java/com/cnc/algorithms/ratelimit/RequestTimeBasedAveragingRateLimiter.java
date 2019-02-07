package com.cnc.algorithms.ratelimit;

/**
 * @author Evan Harris
 */
public class RequestTimeBasedAveragingRateLimiter {

    long[] requestTimeBuffer;
    int requestTimeBufferIndex = 0;
    int maxTps;
    Object bufferLock = new Object();

    public RequestTimeBasedAveragingRateLimiter(int maxTps) {
        if (maxTps < 1) {
            throw new IllegalArgumentException("MaxTps must be greater than 0");
        }
        requestTimeBuffer = new long[maxTps];
        this.maxTps = maxTps;
    }

    public void aquire() throws InterruptedException {
        if (!tryAquire()) {
            Thread.sleep(1000L - (System.currentTimeMillis() - getLastRequestTime()));
        }
        recordRequestTime(System.currentTimeMillis());
    }

    public boolean tryAquire() {
        return getLastRequestTime() == 0 || (System.currentTimeMillis() - getLastRequestTime()) >= 1000L;
    }

    private long getLastRequestTime() {
        synchronized (bufferLock) {
            if (requestTimeBufferIndex == 0) {
                return requestTimeBuffer[maxTps - 1];
            }
            else {
                return requestTimeBuffer[requestTimeBufferIndex - 1];
            }
        }
    }

    private synchronized void recordRequestTime(long requestTime) {
        synchronized (bufferLock) {
            if (requestTimeBufferIndex == maxTps) {
                requestTimeBufferIndex = 0;
            }
            requestTimeBuffer[requestTimeBufferIndex++] = requestTime;
        }
    }
}
