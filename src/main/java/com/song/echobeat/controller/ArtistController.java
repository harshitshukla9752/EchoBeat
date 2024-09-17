package com.song.echobeat.controller;

import org.springframework.web.bind.annotation.*;

import com.song.echobeat.model.Artist;
import com.song.echobeat.service.ArtistService;

@RestController
@RequestMapping("/api/artists")
public class ArtistController {

    private final ArtistService artistService;

    // Constructor injection
    public ArtistController(ArtistService artistService) {
        this.artistService = artistService;
    }

    @GetMapping("/{id}")
    public Artist getArtist(@PathVariable String id) {
        return artistService.getArtist(id);
    }

    @PostMapping("/create")
    public Artist createArtist(@RequestBody Artist artist) {
        return artistService.createArtist(artist);
    }

    @PutMapping("/update/{id}")
    public Artist updateArtist(@PathVariable String id, @RequestBody Artist artist) {
        return artistService.updateArtist(id, artist);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteArtist(@PathVariable String id) {
        artistService.deleteArtist(id);
    }
}
