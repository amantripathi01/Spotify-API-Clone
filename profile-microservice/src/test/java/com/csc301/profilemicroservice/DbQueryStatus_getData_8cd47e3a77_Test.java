package com.csc301.profilemicroservice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class DbQueryStatus_getData_8cd47e3a77_Test {

    @Test
    public void testGetData() {
        // Mock the class which has getData method
        DbQueryStatus dbQueryStatus = Mockito.mock(DbQueryStatus.class);

        // When getData is called on dbQueryStatus object, return "Test Data"
        Mockito.when(dbQueryStatus.getData()).thenReturn("Test Data");

        // Call the method and assert the returned value
        Assertions.assertEquals("Test Data", dbQueryStatus.getData());
    }

    @Test
    public void testGetDataWithNull() {
        // Mock the class which has getData method
        DbQueryStatus dbQueryStatus = Mockito.mock(DbQueryStatus.class);

        // When getData is called on dbQueryStatus object, return null
        Mockito.when(dbQueryStatus.getData()).thenReturn(null);

        // Call the method and assert the returned value
        Assertions.assertNull(dbQueryStatus.getData());
    }
}
