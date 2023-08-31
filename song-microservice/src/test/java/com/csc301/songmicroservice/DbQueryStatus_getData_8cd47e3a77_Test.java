package com.csc301.songmicroservice;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class DbQueryStatus_getData_8cd47e3a77_Test {

    @Test
    public void testGetData() {
        DbQueryStatus dbQueryStatus = mock(DbQueryStatus.class);

        when(dbQueryStatus.getData()).thenReturn("Test Data");

        Object result = dbQueryStatus.getData();

        assertEquals("Test Data", result);
    }

    @Test
    public void testGetDataNull() {
        DbQueryStatus dbQueryStatus = mock(DbQueryStatus.class);

        when(dbQueryStatus.getData()).thenReturn(null);

        Object result = dbQueryStatus.getData();

        assertEquals(null, result);
    }
}
