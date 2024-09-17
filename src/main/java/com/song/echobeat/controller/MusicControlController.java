package com.song.echobeat.controller;

import com.song.echobeat.service.MusicControlService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/music")
public class MusicControlController {

    private final MusicControlService musicControlService;

    // Constructor injection
    public MusicControlController(MusicControlService musicControlService) {
        this.musicControlService = musicControlService;
    }

    @PostMapping("/play/{songId}")
    public ResponseEntity<String> playSong(@PathVariable String songId) {
        String response = musicControlService.playSong(songId);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/pause")
    public ResponseEntity<String> pauseSong() {
        String response = musicControlService.pauseSong();
        return ResponseEntity.ok(response);
    }

    @PostMapping("/forward/{seconds}")
    public ResponseEntity<String> forwardSong(@PathVariable int seconds) {
        String response = musicControlService.forwardSong(seconds);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/backward/{seconds}")
    public ResponseEntity<String> backwardSong(@PathVariable int seconds) {
        String response = musicControlService.backwardSong(seconds);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/stop")
    public ResponseEntity<String> stopSong() {
        String response = musicControlService.stopSong();
        return ResponseEntity.ok(response);
    }
}
