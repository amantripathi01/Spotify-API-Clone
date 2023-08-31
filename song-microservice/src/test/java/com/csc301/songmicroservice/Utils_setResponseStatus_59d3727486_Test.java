package com.csc301.songmicroservice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class Utils_setResponseStatus_59d3727486_Test {

    private Map<String, Object> response;

    @BeforeEach
    public void setUp() {
        response = new HashMap<>();
    }

    @Test
    public void testSetResponseStatus_QUERY_OK() {
        String data = "test data";
        Utils.setResponseStatus(response, DbQueryExecResult.QUERY_OK, data);

        assertEquals(HttpStatus.OK, response.get("status"));
        assertEquals(data, response.get("data"));
    }

    @Test
    public void testSetResponseStatus_QUERY_OK_NoData() {
        Utils.setResponseStatus(response, DbQueryExecResult.QUERY_OK, null);

        assertEquals(HttpStatus.OK, response.get("status"));
        assertNull(response.get("data"));
    }

    @Test
    public void testSetResponseStatus_QUERY_ERROR_NOT_FOUND() {
        Utils.setResponseStatus(response, DbQueryExecResult.QUERY_ERROR_NOT_FOUND, null);

        assertEquals(HttpStatus.NOT_FOUND, response.get("status"));
        assertNull(response.get("data"));
    }

    @Test
    public void testSetResponseStatus_QUERY_ERROR_GENERIC() {
        Utils.setResponseStatus(response, DbQueryExecResult.QUERY_ERROR_GENERIC, null);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.get("status"));
        assertNull(response.get("data"));
    }
}
