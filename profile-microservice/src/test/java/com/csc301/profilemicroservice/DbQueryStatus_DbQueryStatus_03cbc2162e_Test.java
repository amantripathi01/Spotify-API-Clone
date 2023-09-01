// Test generated by RoostGPT for test spotifyApi-Test using AI Type Open AI and AI Model gpt-4

package com.csc301.profilemicroservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DbQueryStatus_DbQueryStatus_03cbc2162e_Test {

    private DbQueryStatus dbQueryStatus;
    private DbQueryExecResult dbQueryExecResult;

    @BeforeEach
    public void setUp() {
        dbQueryExecResult = mock(DbQueryExecResult.class); // mocking DbQueryExecResult
    }

    @Test
    public void testDbQueryStatusSuccessCase() {
        String message = "Success";
        dbQueryStatus = new DbQueryStatus(message, dbQueryExecResult);

        assertEquals(message, dbQueryStatus.getMessage());
        assertEquals(dbQueryExecResult, dbQueryStatus.getDbQueryExecResult());
    }

    @Test
    public void testDbQueryStatusFailureCase() {
        String message = "Failure";
        dbQueryStatus = new DbQueryStatus(message, dbQueryExecResult);

        assertEquals(message, dbQueryStatus.getMessage());
        assertEquals(dbQueryExecResult, dbQueryStatus.getDbQueryExecResult());
    }
}
