package com.cnc.algorithms;


/*
 * Given a stream on integers, implement a class that can
 * find the median number in the stream
 * 
 * 
 * Step 1: Add next item to one of the heaps
 *
 *  if next item is smaller than maxHeap root add it to maxHeap,
 *  else add it to minHeap
 *
 * Step 2: Balance the heaps (after this step heaps will be either balanced or
 *  one of them will contain 1 more item)
 *
 *  if number of elements in one of the heaps is greater than the other by
 *  more than 1, remove the root element from the one containing more elements and
 *  add to the other one
 * 
 * Now when gettint the median number
 * 
 * 
 *   If the heaps contain equal elements;
 *     median = (root of maxHeap + root of minHeap)/2
 *  Else
 *    median = root of the heap with more elements
 * 
 * TODO: currently this uses a linked list to store the numbers,
 * This is not very efficient due to the insert cost and the lookup cost
 * The correct way to do this is to create a min heap and a max heap. Keep the
 * heaps balanced with the same number of nodes in each heap. Then the top nodes
 * in each heap is the median. Cool eh?
 * 
 */
public class MedianFinder {
    
}
