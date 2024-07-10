package org.example.services;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface PhotoService {
    String savePhoto(MultipartFile file) throws IOException;
    void deletePhoto(String id);
    MultipartFile getPhotoById(String id) throws IOException;
    List<MultipartFile> getPhotosByIds(List<String> ids) throws IOException;
}
