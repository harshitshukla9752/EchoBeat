package com.song.echobeat.controller;

import org.springframework.web.bind.annotation.*;

import com.song.echobeat.dto.PlaylistDto;
import com.song.echobeat.model.Playlist;
import com.song.echobeat.service.PlaylistService;

@RestController
@RequestMapping("/api/playlists")
public class PlaylistController {

    private final PlaylistService playlistService;

    // Constructor injection
    public PlaylistController(PlaylistService playlistService) {
        this.playlistService = playlistService;
    }

    @GetMapping("/{id}")
    public Playlist getPlaylist(@PathVariable String id) {
        return playlistService.getPlaylist(id);
    }

    @PostMapping("/create")
    public Playlist createPlaylist(@RequestBody PlaylistDto playlistDto) {
        return playlistService.createPlaylist(playlistDto);
    }

    @PostMapping("/add-song/{playlistId}/{songId}")
    public Playlist addSongToPlaylist(@PathVariable String playlistId, @PathVariable String songId) {
        return playlistService.addSongToPlaylist(playlistId, songId);
    }
}
