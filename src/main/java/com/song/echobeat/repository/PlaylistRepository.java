package com.song.echobeat.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.song.echobeat.model.Playlist;

import java.util.List;

public interface PlaylistRepository extends MongoRepository<Playlist, String> {
    List<Playlist> findByNameContainingIgnoreCase(String name);
}
