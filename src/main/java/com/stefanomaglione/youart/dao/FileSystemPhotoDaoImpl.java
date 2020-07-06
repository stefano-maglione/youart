package com.stefanomaglione.youart.dao;

import com.stefanomaglione.youart.domain.Photo;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Collection;
import java.util.Optional;

@Component
public class FileSystemPhotoDaoImpl implements PhotoDao{

    private Path targetDir_ = Paths.get("photos");


    @Override
    public Optional<Photo> get(long id) {

        return Optional.ofNullable(new Photo());
    }

    @Override
    public String save(Photo p, InputStream photoData) throws IOException {

        assert(photoData != null);
        String base = "/Users/fullname/Desktop/Progetto/photo/";

        File targetFile = new File(base + "photo" + p.getId() + ".jpg");
        Files.copy(photoData,targetFile.toPath(), StandardCopyOption.REPLACE_EXISTING);

        return targetFile.getAbsolutePath();
    }


    @Override
    public Photo update(Photo photo) {

        //entities.put(photo.getId(), photo);

        return photo;
    }

    @Override
    public void delete(Photo photo) {

        //entities.remove(photo.getId());
    }

    @Override
    public Collection<Photo> getAll(long id) {
        return null;
    }

}
