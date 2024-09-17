package com.song.echobeat.service;

import com.song.echobeat.dto.AdminDto;
import com.song.echobeat.model.Admin;
import com.song.echobeat.model.Artist;
import com.song.echobeat.model.Song;
import com.song.echobeat.model.User;
import com.song.echobeat.repository.AdminRepository;
import com.song.echobeat.repository.ArtistRepository;
import com.song.echobeat.repository.SongRepository;
import com.song.echobeat.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    private final AdminRepository adminRepository;
    private final SongRepository songRepository;
    private final ArtistRepository artistRepository;
    private final UserRepository userRepository;
    private final NotificationService notificationService;

    // Constructor injection
    public AdminService(
            AdminRepository adminRepository,
            SongRepository songRepository,
            ArtistRepository artistRepository,
            UserRepository userRepository,
            NotificationService notificationService) {
        this.adminRepository = adminRepository;
        this.songRepository = songRepository;
        this.artistRepository = artistRepository;
        this.userRepository = userRepository;
        this.notificationService = notificationService;
    }

    public Admin registerAdmin(AdminDto adminDto) {
        Admin admin = new Admin();
        admin.setEmail(adminDto.getEmail());
        admin.setPassword(adminDto.getPassword());
        notificationService.createNotification("New admin registered", admin.getId());
        return adminRepository.save(admin);
    }

    public Admin updateAdmin(String id, Admin updatedAdmin) {
        Admin existingAdmin = adminRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Admin not found"));

        existingAdmin.setEmail(updatedAdmin.getEmail());
        existingAdmin.setPassword(updatedAdmin.getPassword()); // Ensure password is encrypted

        // Save updated admin
        Admin savedAdmin = adminRepository.save(existingAdmin);

        // Notify about the update
        notificationService.createNotification("Admin details updated", "Admin with ID " + id + " was updated.");

        return savedAdmin;
    }

    public User updateUser(String id, User user) {
        user.setId(id);
        notificationService.createNotification("User details updated by admin", id);
        return userRepository.save(user);
    }

    public Song updateSong(String id, Song song) {
        song.setId(id);
        notificationService.createNotification("Song updated by admin", id);
        return songRepository.save(song);
    }

    public Artist updateArtist(String id, Artist artist) {
        artist.setId(id);
        notificationService.createNotification("Artist updated by admin", id);
        return artistRepository.save(artist);
    }

    public String deleteSong(String id) {
        songRepository.deleteById(id);
        notificationService.createNotification("Song deleted by admin", id);
        return "Song deleted successfully";
    }

    public String deleteUser(String id) {
        userRepository.deleteById(id);
        notificationService.createNotification("User deleted by admin", id);
        return "User deleted successfully";
    }

    public String deleteArtist(String id) {
        artistRepository.deleteById(id);
        notificationService.createNotification("Artist deleted by admin", id);
        return "Artist deleted successfully";
    }
}
