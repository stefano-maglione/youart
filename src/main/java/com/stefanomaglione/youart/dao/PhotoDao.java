package com.stefanomaglione.youart.dao;

import com.stefanomaglione.youart.domain.Photo;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Optional;


public interface PhotoDao {

    Optional<Photo> get(long id);

    String save(Photo p, InputStream photoData) throws IOException;

    Photo update(Photo p);

    void delete(Photo t);

    Collection<Photo> getAll(long id);
}





