package com.csc301.songmicroservice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;

public class Song_getSongAlbum_fc7b2cc8e7_Test {

    @Mock
    private Song song;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetSongAlbum() {
        // Set an album name
        String expectedAlbum = "Test Album";
        when(song.getSongAlbum()).thenReturn(expectedAlbum);
        
        // Call the method under test
        String actualAlbum = song.getSongAlbum();
        
        // Assert that the returned album name is as expected
        Assertions.assertEquals(expectedAlbum, actualAlbum);
    }

    @Test
    public void testGetSongAlbumWhenAlbumIsNull() {
        // Set the album name to null
        when(song.getSongAlbum()).thenReturn(null);
        
        // Call the method under test
        String actualAlbum = song.getSongAlbum();
        
        // Assert that the returned album name is null
        Assertions.assertNull(actualAlbum);
    }
}
