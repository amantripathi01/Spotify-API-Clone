package com.csc301.songmicroservice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Song_setSongAlbum_75c893c7c8_Test {

    private Song song;

    @BeforeEach
    public void init() {
        song = new Song();
    }

    @Test
    public void testSetSongAlbum() {
        String songAlbum = "Test Album";
        song.setSongAlbum(songAlbum);
        assertEquals(songAlbum, song.getSongAlbum());
    }

    @Test
    public void testSetSongAlbumNull() {
        String songAlbum = null;
        song.setSongAlbum(songAlbum);
        assertEquals(songAlbum, song.getSongAlbum());
    }
}
