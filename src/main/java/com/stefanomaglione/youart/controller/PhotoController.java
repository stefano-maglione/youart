package com.stefanomaglione.youart.controller;

import com.stefanomaglione.youart.model.Photo;
import com.stefanomaglione.youart.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

@Controller
public class PhotoController {

    @Autowired
    private PhotoService photoService;


    @RequestMapping(value = "/photo/" , method = RequestMethod.POST)
    public @ResponseBody
    void addPhotoData(@RequestBody Photo photo, @RequestParam("data")
            MultipartFile photoData) {

        InputStream in = null;
        try {
            in = photoData.getInputStream();
            photoService.save(photo, in);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }





}
