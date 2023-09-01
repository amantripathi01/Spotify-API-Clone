package com.csc301.profilemicroservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.Session;
import org.neo4j.driver.v1.StatementResult;
import org.neo4j.driver.v1.Transaction;

public class ProfileDriverImpl_getAllSongFriendsLike_2f93544e3f_Test {

    private Driver driver;
    private Session session;
    private Transaction transaction;
    private StatementResult result;
    private ProfileDriverImpl profileDriver;

    @BeforeEach
    public void setup() {
        driver = mock(Driver.class);
        session = mock(Session.class);
        transaction = mock(Transaction.class);
        result = mock(StatementResult.class);
        profileDriver = new ProfileDriverImpl(driver);
    }

    @Test
    public void testGetAllSongFriendsLike_UserDoesNotExist() {
        when(driver.session()).thenReturn(session);
        when(session.beginTransaction()).thenReturn(transaction);
        when(transaction.run(anyString(), anyMap())).thenReturn(result);
        when(result.hasNext()).thenReturn(false);

        DbQueryStatus dbQueryStatus = profileDriver.getAllSongFriendsLike("nonexistentUser");
        assertEquals(DbQueryExecResult.QUERY_ERROR_GENERIC, dbQueryStatus.getdbQueryExecResult());
    }

    @Test
    public void testGetAllSongFriendsLike_ValidUserNoSongs() {
        when(driver.session()).thenReturn(session);
        when(session.beginTransaction()).thenReturn(transaction);
        when(transaction.run(anyString(), anyMap())).thenReturn(result);
        when(result.hasNext()).thenReturn(true).thenReturn(false);

        DbQueryStatus dbQueryStatus = profileDriver.getAllSongFriendsLike("validUser");
        assertEquals(DbQueryExecResult.QUERY_OK, dbQueryStatus.getdbQueryExecResult());
        assertTrue(((Map) dbQueryStatus.getData()).isEmpty());
    }

    // TODO: Add more test cases to cover all possible scenarios and edge cases
}
