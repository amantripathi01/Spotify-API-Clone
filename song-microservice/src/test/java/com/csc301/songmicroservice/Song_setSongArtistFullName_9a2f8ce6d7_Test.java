package com.csc301.songmicroservice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Song_setSongArtistFullName_9a2f8ce6d7_Test {

    private Song song;

    @BeforeEach
    public void setup() {
        song = new Song("Song Title", "Song Album", "Song Artist");
    }

    @Test
    public void testSetSongArtistFullName_Success() {
        String songArtistFullName = "John Doe";
        song.setSongArtistFullName(songArtistFullName);
        assertEquals(songArtistFullName, song.getSongArtistFullName(), "The artist full name should match the set value");
    }

    @Test
    public void testSetSongArtistFullName_EmptyString() {
        String songArtistFullName = "";
        song.setSongArtistFullName(songArtistFullName);
        assertEquals(songArtistFullName, song.getSongArtistFullName(), "The artist full name should match the set value even if it is an empty string");
    }

    @Test
    public void testSetSongArtistFullName_Null() {
        String songArtistFullName = null;
        song.setSongArtistFullName(songArtistFullName);
        assertEquals(songArtistFullName, song.getSongArtistFullName(), "The artist full name should match the set value even if it is null");
    }
}
