package com.stefanomaglione.youart.service;

import com.stefanomaglione.youart.dao.PhotoDao;
import com.stefanomaglione.youart.model.Photo;
import com.stefanomaglione.youart.repo.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;

@Service
public class PhotoServiceImpl implements PhotoService {

    @Autowired
    private PhotoDao dao;

    @Autowired
    private PhotoRepository photoRepository;



    @Override
    public Photo get(long id) {
        return null;
    }

    @Override
    public Photo save(Photo p,InputStream photoData) throws IOException {



        Photo photoSaved = photoRepository.save(p);
        dao.save(photoSaved, photoData);


        return photoSaved;
    }

    @Override
    public Photo update(long id, Photo p) {
        return null;
    }

    @Override
    public void delete(long id) {

    }
}
