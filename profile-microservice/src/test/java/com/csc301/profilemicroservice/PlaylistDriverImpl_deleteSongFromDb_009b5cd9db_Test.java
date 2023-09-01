package com.csc301.profilemicroservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.Session;
import org.neo4j.driver.v1.StatementResult;
import org.neo4j.driver.v1.Transaction;

public class PlaylistDriverImpl_deleteSongFromDb_009b5cd9db_Test {

    @Mock
    private Driver driver;

    @Mock
    private Session session;

    @Mock
    private Transaction transaction;

    private PlaylistDriverImpl playlistDriverImpl;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        playlistDriverImpl = new PlaylistDriverImpl(driver);
        when(driver.session()).thenReturn(session);
        when(session.writeTransaction(any(TransactionWork.class))).thenReturn(transaction);
    }

    @Test
    public void testDeleteSongFromDb_Success() {
        DbQueryStatus result = playlistDriverImpl.deleteSongFromDb("song1");
        assertEquals(DbQueryExecResult.QUERY_OK, result.getdbQueryExecResult());
    }

    @Test
    public void testDeleteSongFromDb_Failure() {
        when(session.writeTransaction(any(TransactionWork.class))).thenThrow(new RuntimeException());
        DbQueryStatus result = playlistDriverImpl.deleteSongFromDb("song1");
        assertEquals(DbQueryExecResult.QUERY_ERROR_GENERIC, result.getdbQueryExecResult());
    }
}
