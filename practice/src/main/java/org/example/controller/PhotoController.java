package org.example.controller;

import lombok.Data;
import org.example.services.PhotoService;
import org.example.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Data
@RestController
@RequestMapping("/images")
public class PhotoController {

    private final PhotoService photoService;
    private final UserService userService;

    @PostMapping
    public ResponseEntity<String> uploadPhoto(@RequestParam("userId") Integer userId, @RequestParam("file") MultipartFile file) throws IOException {
        String imageId = photoService.savePhoto(file);
        userService.addPhotoToUser(userId, imageId);
        return ResponseEntity.ok(imageId);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MultipartFile> getPhotoById(@PathVariable String id) throws IOException {
        MultipartFile file = photoService.getPhotoById(id);
        if (file != null) {
            return ResponseEntity.ok(file);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<MultipartFile>> getPhotosByIds(@RequestParam("ids") List<String> ids) throws IOException {
        List<MultipartFile> files = photoService.getPhotosByIds(ids);
        return ResponseEntity.ok(files);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePhoto(@PathVariable String id) {
        userService.removePhotoFromUser(id);
        photoService.deletePhoto(id);
        return ResponseEntity.noContent().build();
    }
}
