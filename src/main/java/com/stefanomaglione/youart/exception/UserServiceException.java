package com.stefanomaglione.youart.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserServiceException extends RuntimeException {

    public UserServiceException(String s) {
            super(s);
        }
    }

