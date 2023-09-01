package com.csc301.profilemicroservice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.neo4j.driver.v1.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ProfileDriverImpl_createUserProfile_e287b9a3ae_Test {

    @InjectMocks
    ProfileDriverImpl profileDriver;

    @Mock
    Driver driver;

    @Mock
    Session session;

    @Mock
    Transaction transaction;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreateUserProfile_success() {
        when(driver.session()).thenReturn(session);
        when(session.writeTransaction(any(TransactionWork.class))).thenAnswer(new Answer<StatementResult>() {
            public StatementResult answer(InvocationOnMock invocation) throws Throwable {
                return null;
            }
        });
        DbQueryStatus result = profileDriver.createUserProfile("testUser", "testName", "testPass");
        assertEquals(DbQueryExecResult.QUERY_OK, result.getdbQueryExecResult());
    }

    @Test
    public void testCreateUserProfile_failed() {
        when(driver.session()).thenReturn(session);
        when(session.writeTransaction(any(TransactionWork.class))).thenThrow(new RuntimeException());
        DbQueryStatus result = profileDriver.createUserProfile("testUser", "testName", "testPass");
        assertEquals(DbQueryExecResult.QUERY_ERROR_GENERIC, result.getdbQueryExecResult());
    }

    @Test
    public void testCreateUserProfile_nullParameter() {
        DbQueryStatus result = profileDriver.createUserProfile(null, "testName", "testPass");
        assertEquals(DbQueryExecResult.QUERY_ERROR_GENERIC, result.getdbQueryExecResult());
    }
}
