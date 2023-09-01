package com.csc301.profilemicroservice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.Session;
import org.neo4j.driver.v1.Transaction;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class PlaylistDriverImpl_addSong_b9e2570241_Test {

    @Mock
    private Driver driver;

    @Mock
    private Session session;

    @Mock
    private Transaction transaction;

    @InjectMocks
    private PlaylistDriverImpl playlistDriverImpl;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        when(driver.session()).thenReturn(session);
        when(session.beginTransaction()).thenReturn(transaction);
    }

    @Test
    public void testAddSong_Success() {
        String songId = "songId1";
        String songName = "songName1";

        DbQueryStatus dbQueryStatus = playlistDriverImpl.addSong(songId, songName);

        assertEquals("POST", dbQueryStatus.getdbQueryMethod());
        assertEquals(DbQueryExecResult.QUERY_OK, dbQueryStatus.getdbQueryExecResult());
    }

    @Test
    public void testAddSong_Failure() {
        String songId = "songId2";
        String songName = "songName2";

        when(transaction.run(Mockito.anyString())).thenThrow(new RuntimeException());

        DbQueryStatus dbQueryStatus = playlistDriverImpl.addSong(songId, songName);

        assertEquals("POST", dbQueryStatus.getdbQueryMethod());
        assertEquals(DbQueryExecResult.QUERY_ERROR_GENERIC, dbQueryStatus.getdbQueryExecResult());
    }
}
