package com.song.echobeat.controller;

import org.springframework.web.bind.annotation.*;

import com.song.echobeat.dto.AdminDto;
import com.song.echobeat.model.Admin;
import com.song.echobeat.model.Artist;
import com.song.echobeat.model.Song;
import com.song.echobeat.service.AdminService;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private final AdminService adminService;

    // Constructor injection
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/register")
    public Admin registerAdmin(@RequestBody AdminDto adminDto) {
        return adminService.registerAdmin(adminDto);
    }

    @PutMapping("/update/{id}")
    public Admin updateAdmin(@PathVariable String id, @RequestBody Admin admin) {
        return adminService.updateAdmin(id, admin);
    }

    @PutMapping("/update-song/{id}")
    public Song updateSong(@PathVariable String id, @RequestBody Song song) {
        return adminService.updateSong(id, song);
    }

    @PutMapping("/update-artist/{id}")
    public Artist updateArtist(@PathVariable String id, @RequestBody Artist artist) {
        return adminService.updateArtist(id, artist);
    }

    @DeleteMapping("/delete-song/{id}")
    public String deleteSong(@PathVariable String id) {
        return adminService.deleteSong(id);
    }

    @DeleteMapping("/delete-user/{id}")
    public String deleteUser(@PathVariable String id) {
        return adminService.deleteUser(id);
    }

    @DeleteMapping("/delete-artist/{id}")
    public String deleteArtist(@PathVariable String id) {
        return adminService.deleteArtist(id);
    }
}
