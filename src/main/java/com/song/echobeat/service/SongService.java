package com.song.echobeat.service;

import org.springframework.stereotype.Service;
import com.song.echobeat.dto.SongDto;
import com.song.echobeat.model.Song;
import com.song.echobeat.repository.SongRepository;

import java.util.List;
import java.util.NoSuchElementException;


@Service
public class SongService {

    private final SongRepository songRepository;
    private final NotificationService notificationService;

    public SongService(SongRepository songRepository, NotificationService notificationService) {
        this.songRepository = songRepository;
        this.notificationService = notificationService;
    }

    public Song addSong(SongDto songDto) {
        Song song = new Song();
        song.setTitle(songDto.getTitle());
        song.setArtist(songDto.getArtist());
        song.setAlbum(songDto.getAlbum());
        song.setGenre(songDto.getGenre());
        song.setYear(songDto.getYear());
        return songRepository.save(song);
    }

    public Song getSong(String id) {
        return songRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Song not found"));
    }

    public List<Song> searchSongs(String query) {
        // Use a repository method to search for songs containing the query in their title or artist
        return songRepository.findByTitleContainingIgnoreCaseOrArtistContainingIgnoreCase(query, query);
    }

    public Song likeSong(String songId, String userId) {
    // Find the song and update the likes
    Song song = songRepository.findById(songId)
            .orElseThrow(() -> new NoSuchElementException("Song not found"));

    // Increment the likes count (you need to define this method in the Song class)
    song.incrementLikes();  

    // Save the updated song
    songRepository.save(song);

    notificationService.createNotification("You liked the song " + song.getTitle(), userId);

    return song;
}
}
