package com.meteor.scorpio.controller;

import com.meteor.scorpio.base.BaseController;
import com.meteor.scorpio.base.BaseEntity;
import com.meteor.scorpio.base.BaseService;
import com.meteor.scorpio.entity.Host;
import com.meteor.scorpio.handler.base.BaseResponse;
import com.meteor.scorpio.handler.base.BaseResult;
import com.meteor.scorpio.service.HostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@BaseResponse
@ResponseBody
@RestController
@RequestMapping("/host")
public class HostController extends BaseController<Host>{
    @Autowired
    private HostService hostService;

    @Override
    public BaseService service(){return hostService;};
}
