package com.csc301.songmicroservice;

import com.mongodb.client.result.DeleteResult;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class SongDalImpl_findSongById_6f9f7d63a3_Test {

    @Autowired
    private SongDalImpl songDal;

    @Mock
    private MongoTemplate db;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        songDal = new SongDalImpl(db);
    }

    @Test
    public void testFindSongById_validId() {
        String songId = "5f9f7d63a3";
        Song song = new Song("Test Song", "Test Artist", "Test Album");

        when(db.findById(new ObjectId(songId), Song.class)).thenReturn(song);

        DbQueryStatus result = songDal.findSongById(songId);
        assertEquals(DbQueryStatus.GET, result.getOperation());
        assertEquals(DbQueryStatus.OK, result.getStatus());
        assertEquals(song.getJsonRepresentation(), result.getData());
    }

    @Test
    public void testFindSongById_invalidId() {
        String songId = "5f9f7d63a3";
        when(db.findById(new ObjectId(songId), Song.class)).thenReturn(null);

        DbQueryStatus result = songDal.findSongById(songId);
        assertEquals(DbQueryStatus.GET, result.getOperation());
        assertEquals(DbQueryStatus.ERR404, result.getStatus());
    }

    @Test
    public void testFindSongById_exceptionThrown() {
        String songId = "invalid_id";

        DbQueryStatus result = songDal.findSongById(songId);
        assertEquals(DbQueryStatus.GET, result.getOperation());
        assertEquals(DbQueryStatus.ERR, result.getStatus());
    }
}
