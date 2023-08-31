package com.csc301.songmicroservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Song_Song_40793916e6_Test {

    private Song song;

    @BeforeEach
    public void setup() {
        song = new Song();
        song.setSongName("Test Song");
        song.setSongArtistFullName("Test Artist");
        song.setSongAlbum("Test Album");
    }

    @Test
    public void testSongName() {
        assertEquals("Test Song", song.getSongName());
    }

    @Test
    public void testSongArtistFullName() {
        assertEquals("Test Artist", song.getSongArtistFullName());
    }

    @Test
    public void testSongAlbum() {
        assertEquals("Test Album", song.getSongAlbum());
    }

    @Test
    public void testSongAmountFavourites() {
        assertEquals(0, song.getSongAmountFavourites());
    }

    @Test
    public void testSongNameNull() {
        Song songNull = new Song();
        songNull.setSongName(null);
        songNull.setSongArtistFullName("Test Artist");
        songNull.setSongAlbum("Test Album");
        assertEquals(null, songNull.getSongName());
    }

    @Test
    public void testSongArtistFullNameNull() {
        Song songNull = new Song();
        songNull.setSongName("Test Song");
        songNull.setSongArtistFullName(null);
        songNull.setSongAlbum("Test Album");
        assertEquals(null, songNull.getSongArtistFullName());
    }

    @Test
    public void testSongAlbumNull() {
        Song songNull = new Song();
        songNull.setSongName("Test Song");
        songNull.setSongArtistFullName("Test Artist");
        songNull.setSongAlbum(null);
        assertEquals(null, songNull.getSongAlbum());
    }
}
