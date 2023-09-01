package com.csc301.profilemicroservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.Session;
import org.neo4j.driver.v1.Transaction;
import org.neo4j.driver.v1.exceptions.ConstraintViolationException;

public class ProfileDriverImpl_InitProfileDb_644c73bfe7_Test {

    private Driver driver;
    private Session session;
    private Transaction transaction;

    @BeforeEach
    public void setup() {
        driver = mock(Driver.class);
        session = mock(Session.class);
        transaction = mock(Transaction.class);

        when(driver.session()).thenReturn(session);
        when(session.beginTransaction()).thenReturn(transaction);

        ProfileMicroserviceApplication.driver = driver;
    }

    @Test
    public void InitProfileDb_Success() {
        ProfileDriverImpl.InitProfileDb();

        verify(driver, times(1)).session();
        verify(session, times(1)).beginTransaction();
        verify(transaction, times(3)).run("CREATE CONSTRAINT ON (nProfile:profile) ASSERT exists(nProfile.userName)");
        verify(transaction, times(3)).run("CREATE CONSTRAINT ON (nProfile:profile) ASSERT exists(nProfile.password)");
        verify(transaction, times(3)).run("CREATE CONSTRAINT ON (nProfile:profile) ASSERT nProfile.userName IS UNIQUE");
        verify(transaction, times(1)).success();
        verify(session, times(1)).close();
    }

    @Test
    public void InitProfileDb_Failure() {
        when(transaction.run("CREATE CONSTRAINT ON (nProfile:profile) ASSERT exists(nProfile.userName)")).thenThrow(ConstraintViolationException.class);

        try {
            ProfileDriverImpl.InitProfileDb();
        } catch (ConstraintViolationException e) {
            assertEquals("Constraint violation exception occurred", e.getMessage());
        }

        verify(driver, times(1)).session();
        verify(session, times(1)).beginTransaction();
        verify(transaction, times(1)).run("CREATE CONSTRAINT ON (nProfile:profile) ASSERT exists(nProfile.userName)");
        verify(session, times(1)).close();
    }
}
