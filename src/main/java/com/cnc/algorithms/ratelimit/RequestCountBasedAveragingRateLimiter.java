package com.cnc.algorithms.ratelimit;

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

    public void aquire() throws InterruptedException {
        throw new UnsupportedOperationException("Not yet implemented.");
    }

    public boolean tryAquire() {
        throw new UnsupportedOperationException("Not yet implemented.");
    }

}
