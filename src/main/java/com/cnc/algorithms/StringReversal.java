package com.cnc.algorithms;

public class StringReversal {

  public static String reverse(String string) {
    if(string.length() < 2) {
      return string;
    }
    
    int last = string.length() - 1;
    char[] charArray = string.toCharArray();
    for(int i = 0 ; i < string.length()/2; i++) {
      char t = charArray[i];
      charArray[i] = charArray[last - i];
      charArray[last - i] = t;
    }
    return new String(charArray);
    
  }
    
    
}
