package com.csc301.songmicroservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class SongController_SongController_e159621abf_Test {

    private SongDal songDal;
    private SongController songController;
    private HttpServletRequest request;

    @BeforeEach
    public void setup() {
        songDal = mock(SongDal.class);
        songController = new SongController(songDal);
        request = mock(HttpServletRequest.class);
    }

    @Test
    public void testSongController_Success() {
        Map<String, String> songParams = new HashMap<>();
        songParams.put("songName", "Song1");
        songParams.put("artistName", "Artist1");
        songParams.put("albumName", "Album1");
        when(songDal.addSong(songParams, request)).thenReturn(new ResponseEntity<>(HttpStatus.OK));
        ResponseEntity responseEntity = songController.addSong(songParams, request);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    public void testSongController_Failure() {
        Map<String, String> songParams = new HashMap<>();
        songParams.put("songName", "Song2");
        songParams.put("artistName", "Artist2");
        songParams.put("albumName", "Album2");
        when(songDal.addSong(songParams, request)).thenReturn(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
        ResponseEntity responseEntity = songController.addSong(songParams, request);
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getStatusCode());
    }
}
