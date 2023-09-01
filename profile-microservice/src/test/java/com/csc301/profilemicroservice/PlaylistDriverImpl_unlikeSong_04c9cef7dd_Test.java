package com.csc301.profilemicroservice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.neo4j.driver.v1.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class PlaylistDriverImpl_unlikeSong_04c9cef7dd_Test {

    @Mock
    Driver driver;
    @Mock
    Session session;
    @Mock
    Transaction transaction;
    @Mock
    StatementResult statementResult;

    @InjectMocks
    PlaylistDriverImpl playlistDriver;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testUnlikeSongSuccess() {
        when(driver.session()).thenReturn(session);
        when(session.beginTransaction()).thenReturn(transaction);
        when(transaction.run(anyString(), anyMap())).thenReturn(statementResult);
        when(statementResult.hasNext()).thenReturn(true);

        DbQueryStatus status = playlistDriver.unlikeSong("testUser", "testSongId");

        assertEquals(DbQueryExecResult.QUERY_OK, status.getdbQueryExecResult());
    }

    @Test
    public void testUnlikeSongFailure() {
        when(driver.session()).thenReturn(session);
        when(session.beginTransaction()).thenReturn(transaction);
        when(transaction.run(anyString(), anyMap())).thenReturn(statementResult);
        when(statementResult.hasNext()).thenReturn(false);

        DbQueryStatus status = playlistDriver.unlikeSong("testUser", "testSongId");

        assertEquals(DbQueryExecResult.QUERY_ERROR_GENERIC, status.getdbQueryExecResult());
    }

    @Test
    public void testUnlikeSongException() {
        when(driver.session()).thenThrow(new RuntimeException());

        DbQueryStatus status = playlistDriver.unlikeSong("testUser", "testSongId");

        assertEquals(DbQueryExecResult.QUERY_ERROR_GENERIC, status.getdbQueryExecResult());
    }
}
