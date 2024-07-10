package org.example.services;

import lombok.Data;
import org.example.repos.PhotoDAO;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Data
@Service
public class PhotoServiceImpl implements PhotoService {

    private final PhotoDAO photoDAO;

    @Override
    public String savePhoto(MultipartFile file) throws IOException {
        return photoDAO.savePhoto(file);
    }

    @Override
    public void deletePhoto(String id) {
        photoDAO.deletePhoto(id);
    }

    @Override
    public MultipartFile getPhotoById(String id) throws IOException {
        return photoDAO.getPhotoById(id);
    }

    @Override
    public List<MultipartFile> getPhotosByIds(List<String> ids) throws IOException {
        return photoDAO.getPhotosByIds(ids);
    }
}
