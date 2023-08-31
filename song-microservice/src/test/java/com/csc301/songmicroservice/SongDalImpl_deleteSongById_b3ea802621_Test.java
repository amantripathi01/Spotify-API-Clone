package com.csc301.songmicroservice;

import com.mongodb.client.result.DeleteResult;
import org.bson.types.ObjectId;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class SongDalImpl_deleteSongById_b3ea802621_Test {

    @InjectMocks
    SongDalImpl songDal;

    @Mock
    MongoTemplate mongoTemplate;

    @Mock
    DeleteResult deleteResult;

    @Before
    public void setUp() {
        songDal = new SongDalImpl(mongoTemplate);
    }

    @Test
    public void testDeleteSongById_Success() {
        Song song = new Song();
        when(mongoTemplate.findById(any(ObjectId.class), eq(Song.class))).thenReturn(song);
        when(mongoTemplate.remove(any(Query.class), eq("songs"))).thenReturn(deleteResult);
        when(deleteResult.wasAcknowledged()).thenReturn(true);

        DbQueryStatus result = songDal.deleteSongById("5f8d30a0702d2a4b8c471f9e");
        assertEquals("DELETE", result.getdbQueryMethod());
        assertEquals(DbQueryStatus.OK, result.getdbQueryExecResult());
    }

    @Test
    public void testDeleteSongById_Failure() {
        when(mongoTemplate.findById(any(ObjectId.class), eq(Song.class))).thenReturn(null);

        DbQueryStatus result = songDal.deleteSongById("5f8d30a0702d2a4b8c471f9e");
        assertEquals("DELETE", result.getdbQueryMethod());
        assertEquals(DbQueryStatus.ERR404, result.getdbQueryExecResult());
    }

}
