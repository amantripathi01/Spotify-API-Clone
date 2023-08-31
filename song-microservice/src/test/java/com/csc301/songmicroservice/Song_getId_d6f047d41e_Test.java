package com.csc301.songmicroservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.bson.types.ObjectId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Song_getId_d6f047d41e_Test {
    
    private Song song;
    private ObjectId objectId;

    @BeforeEach
    public void setup() {
        objectId = new ObjectId();
        song = mock(Song.class);
        when(song.getId()).thenReturn(objectId.toHexString());
    }

    @Test
    public void testGetIdSuccess() {
        String expectedId = objectId.toHexString();
        String actualId = song.getId();
        assertEquals(expectedId, actualId, "The expected ID does not match the actual ID");
    }

    @Test
    public void testGetIdFailure() {
        String unexpectedId = new ObjectId().toHexString();
        String actualId = song.getId();
        assertEquals(false, unexpectedId.equals(actualId), "The ID was not expected to match");
    }
}
