package com.meteor.scorpio.controller;

import com.meteor.scorpio.base.BaseController;
import com.meteor.scorpio.base.BaseService;
import com.meteor.scorpio.entity.User;
import com.meteor.scorpio.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController extends BaseController<User> {

    @Autowired
    private UserService userService;

    @Override
    public BaseService service() {
        return userService;
    }
}
