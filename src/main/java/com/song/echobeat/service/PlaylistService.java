package com.song.echobeat.service;

import org.springframework.stereotype.Service;

import com.song.echobeat.dto.PlaylistDto;
import com.song.echobeat.model.Playlist;
import com.song.echobeat.repository.PlaylistRepository;

@Service
public class PlaylistService {

    private final PlaylistRepository playlistRepository;

    // Constructor injection
    public PlaylistService(PlaylistRepository playlistRepository) {
        this.playlistRepository = playlistRepository;
    }

    public Playlist getPlaylist(String playlistId) {
        return playlistRepository.findById(playlistId)
                .orElseThrow(() -> new RuntimeException("Playlist not found"));
    }

    public Playlist createPlaylist(PlaylistDto playlistDto) {
        Playlist playlist = new Playlist();
        playlist.setName(playlistDto.getName());
        return playlistRepository.save(playlist);
    }

    public Playlist addSongToPlaylist(String playlistId, String songId) {
        Playlist playlist = getPlaylist(playlistId);
        playlist.getSongIds().add(songId);
        return playlistRepository.save(playlist);
    }
}
