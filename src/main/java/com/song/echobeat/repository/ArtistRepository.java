package com.song.echobeat.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.song.echobeat.model.Artist;

public interface ArtistRepository extends MongoRepository<Artist, String> {
}
