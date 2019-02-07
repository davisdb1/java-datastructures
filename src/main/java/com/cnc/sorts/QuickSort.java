package com.cnc.sorts;

public class QuickSort {

    public static <T extends Comparable<T>> void sort(int start, int finish, T[] unsorted) {

        if (start < finish) {
            int p = partition(start, finish, unsorted);
            if (p - 1 > start) {
                sort(start, p - 1, unsorted);
            }
            if (p + 1 < finish) {
                sort(p, finish, unsorted);
            }

        }

    }


    //returns the piviot
    private static <T extends Comparable<T>> int partition(int start, int finish, T[] unsorted) {

        int s = start;
        int f = finish;

        T pivot = unsorted[start + finish / 2];

        while (s <= f) {
            while (unsorted[s].compareTo(pivot) < 0) s++;
            while (unsorted[f].compareTo(pivot) > 0) f--;
            if (s <= f) {
                T tmp = unsorted[s];
                unsorted[s] = unsorted[f];
                unsorted[f] = tmp;
                s++;
                f--;
            }


        }
        return s;
    }


}