package com.stefanomaglione.youart.service;

import com.stefanomaglione.youart.dao.PhotoDao;
import com.stefanomaglione.youart.domain.Photo;
import com.stefanomaglione.youart.repositories.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
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
    public Photo save(MultipartFile photoData) {

        InputStream in = null;

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            String username = ((UserDetails)principal).getUsername();
        } else {
            String username = principal.toString();
        }



        //Customer customer = (Customer)authentication.getPrincipal();
        Photo p = new Photo();
        //p.setCustomer(customer);
        Photo photoSaved = null;
        String url = null;
        try {

            photoSaved = photoRepository.save(p);
            in = photoData.getInputStream();
            url = dao.save(photoSaved, in);
            photoSaved.setUrl(url);
            photoSaved = photoRepository.save(photoSaved);
        } catch (IOException e) {
            e.printStackTrace();
        }


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
