package com.stefanomaglione.youart.controller;

import com.stefanomaglione.youart.domain.User;
import com.stefanomaglione.youart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public @ResponseBody
    User getCustomer(@PathVariable String id) {

        User u = userService.getUserByUserId(id);

        return u;
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public @ResponseBody
    User addCustomer(@RequestBody User user) {

        User u = userService.createUser(user);

        return u;
    }


}
