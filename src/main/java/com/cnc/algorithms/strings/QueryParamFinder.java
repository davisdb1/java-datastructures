package com.cnc.algorithms.strings;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a URL as input "http://localhost/mysite?foo=bar&bar=foo
 * Return a map of the query parameters
 *
 * Considerations:
 * -multiple values for a single key
 * 
 *
 * @author Evan Harris
 */
public class QueryParamFinder {
    
    public static Map<String, String> getQueryParams(String url){
        Map<String, String> result = new HashMap<String, String>();
        if(url == null || !url.contains("?")){
            return result;
        }
        
        String queryString = url.split("\\?")[1]; 
        
        for(String keyValPair : queryString.split("&")){
            String[] keyVal = keyValPair.split("=");
            result.put(keyVal[0], keyVal[1]);
        }
        
        return result;
    } 

}
