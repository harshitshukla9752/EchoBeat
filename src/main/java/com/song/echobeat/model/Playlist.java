package com.song.echobeat.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "playlists")
public class Playlist {

    @Id
    private String id;
    private String name;
    private List<String> songIds;

    // Getters and Setters

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<String> getSongIds() {
        return songIds;
    }
}
