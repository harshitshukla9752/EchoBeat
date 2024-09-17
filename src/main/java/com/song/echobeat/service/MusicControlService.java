package com.song.echobeat.service;

import com.song.echobeat.model.Song;
import com.song.echobeat.repository.SongRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MusicControlService {

    private final SongRepository songRepository;
    private Song currentSong;
    private int currentPosition;  // Tracks the current position in the song (in seconds)

    // Constructor injection for SongRepository
    public MusicControlService(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    // Method to play a song
    public String playSong(String songId) {
        Optional<Song> song = songRepository.findById(songId);
        if (song.isPresent()) {
            currentSong = song.get();
            currentPosition = 0;  // Start from the beginning
            return "Playing: " + currentSong.getTitle();
        }
        return "Song not found.";
    }

    // Method to pause a song
    public String pauseSong() {
        if (currentSong != null) {
            return "Paused: " + currentSong.getTitle() + " at position: " + currentPosition + " seconds.";
        }
        return "No song is currently playing.";
    }

    // Method to forward a song by X seconds
    public String forwardSong(int seconds) {
        if (currentSong != null) {
            currentPosition += seconds;
            return "Forwarded " + seconds + " seconds. Current position: " + currentPosition + " seconds.";
        }
        return "No song is currently playing.";
    }

    // Method to backward a song by X seconds
    public String backwardSong(int seconds) {
        if (currentSong != null) {
            currentPosition = Math.max(currentPosition - seconds, 0);
            return "Rewinded " + seconds + " seconds. Current position: " + currentPosition + " seconds.";
        }
        return "No song is currently playing.";
    }

    // Stop the current song
    public String stopSong() {
        if (currentSong != null) {
            String message = "Stopped: " + currentSong.getTitle();
            currentSong = null;
            currentPosition = 0;
            return message;
        }
        return "No song is currently playing.";
    }
}
