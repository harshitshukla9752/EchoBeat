package com.song.echobeat.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.song.echobeat.dto.SongDto;
import com.song.echobeat.model.Song;
import com.song.echobeat.service.SongService;

import java.util.List;

@RestController
@RequestMapping("/api/songs")
public class SongController {

    private final SongService songService;

    public SongController(SongService songService) {
        this.songService = songService;
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/play/{id}")
    public ResponseEntity<String> playSong(@PathVariable String id) {
        // Placeholder for actual playback logic
        // You might want to implement this method depending on your actual playback mechanism.
        return ResponseEntity.ok("Playing song with ID: " + id);
    }

    @GetMapping("/search")
    public List<Song> searchSongs(@RequestParam("query") String query) {
        return songService.searchSongs(query);
    }

    @PostMapping("/add")
    public ResponseEntity<Song> addSong(@RequestBody SongDto songDto) {
        Song song = songService.addSong(songDto);
        return ResponseEntity.ok(song);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Song> getSong(@PathVariable String id) {
        Song song = songService.getSong(id);
        return ResponseEntity.ok(song);
    }

    @PostMapping("/like/{songId}/{userId}")
    public ResponseEntity<Song> likeSong(@PathVariable String songId, @PathVariable String userId) {
        Song response = songService.likeSong(songId, userId);
        return ResponseEntity.ok(response);
    }
    
}


