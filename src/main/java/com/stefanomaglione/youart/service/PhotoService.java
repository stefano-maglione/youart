package com.stefanomaglione.youart.service;

import com.stefanomaglione.youart.domain.Photo;
import org.springframework.web.multipart.MultipartFile;

public interface PhotoService {

    Photo get(long id);

    Photo save(MultipartFile photoData);

    Photo update(long id, Photo p);

    void delete(long id);

}