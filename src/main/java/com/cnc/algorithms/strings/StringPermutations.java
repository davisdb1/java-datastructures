package com.cnc.algorithms.strings;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


/*
 * Given a string, find all the permutations of the string
 * Example:
 *
 * ABC
 * ACB
 * BAC
 * BCA
 * CAB
 * CBA
 *
 * O(N!)
 *
 *
 * The approach here to permute a string build a tree of combinations using the "prefix" string.
 * When the prefix is fully built out, then the permutation is considered complete.
 *
 * The stack trace and value of the prefix can be visualized like this
 *
 * Input String "ABC"
 *
 *                              ""                        // prefix starts blank
 *                  /           |           \
 *                 A             B           C            // one additional letter from str is added to prefix, str size decreases by 1 as prefix increases
 *               /   \        /    \       /     \
 *              AB   AC      BA    BC     CA     CB       // and so on
 *             /       \     /      \    /        \
 *            ABC    ACB   BAC     BCA  CAB      CBA      // base case hit, input str.length() == 0
 *
 *
 */
public class StringPermutations {

    public static void permutation(String str, Optional<List<String>> resultSet) {
        permutation("", str, resultSet);
    }

    private static void permutation(String prefix, String str, Optional<List<String>> resultSet) {
        int n = str.length();
        if (n == 0) {
            System.out.println(prefix);
            resultSet.ifPresent( x -> x.add(prefix));
        }
        else {
            for (int i = 0; i < n; i++)
                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n), resultSet);
        }
    }

    public List<String> getPermutations(String word) {
        List<String> resultSet = new ArrayList<>();
        permutation(word, Optional.of(resultSet));
        return resultSet;
    }

}
