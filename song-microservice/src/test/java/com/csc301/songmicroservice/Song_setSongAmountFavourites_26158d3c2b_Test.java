package com.csc301.songmicroservice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Song_setSongAmountFavourites_26158d3c2b_Test {

    private Song song;

    @BeforeEach
    public void setup() {
        song = new Song("title", "artist", "album");
    }

    @Test
    public void testSetSongAmountFavourites_PositiveNumber() {
        long songAmountFavourites = 10L;
        song.setSongAmountFavourites(songAmountFavourites);
        assertEquals(songAmountFavourites, song.getSongAmountFavourites());
    }

    @Test
    public void testSetSongAmountFavourites_Zero() {
        long songAmountFavourites = 0L;
        song.setSongAmountFavourites(songAmountFavourites);
        assertEquals(songAmountFavourites, song.getSongAmountFavourites());
    }

    @Test
    public void testSetSongAmountFavourites_NegativeNumber() {
        long songAmountFavourites = -10L;
        song.setSongAmountFavourites(songAmountFavourites);
        assertEquals(songAmountFavourites, song.getSongAmountFavourites());
    }
}
