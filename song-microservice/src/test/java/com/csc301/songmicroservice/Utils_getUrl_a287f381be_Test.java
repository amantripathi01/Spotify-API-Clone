package com.csc301.songmicroservice;

import javax.servlet.http.HttpServletRequest;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class Utils_getUrl_a287f381be_Test {

    @Test
    public void testGetUrlWithQueryString() {
        HttpServletRequest req = mock(HttpServletRequest.class);
        when(req.getRequestURL()).thenReturn(new StringBuffer("http://localhost:8080/test"));
        when(req.getQueryString()).thenReturn("param1=value1&param2=value2");

        String expected = "http://localhost:8080/test?param1=value1&param2=value2";
        String actual = Utils.getUrl(req);

        assertEquals(expected, actual);
    }

    @Test
    public void testGetUrlWithoutQueryString() {
        HttpServletRequest req = mock(HttpServletRequest.class);
        when(req.getRequestURL()).thenReturn(new StringBuffer("http://localhost:8080/test"));
        when(req.getQueryString()).thenReturn(null);

        String expected = "http://localhost:8080/test";
        String actual = Utils.getUrl(req);

        assertEquals(expected, actual);
    }
}
