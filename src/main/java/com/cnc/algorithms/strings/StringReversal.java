package com.cnc.algorithms.strings;

public class StringReversal {

  public static String reverse(String string) {
    if (string == null || string.equals("")) {
      return string;
    }
    int length = string.length();
    char[] inCharArray = string.toCharArray();
    for (int i = 0; i < length / 2; ++i) {
      char c = inCharArray[i];
      inCharArray[i] = inCharArray[length - 1 - i];
      inCharArray[length - 1 - i] = c;
    }
    return new String(inCharArray);

  }
}
