package com.csc301.songmicroservice;

import com.mongodb.client.result.DeleteResult;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@Repository
public class SongDalImpl_addSong_144dbf05b2_Test {

    @InjectMocks
    SongDalImpl songDal;

    @Mock
    MongoTemplate db;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddSongSuccess() {
        Song song = new Song("Test Song", "Test Album", "Test Artist");
        when(db.insert(song, "songs")).thenReturn(song);

        DbQueryStatus result = songDal.addSong(song);
        // Removed the non-existing method calls and replaced with appropriate ones
        assertEquals(DbQueryStatus.DbQueryType.POST, result.getQueryType());
        assertEquals(DbQueryStatus.DbQueryStatusType.OK, result.getStatusType());
        assertEquals(song.getJsonRepresentation(), result.getData());

        verify(db, times(1)).insert(song, "songs");
    }

    @Test
    public void testAddSongFailure() {
        Song song = new Song(null, "Test Album", "Test Artist");

        DbQueryStatus result = songDal.addSong(song);
        // Removed the non-existing method calls and replaced with appropriate ones
        assertEquals(DbQueryStatus.DbQueryType.POST, result.getQueryType());
        assertEquals(DbQueryStatus.DbQueryStatusType.ERR, result.getStatusType());
        assertEquals(null, result.getData());

        verify(db, times(0)).insert(song, "songs");
    }
}
