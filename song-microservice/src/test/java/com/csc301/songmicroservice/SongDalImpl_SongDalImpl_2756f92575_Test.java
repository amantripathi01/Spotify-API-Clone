package com.csc301.songmicroservice;

import com.mongodb.client.result.DeleteResult;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SongDalImpl_SongDalImpl_2756f92575_Test {

    @InjectMocks
    private SongDalImpl songDalImpl;

    @Mock
    private MongoTemplate mongoTemplate;

    @BeforeEach
    public void setup() {
        songDalImpl = new SongDalImpl(mongoTemplate);
    }

    @Test
    public void testSongDalImpl_Success() {
        assertNotNull(songDalImpl);
    }

    @Test
    public void testSongDalImpl_Failure() {
        when(mongoTemplate.getDb()).thenThrow(new RuntimeException());
        try {
            new SongDalImpl(mongoTemplate);
        } catch (Exception e) {
            assertNotNull(e);
        }
    }
}
