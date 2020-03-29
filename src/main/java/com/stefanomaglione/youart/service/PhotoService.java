package com.stefanomaglione.youart.service;

import com.stefanomaglione.youart.model.Photo;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

public interface PhotoService {

    Photo get(long id);

    Photo save(MultipartFile photoData);

    Photo update(long id, Photo p);

    void delete(long id);

}