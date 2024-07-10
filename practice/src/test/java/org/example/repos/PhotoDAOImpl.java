package org.example.repos;

import com.mongodb.client.gridfs.model.GridFSFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsCriteria;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PhotoDAOImpl implements PhotoDAO {

    @Autowired
    private GridFsOperations gridFsOperations;

    @Override
    public String savePhoto(MultipartFile file) throws IOException {
        String name = nextName();
        gridFsOperations.store(file.getInputStream(), name);
        return name;
    }

    @Override
    public void deletePhoto(String id) {
        gridFsOperations.delete(new Query(new GridFsCriteria(id)));
    }

    @Override
    public MultipartFile getPhotoById(String id) throws IOException {
        GridFSFile file = gridFsOperations.findOne(new Query(new GridFsCriteria(id)));
        if (file != null) {
            if (file.getMetadata() != null) {
                return new MockMultipartFile(file.getFilename(), file.getFilename(), file.getMetadata().getString("_contentType"), gridFsOperations.getResource(file).getInputStream());
            }
        }
        return null;
    }

    @Override
    public List<MultipartFile> getPhotosByIds(List<String> ids) throws IOException {
        List<MultipartFile> files = new ArrayList<>();
        for (String id : ids) {
            MultipartFile file = getPhotoById(id);
            if (file != null) {
                files.add(file);
            }
        }
        return files;
    }

    private long cnt;
    private String nextName() {
        return String.valueOf(cnt++);
    }
}
