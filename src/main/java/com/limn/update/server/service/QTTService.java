package com.limn.update.server.service;

import com.limn.update.server.bean.FileServerVo;
import com.limn.update.server.bean.QttUserInfoVo;
import com.limn.update.server.bean.ResponseVo;
import com.limn.update.server.entity.QttUserAttachmentEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;



public interface QTTService {

    List<QttUserAttachmentEntity> getFileListByUser(String key);

    List<QttUserAttachmentEntity> getFileListByUser(QttUserAttachmentEntity qttUserAttachmentEntity);

    FileServerVo uploadUserCacheFile(MultipartFile file,String key,String type);

    QttUserInfoVo getExeUserInfo();

    String getPhoneByKey(String key);


}
