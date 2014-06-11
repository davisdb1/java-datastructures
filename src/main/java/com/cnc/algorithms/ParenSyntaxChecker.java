package com.cnc.algorithms;

import com.cnc.datastructures.Stack;

/*
 * Proper symbol nesting problem
 * 
 * Check the syntax of string which contains chars such as: () {} [] to
 * make sure that each open symbol is matched with a closed symbol and
 * is properly nested.
 * 
 */
public class ParenSyntaxChecker {
   
   public final static char[] OPEN_SYMBOL   = {'(', '{', '[' };
   public final static char[] CLOSED_SYMBOL = {')', '}', ']' }; 
   
	public static boolean isCorrectSyntax(String input){
		char[] inputAsArray = input.toCharArray();
		Stack<Character> stack = new Stack<Character>();
		
		for (char c : inputAsArray) {
		   if (isOpen( c )) {
		      stack.push( c );
		   }
		   else if (isClosed( c )) {
		      char open = stack.pop();
		      char closed = c;
		      
		      if (!openMatchesClosed(open, closed)) {
		         return false;
		      }
		   }
		}
		return stack.getLength() == 0;    // ensure nothing is left on the stack
	}
	
	private static boolean isOpen(char c) {
	   for (char open : OPEN_SYMBOL) {
	      if (c == open) {
	         return true;
	      }
	   }
	   return false;
	}
	
	private static boolean isClosed(char c) {
	   for (char closed : CLOSED_SYMBOL) {
	      if (c == closed) {
	         return true;
	      }
	   }
	   return false;
	}
	
	// check what position the open char is on the OPEN_SYMBOL 
	// char array. the closed char should match the same position in
	// the CLOSED_SYMBOL array.
	private static boolean openMatchesClosed(char open, char closed) {
	   int openPos = 0;
	   for (char c : OPEN_SYMBOL) {
	      if (c == open) {
	         break;
	      }
	      openPos++;
	   }
	   
	   return closed == CLOSED_SYMBOL[openPos];
	}
}
