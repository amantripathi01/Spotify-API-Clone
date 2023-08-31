package com.csc301.songmicroservice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Song_getSongName_95fc08cdb5_Test {

    private Song song;

    @BeforeEach
    public void setup() {
        // TODO: Replace "Test Song", "Test Artist", "Test Album" with the actual song name, artist name, and album name you want to test
        song = new Song("Test Song", "Test Artist", "Test Album");
    }

    @Test
    public void testGetSongName_WhenSongNameIsSet_ShouldReturnCorrectSongName() {
        // TODO: Replace "Test Song" with the actual song name you want to test
        String expectedSongName = "Test Song";
        song.setSongName(expectedSongName);
        
        String actualSongName = song.getSongName();

        assertEquals(expectedSongName, actualSongName, "The returned song name should match the expected song name");
    }

    @Test
    public void testGetSongName_WhenSongNameIsNotSet_ShouldReturnNull() {
        // Reset song name to null
        song.setSongName(null);
        
        String actualSongName = song.getSongName();

        assertEquals(null, actualSongName, "The returned song name should be null as it is not set");
    }
}
