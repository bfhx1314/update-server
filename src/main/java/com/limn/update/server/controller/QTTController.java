package com.limn.update.server.controller;


import com.limn.update.server.bean.FileServerVo;
import com.limn.update.server.bean.ResponseVo;
import com.limn.update.server.entity.QttUserAttachmentEntity;
import com.limn.update.server.enumeration.QttUserAttachmentEnum;
import com.limn.update.server.service.QTTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/qtt")
public class QTTController {

    @Autowired
    QTTService qttService;

    @Transactional
    @RequestMapping("/cacheFileList")
    @ResponseBody
    public Object getCacheFileList(HttpServletRequest request, HttpServletResponse response,String key){

        List<QttUserAttachmentEntity> qttList = qttService.getFileListByUser(key);
        ResponseVo responseVo = new ResponseVo();
        responseVo.setStatus("1");
        responseVo.setData(qttList);
        return responseVo;
    }


    @Transactional
    @RequestMapping("/getUser")
    @ResponseBody
    public Object run(HttpServletRequest request, HttpServletResponse response){
        return qttService.getExeUserInfo();
    }


    @Transactional
    @RequestMapping("/upload")
    @ResponseBody
    public Object upload(HttpServletRequest request, HttpServletResponse response ,MultipartFile file, String key, String type){
        FileServerVo fileServerVo = qttService.uploadUserCacheFile(file, key, type);
        return fileServerVo;
    }

}
