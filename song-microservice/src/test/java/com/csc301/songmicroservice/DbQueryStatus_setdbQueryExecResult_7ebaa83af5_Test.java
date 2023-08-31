package com.csc301.songmicroservice;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DbQueryStatus_setdbQueryExecResult_7ebaa83af5_Test {

    @Test
    public void testSetDbQueryExecResultNonNull() {
        DbQueryExecResult dbQueryExecResult = Mockito.mock(DbQueryExecResult.class);
        DbQueryStatus dbQueryStatus = new DbQueryStatus("message", dbQueryExecResult);

        // You may need to replace 'setdbQueryExecResult' and 'getDbQueryExecResult' with the actual method names in your DbQueryStatus class
        dbQueryStatus.setdbQueryExecResult(dbQueryExecResult);
        assertEquals(dbQueryExecResult, dbQueryStatus.getDbQueryExecResult());
    }

    @Test
    public void testSetDbQueryExecResultNull() {
        DbQueryExecResult dbQueryExecResult = Mockito.mock(DbQueryExecResult.class);
        DbQueryStatus dbQueryStatus = new DbQueryStatus("message", dbQueryExecResult);

        dbQueryStatus.setdbQueryExecResult(null);
        assertNull(dbQueryStatus.getDbQueryExecResult());
    }
}
