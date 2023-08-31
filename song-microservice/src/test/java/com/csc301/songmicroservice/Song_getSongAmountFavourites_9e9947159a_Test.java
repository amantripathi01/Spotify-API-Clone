package com.csc301.songmicroservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Song_getSongAmountFavourites_9e9947159a_Test {

    private Song song;

    @BeforeEach
    public void setup() {
        song = new Song("Song Title", "Song Artist", "Song Album");
    }

    @Test
    public void testGetSongAmountFavourites_WhenNoFavourites() {
        long expected = 0;
        long actual = song.getSongAmountFavourites();
        assertEquals(expected, actual, "Expected number of favourites should be 0 when no favourites are added.");
    }

    @Test
    public void testGetSongAmountFavourites_WhenFavouritesAdded() {
        // TODO: Add favourites to the song
        long expected = 5; // change this value to match the number of favourites added
        long actual = song.getSongAmountFavourites();
        assertEquals(expected, actual, "Expected number of favourites does not match the actual number.");
    }
}
