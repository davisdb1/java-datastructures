package com.cnc.algorithms;

import java.util.LinkedList;

/*
 * Dynamic programming example for solving the knapsack problem
 * 
 */
public class DPKnapSack {
	int[] values;
	int[] weights;
	int capacity;
	public LinkedList<Integer> FindMaxProfit(int[] values, int[] weights, int capacity){
		this.values = values;
		this.weights = weights;
		this.capacity = capacity;

		//first init a V matrix, representing max profit at any given weight and iteration
		int[][] V = new int[values.length][capacity + 1];

		//next, init a K matrix, representing if the item should be placed in the sack or not
		boolean[][] K = new boolean[values.length][capacity + 1];

		for(int n = 0; n < values.length; n ++){//for each item N
			for(int m = 0; m <= capacity; m ++ ){//for each weight in the item
				if(n == 0 || m == 0){
					V[n][m] = 0;
					K[n][m] = false;
				}else{

					//what would the value be without adding?
					int noAddValue = V[n-1][m];//the same profit as the previous item calculation
					int AddValue = 0;
					if( (m + weights[n-1]) < capacity //calc if we can add another one
							)
					{
						AddValue = values[n-1] + V[n-1][ (m - weights[n-1]) ];
					}
					
					V[n][m] = Math.max(noAddValue, AddValue);
					K[n][m] = (AddValue > noAddValue);
				}
			}

		}
		
		
		//great, now the V and K matrix should be filled out
		//look at the the K matrix to figure out which items should be kept
		
		int weightLeft = capacity;
		LinkedList<Integer> chosen = new LinkedList<Integer>();
		for(int n= values.length; n > 0; n--){
			if(K[n][weightLeft]){
				chosen.add(n);
				weightLeft -= weights[n-1];
			}
		}
		return chosen;
	}

}
