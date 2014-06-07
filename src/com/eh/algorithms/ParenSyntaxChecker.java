package com.eh.algorithms;

import com.eh.datastructures.Stack;

/*
 * Check the syntax of string which contains () {} [] to
 * make sure that each open symbol is matched with a
 * closed symbol
 * 
 */
public class ParenSyntaxChecker {
	public static boolean isCorrectSyntax(String input){
		char[] inputAsArray = input.toCharArray();
		int inputLength = input.length();
		Stack<Character> stack = new Stack<Character>();
		for(int i = 0 ; i < inputLength; i++){
			if(inputAsArray[i] == '{' ||
					inputAsArray[i] == '[' ||
					inputAsArray[i] == '(' ){
				stack.push(new Character(inputAsArray[i]));
			}else if(inputAsArray[i] == '}' ||
					inputAsArray[i] == ']' ||
					inputAsArray[i] == ')' ){
				char last = stack.pop();
				if(last != inputAsArray[i]){
					return false;
				}
			}
		}
		return stack.getLength() == 0;
	}
}
