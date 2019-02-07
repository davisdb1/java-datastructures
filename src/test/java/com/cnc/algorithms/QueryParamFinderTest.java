package com.cnc.algorithms;

import com.cnc.algorithms.strings.QueryParamFinder;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertEquals;

public class QueryParamFinderTest {


    @Test
    public void checkBasic() {
        Map<String, String> results = QueryParamFinder.getQueryParams("http://goo.gl?foo=bar");
        assertEquals(1, results.size());
        assertEquals("bar", results.get("foo"));
    }

    @Test
    public void testMultipleKeys() {
        Map<String, String> results = QueryParamFinder.getQueryParams("http://goo.gl?foo=bar&foo2=bar2");
        assertEquals(2, results.size());
        assertEquals("bar", results.get("foo"));
        assertEquals("bar2", results.get("foo2"));

    }

    @Test
    public void testNoQueryParams() {
        Map<String, String> results = QueryParamFinder.getQueryParams("http://goo.gl");
        assertEquals(0, results.size());
    }

    @Test
    public void testQueryParamsAtEnd() {
        Map<String, String> results = QueryParamFinder.getQueryParams("http://goo.gl?");
        assertEquals(0, results.size());
    }

    @Test
    public void testTrailingEqualSign() {
        Map<String, String> results = QueryParamFinder.getQueryParams("http://goo.gl?foo=bar&foo2=bar2&foo3=");
        assertEquals(3, results.size());
        assertEquals("bar", results.get("foo"));
        assertEquals("bar2", results.get("foo2"));
        assertEquals(null, results.get("foo3"));
    }

    @Test
    public void testNullString() {
        Map<String, String> results = QueryParamFinder.getQueryParams(null);
        assertEquals(0, results.size());

    }

}