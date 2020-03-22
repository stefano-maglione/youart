package com.stefanomaglione.youart.service;

import com.stefanomaglione.youart.model.Photo;

import java.io.IOException;
import java.io.InputStream;

public interface PhotoService {

    Photo get(long id);

    Photo save(Photo p, InputStream photoData) throws IOException;

    Photo update(long id, Photo p);

    void delete(long id);

}