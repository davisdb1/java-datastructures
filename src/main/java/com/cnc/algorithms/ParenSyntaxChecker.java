package com.cnc.algorithms;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/*
 * Proper symbol nesting problem
 *
 * Check the syntax of string which contains chars such as: () {} [] to
 * make sure that each open symbol is matched with a closed symbol and
 * is properly nested.
 *
 */
public class ParenSyntaxChecker {

    private static Set<Character> opening;
    private static Set<Character> closing;
    private static HashMap<Character, Character> matching;

    static {
        opening = new HashSet<>();
        closing = new HashSet<>();
        matching = new HashMap<>();
        opening.add('(');
        opening.add('{');
        opening.add('[');

        closing.add(')');
        closing.add('}');
        closing.add(']');

        matching.put('(', ')');
        matching.put('{', '}');
        matching.put('[', ']');
    }

    public static boolean isCorrectSyntax(String input) {
        if (input == null || input.length() == 0) {
            return true;
        }
        char[] inputAsArray = input.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (char c : inputAsArray) {
            if (opening.contains(c)) {
                stack.push(c);
            }
            else if (closing.contains(c)) {
                if (stack.empty() || !matching.get(stack.pop())
                                              .equals(c)) {
                    return false;
                }
            }
        }
        return stack.empty();    // ensure nothing is left on the stack
    }

}
