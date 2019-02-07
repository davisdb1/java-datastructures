package com.cnc.datastructures;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class QueueTest {
    @Test
    public void PopEmpty() {
        Queue<Integer> stack = new Queue<>();
        Integer result = stack.pop();
        assertEquals(null, result);

    }

    @Test
    public void PushOne() {
        Queue<Integer> queue = new Queue<>();
        queue.push(1);
        Integer result = queue.pop();
        assertEquals((Integer) 1, result);
    }

    @Test
    public void PushMultiple() {
        Queue<Integer> queue = new Queue<>();
        queue.push(1);
        queue.push(2);

        Integer result = queue.pop();

        assertEquals((Integer) 1, result);
        result = queue.pop();
        assertEquals((Integer) 2, result);

    }

    @Test
    public void PopMoreThanPush() {
        Queue<Integer> queue = new Queue<>();
        queue.push(1);
        queue.push(2);

        Integer result = queue.pop();

        assertEquals((Integer) 1, result);
        result = queue.pop();
        assertEquals((Integer) 2, result);
        result = queue.pop();
        assertEquals(null, result);
    }
}
