package org.example.services;

import lombok.Data;
import org.example.models.User;
import org.example.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Data
@Service
@Primary
public class UserServiceImpl implements UserService{

    @Autowired
    private final UserRepository userRepository;

    @Override
    public void addPhotoToUser(Integer userId, String photoId) {
        Optional<User> optionalUser = userRepository.findById(userId.toString());
        User user;

        if (optionalUser.isPresent()) {
            user = optionalUser.get();
        } else {
            user = new User();
            user.setId(userId);
            user.setPhotos(new ArrayList<>());
        }

        List<String> photos = user.getPhotos();
        if (photos == null) photos = new ArrayList<>();
        photos.add(photoId);
        user.setPhotos(photos);

        userRepository.save(user);
    }

    @Override
    public List<String> getUserPhotos(Integer userId) {
        Optional<User> user = userRepository.findById(userId.toString());
        return user.isPresent() ? user.get().getPhotos() : new ArrayList<>();
    }

    @Override
    public void removePhotoFromUser(String photoId) {
        List<User> users = userRepository.findAll();
        for (User user : users) {
            if (user.getPhotos() == null || !user.getPhotos().remove(photoId)) {
                userRepository.delete(user);
            } else {
                user.getPhotos().remove(photoId);
                userRepository.save(user);
            }
        }
    }
}

