package com.limn.update.server.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by limengnan on 2018/1/26.
 */
public interface WXCMService {

    void uploadLua(MultipartFile file);
    void uploadPhp(MultipartFile file);

}
