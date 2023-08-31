package com.csc301.songmicroservice;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DbQueryStatus_setMessage_a4320850bf_Test {

    @Test
    public void testSetMessage() {
        DbQueryExecResult execResult = new DbQueryExecResult();
        DbQueryStatus dbQueryStatus = new DbQueryStatus("Test message", execResult);
        String expectedMessage = "Test message";
        
        dbQueryStatus.setMessage(expectedMessage);
        
        assertEquals(expectedMessage, dbQueryStatus.getMessage());
    }

    @Test
    public void testSetEmptyMessage() {
        DbQueryExecResult execResult = new DbQueryExecResult();
        DbQueryStatus dbQueryStatus = new DbQueryStatus("", execResult);
        String expectedMessage = "";
        
        dbQueryStatus.setMessage(expectedMessage);
        
        assertEquals(expectedMessage, dbQueryStatus.getMessage());
    }

    @Test
    public void testSetNullMessage() {
        DbQueryExecResult execResult = new DbQueryExecResult();
        DbQueryStatus dbQueryStatus = new DbQueryStatus(null, execResult);
        String expectedMessage = null;
        
        dbQueryStatus.setMessage(expectedMessage);
        
        assertEquals(expectedMessage, dbQueryStatus.getMessage());
    }
}
