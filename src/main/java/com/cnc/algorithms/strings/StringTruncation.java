package com.cnc.algorithms.strings;

public class StringTruncation {


    /**
     * When you search for a web site in google, each page title is
     * restricted by length. At the same time, google is careful not
     * cut off half of a word for a search result. Implement a search
     * result formatter.
     * <p/>
     * <p/>
     * important tests to think about
     * <p/>
     * length is greater than string len
     * no spaces and string is longer than length
     * multiple spaces between words, what to do?
     *
     * @param title  the title to truncate
     * @param length the max allowed length of the title
     * @return the truncated title
     */
    public static String getGoogleSeachTitle(String title, int length) {
        if (title == null || title.length() <= length) {
            return title;
        } else {
            char[] titleCharArray = title.toCharArray();
            int indexToConcat = length;
            for (int i = length; i >= 0; i--) {
                if (titleCharArray[i] == ' ') {
                    indexToConcat = i;
                    break;
                }
            }
            return title.substring(0, indexToConcat);
        }
    }
}
  
