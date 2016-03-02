package com.cnc.algorithms;

/**
 *
 * A Decent Number has the following properties:
 * Its digits can only be 3's and/or 5's.
 * The number of 3's it contains is divisible by 5.
 * The number of 5's it contains is divisible by 3.
 * If there are more than one such number, we pick the largest one.
 *
 * Find the largest decent number of length N
 *
 * Created by evanharris on 2/21/16.
 */
public class DecentNumberFinder {

    String findLargestDecentNumber(int N){

        int numberof5s = N;
        int numberof3s = 0;
        boolean solutionFound = false;
        while( !solutionFound && numberof5s >= 0){
            if(numberof5s % 3 == 0 && numberof3s % 5 == 0){
                solutionFound = true;
            }
            else{
                numberof5s -= 5;
                numberof3s += 5;
            }
        }

        StringBuilder sb = new StringBuilder();
        if(!solutionFound){
            sb.append("-1");
        }
        else {
            for(int i = 0; i < numberof5s; i++){
                sb.append("5");
            }
            for(int i = 0; i < numberof3s; i++){
                sb.append("3");
            }
        }
        return sb.toString();
    }
}
