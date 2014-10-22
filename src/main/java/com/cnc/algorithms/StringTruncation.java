package com.cnc.algorithms;

public class StringTruncation {

  
  /**
   * When you search for a web site in google, each page title is
   * restricted by length. At the same time, google is careful not
   * cut off half of a word for a search result. Implement a search
   * result formatter.
   * 
   * 
   * @param title
   * @param length
   * @return
   */
  public static String getGoogleSeachTitle(String title, int length) {
      
      if(title == null || title.length() <= length) {
        return title;
      }else {
        char[] titleCharArray = title.toCharArray();
        int indexToConcat = 0;
       
        
        for(int i= length - 1; i >= 0; i-- ) {
            if(titleCharArray[i] == ' ') {
              indexToConcat = i;
              break;
            }
          }
          
          if(indexToConcat > 0) {
            return title.substring(0, indexToConcat);
          }else {
            String tmp = title.substring(0, length);
            return tmp;
          }
          
        }
      }
    
 }
  
