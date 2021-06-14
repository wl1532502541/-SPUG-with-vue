package com.meteor.scorpio.service;

import com.meteor.scorpio.base.BaseRepository;
import com.meteor.scorpio.base.BaseService;
import com.meteor.scorpio.dao.HostDao;
import com.meteor.scorpio.entity.Host;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HostService extends BaseService<Host,Long> {

    @Autowired
    private HostDao hostDao;

    @Override
    public BaseRepository<Host,Long> repository(){return hostDao;};
}
