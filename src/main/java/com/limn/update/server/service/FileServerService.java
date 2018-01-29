package com.limn.update.server.service;

import com.limn.update.server.bean.FileServerListVo;
import com.limn.update.server.bean.FileServerVo;
import com.limn.update.server.bean.ResponseVo;
import org.springframework.web.multipart.MultipartFile;


public interface FileServerService {


    FileServerVo upLoad(MultipartFile file , String path, String fileName);

    FileServerListVo list(String path);

    boolean delete(String path);

    boolean createFile(String path);

}
