package com.cnc.algorithms.strings;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a URL as input "http://localhost/mysite?foo=bar&bar=foo
 * Return a map of the query parameters
 * <p>
 * Considerations:
 * -multiple values for a single key
 *
 * @author Evan Harris
 */
public class QueryParamFinder {

    public static Map<String, String> getQueryParams(String url) {
        Map<String, String> result = new HashMap<>();
        if (url == null || !url.contains("?")) {
            return result;
        }

        String[] queryStrings = url.split("\\?");
        if(queryStrings.length > 2) {
            throw new IllegalArgumentException("Invalid url. Contains multiple ?");
        }

        if(queryStrings.length > 1) {
            for (String keyValPair : queryStrings[1].split("&")) {
                String[] keyVal = keyValPair.split("=");
                if(keyVal.length == 2) {
                    result.put(keyVal[0], keyVal[1]);
                }
                else {
                    result.put(keyVal[0], null);
                }

            }
        }
        return result;
    }

}
