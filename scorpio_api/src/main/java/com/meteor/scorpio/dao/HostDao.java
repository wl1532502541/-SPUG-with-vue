package com.meteor.scorpio.dao;

import com.meteor.scorpio.base.BaseRepository;
import com.meteor.scorpio.entity.Host;
import org.springframework.stereotype.Repository;

@Repository
public interface HostDao extends BaseRepository<Host,Long> {

}
