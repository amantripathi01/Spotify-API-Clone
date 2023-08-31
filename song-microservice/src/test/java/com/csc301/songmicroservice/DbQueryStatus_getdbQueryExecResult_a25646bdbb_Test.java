package com.csc301.songmicroservice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class DbQueryStatus_getdbQueryExecResult_a25646bdbb_Test {

    private DbQueryStatus dbQueryStatus;
    private DbQueryExecResult dbQueryExecResult;

    @BeforeEach
    public void setUp() {
        dbQueryStatus = Mockito.mock(DbQueryStatus.class);
        dbQueryExecResult = Mockito.mock(DbQueryExecResult.class);
        when(dbQueryStatus.getdbQueryExecResult()).thenReturn(dbQueryExecResult);
    }

    @Test
    public void testGetDbQueryExecResultSuccess() {
        DbQueryExecResult result = dbQueryStatus.getdbQueryExecResult();
        assertEquals(dbQueryExecResult, result, "Expected DbQueryExecResult does not match actual DbQueryExecResult");
    }

    @Test
    public void testGetDbQueryExecResultFailure() {
        when(dbQueryStatus.getdbQueryExecResult()).thenReturn(null);
        DbQueryExecResult result = dbQueryStatus.getdbQueryExecResult();
        assertEquals(null, result, "Expected null DbQueryExecResult, but actual is not null");
    }
}
