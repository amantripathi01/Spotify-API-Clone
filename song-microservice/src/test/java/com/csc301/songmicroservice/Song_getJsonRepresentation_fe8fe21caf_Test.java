package com.csc301.songmicroservice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Map;

public class Song_getJsonRepresentation_fe8fe21caf_Test {

    @Mock
    private Song song;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        when(song.getId()).thenReturn("123");
        when(song.getSongName()).thenReturn("Test Song");
        when(song.getSongArtistFullName()).thenReturn("Test Artist");
        when(song.getSongAlbum()).thenReturn("Test Album");
        when(song.getSongAmountFavourites()).thenReturn("100");
    }

    @Test
    public void testGetJsonRepresentation() {
        Map<String, String> jsonRepresentation = song.getJsonRepresentation();

        assertEquals("123", jsonRepresentation.get("id"));
        assertEquals("Test Song", jsonRepresentation.get("songName"));
        assertEquals("Test Artist", jsonRepresentation.get("songArtistFullName"));
        assertEquals("Test Album", jsonRepresentation.get("songAlbum"));
        assertEquals("100", jsonRepresentation.get("songAmountFavourites"));
    }

    @Test
    public void testGetJsonRepresentationWithEmptyData() {
        when(song.getId()).thenReturn("");
        when(song.getSongName()).thenReturn("");
        when(song.getSongArtistFullName()).thenReturn("");
        when(song.getSongAlbum()).thenReturn("");
        when(song.getSongAmountFavourites()).thenReturn("0");

        Map<String, String> jsonRepresentation = song.getJsonRepresentation();

        assertEquals("", jsonRepresentation.get("id"));
        assertEquals("", jsonRepresentation.get("songName"));
        assertEquals("", jsonRepresentation.get("songArtistFullName"));
        assertEquals("", jsonRepresentation.get("songAlbum"));
        assertEquals("0", jsonRepresentation.get("songAmountFavourites"));
    }
}
