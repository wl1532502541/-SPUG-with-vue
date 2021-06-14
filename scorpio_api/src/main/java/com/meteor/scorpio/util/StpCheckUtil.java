package com.meteor.scorpio.util;


import cn.dev33.satoken.stp.StpInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 自定义权限验证接口扩展
 */
@Component  // 保证此类被SpringBoot扫描，完成sa-token的自定义权限验证扩展
public class StpCheckUtil implements StpInterface {

    @Override
    public List<Object> getPermissionCodeList(Object o, String s) {
        return null;
    }
}
