package com.meteor.scorpio.service;

import com.meteor.scorpio.base.BaseRepository;
import com.meteor.scorpio.base.BaseService;
import com.meteor.scorpio.dao.UserDao;
import com.meteor.scorpio.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService extends BaseService<User, Long> {

    @Autowired
    private UserDao userDao;

    @Override
    public BaseRepository<User, Long> repository() {
        return userDao;
    }
}
