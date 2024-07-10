package org.example.services;

import org.example.models.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    void addPhotoToUser(Integer userId, String photoId);
    void removePhotoFromUser(String photoId);
    List<String> getUserPhotos(Integer userId);
}
