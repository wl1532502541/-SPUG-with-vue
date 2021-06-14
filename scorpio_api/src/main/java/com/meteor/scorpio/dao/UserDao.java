package com.meteor.scorpio.dao;

import com.meteor.scorpio.base.BaseRepository;
import com.meteor.scorpio.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends BaseRepository<User, Long> {

}
