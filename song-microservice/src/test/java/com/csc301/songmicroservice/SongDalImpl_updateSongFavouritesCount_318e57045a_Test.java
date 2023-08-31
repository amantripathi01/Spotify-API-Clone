package com.csc301.songmicroservice;

import com.mongodb.client.result.DeleteResult;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class SongDalImpl_updateSongFavouritesCount_318e57045a_Test {

    @Mock
    private MongoTemplate db;

    @InjectMocks
    private SongDalImpl songDalImpl;

    private Song song;

    @BeforeEach
    public void setup() {
        song = new Song("title", "artist", "album");
        song.setSongAmountFavourites(10);
    }

    @Test
    public void testUpdateSongFavouritesCount_ShouldIncrement() {
        ObjectId _id = new ObjectId();
        Mockito.when(db.findById(_id, Song.class)).thenReturn(song);
        Mockito.when(db.save(song)).thenReturn(song);

        DbQueryStatus status = songDalImpl.updateSongFavouritesCount(_id.toHexString(), false);

        assertEquals("PUT", status.getDbQueryMethod());
        assertEquals("OK", status.getDbQueryExecResult());
        assertEquals(11, song.getSongAmountFavourites());
    }

    @Test
    public void testUpdateSongFavouritesCount_ShouldDecrement() {
        ObjectId _id = new ObjectId();
        Mockito.when(db.findById(_id, Song.class)).thenReturn(song);
        Mockito.when(db.save(song)).thenReturn(song);

        DbQueryStatus status = songDalImpl.updateSongFavouritesCount(_id.toHexString(), true);

        assertEquals("PUT", status.getDbQueryMethod());
        assertEquals("OK", status.getDbQueryExecResult());
        assertEquals(9, song.getSongAmountFavourites());
    }

    @Test
    public void testUpdateSongFavouritesCount_SongNotFound() {
        ObjectId _id = new ObjectId();
        Mockito.when(db.findById(_id, Song.class)).thenReturn(null);

        DbQueryStatus status = songDalImpl.updateSongFavouritesCount(_id.toHexString(), true);

        assertEquals("PUT", status.getDbQueryMethod());
        assertEquals("ERR404", status.getDbQueryExecResult());
    }

    @Test
    public void testUpdateSongFavouritesCount_ExceptionThrown() {
        ObjectId _id = new ObjectId();
        Mockito.when(db.findById(_id, Song.class)).thenThrow(new RuntimeException());

        DbQueryStatus status = songDalImpl.updateSongFavouritesCount(_id.toHexString(), true);

        assertEquals("PUT", status.getDbQueryMethod());
        assertEquals("ERR", status.getDbQueryExecResult());
    }
}
