package com.song.echobeat.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.song.echobeat.model.Admin;

public interface AdminRepository extends MongoRepository<Admin, String> {
}
