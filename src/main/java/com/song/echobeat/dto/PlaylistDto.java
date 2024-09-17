package com.song.echobeat.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.List;

public class PlaylistDto {

    private String id; // Optional, if you want to include the ID in DTO

    @NotBlank
    @Size(min = 1, max = 100)
    private String name;

    private List<String> songIds; // List of song IDs associated with the playlist

    // Getters and Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getSongIds() {
        return songIds;
    }

    public void setSongIds(List<String> songIds) {
        this.songIds = songIds;
    }
}
