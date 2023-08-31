package com.csc301.songmicroservice;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Song_getSongArtistFullName_6491ebabf6_Test {

    @Mock
    private Song song;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        song = new Song("Song Title", "Song Album", "John Doe");
    }

    @Test
    public void testGetSongArtistFullName_Valid() {
        song.setSongArtistFullName("John Doe");
        assertEquals("John Doe", song.getSongArtistFullName());
    }

    @Test
    public void testGetSongArtistFullName_Empty() {
        song.setSongArtistFullName("");
        assertEquals("", song.getSongArtistFullName());
    }
}
