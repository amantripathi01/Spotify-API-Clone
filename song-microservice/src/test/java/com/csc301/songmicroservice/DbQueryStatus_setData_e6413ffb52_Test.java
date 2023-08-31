package com.csc301.songmicroservice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class DbQueryStatus_setData_e6413ffb52_Test {

    private DbQueryStatus dbQueryStatus;

    @BeforeEach
    public void setup() {
        dbQueryStatus = new DbQueryStatus();
    }

    @Test
    public void testSetDataWithNonNullObject() {
        String testData = "Test Data";
        dbQueryStatus.setData(testData);
        Assertions.assertEquals(testData, dbQueryStatus.getData(), "Expected data does not match actual data");
    }

    @Test
    public void testSetDataWithNullObject() {
        dbQueryStatus.setData(null);
        Assertions.assertNull(dbQueryStatus.getData(), "Expected null but found some data");
    }
}
