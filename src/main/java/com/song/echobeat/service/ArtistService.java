package com.song.echobeat.service;

import org.springframework.stereotype.Service;

import com.song.echobeat.model.Artist;
import com.song.echobeat.repository.ArtistRepository;

@Service
public class ArtistService {

    private final ArtistRepository artistRepository;

    // Constructor injection
    public ArtistService(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    public Artist getArtist(String id) {
        return artistRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Artist not found"));
    }

    public Artist createArtist(Artist artist) {
        return artistRepository.save(artist);
    }

    public Artist updateArtist(String id, Artist updatedArtist) {
        Artist artist = getArtist(id);
        artist.setName(updatedArtist.getName());
        artist.setBio(updatedArtist.getBio());
        return artistRepository.save(artist);
    }

    public void deleteArtist(String id) {
        artistRepository.deleteById(id);
    }
}
