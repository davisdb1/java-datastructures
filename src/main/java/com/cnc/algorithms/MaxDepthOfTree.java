package com.cnc.algorithms;

import com.cnc.datastructures.Node;

public class MaxDepthOfTree {

	
	
	public static int findMaxDepth(@SuppressWarnings("rawtypes") Node node){
		
		if(node == null){
			return 0;
		}else{
			int left = findMaxDepth(node.getLeft());
			int right = findMaxDepth(node.getRight());
			
			if(left > right){
				return left + 1;
			}else{
				return right + 1;
			}
			
		}
		
	}
	
}
