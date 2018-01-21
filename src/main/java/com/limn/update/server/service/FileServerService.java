package com.limn.update.server.service;

import com.limn.update.server.bean.FileServerVo;
import com.limn.update.server.bean.ResponseVo;
import org.springframework.web.multipart.MultipartFile;


public interface FileServerService {


    FileServerVo upLoad(MultipartFile file , String path, String fileName);

    ResponseVo list(String path);


}
