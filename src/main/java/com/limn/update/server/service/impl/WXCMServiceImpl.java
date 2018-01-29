package com.limn.update.server.service.impl;

import com.limn.update.server.dao.WXCMUpdateDao;
import com.limn.update.server.enumeration.WXCMEnum;
import com.limn.update.server.service.FileServerService;
import com.limn.update.server.service.WXCMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by limengnan on 2018/1/26.
 */

@Service
public class WXCMServiceImpl implements WXCMService {
    @Autowired
    FileServerService fileServerService;

    @Autowired
    WXCMUpdateDao wxcmUpdateDao;


    @Override
    public void uploadLua(MultipartFile file) {
        fileServerService.upLoad(file,WXCMEnum.UPDATEPATH.getCode(), WXCMEnum.LUA.getCode());

    }

    @Override
    public void uploadPhp(MultipartFile file) {

    }
}
