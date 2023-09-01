package com.csc301.profilemicroservice;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class DbQueryStatus_setData_e6413ffb52_Test {

    private DbQueryStatus dbQueryStatus;

    @Before
    public void setUp() {
        this.dbQueryStatus = new DbQueryStatus();
    }

    @Test
    public void testSetDataWithNullObject() {
        dbQueryStatus.setData(null);
        assertNull("The data should be null", dbQueryStatus.getData());
    }

    @Test
    public void testSetDataWithNonNullObject() {
        Object obj = new Object();
        dbQueryStatus.setData(obj);
        assertEquals("The data should be the same as the object set", obj, dbQueryStatus.getData());
    }

    @Test
    public void testSetDataWithDifferentObjects() {
        Object obj1 = new Object();
        Object obj2 = new Object();

        dbQueryStatus.setData(obj1);
        assertNotEquals("The data should not be the same as a different object", obj2, dbQueryStatus.getData());

        dbQueryStatus.setData(obj2);
        assertEquals("The data should be the same as the object set last", obj2, dbQueryStatus.getData());
    }
}
