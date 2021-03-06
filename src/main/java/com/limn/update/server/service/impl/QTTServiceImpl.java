package com.limn.update.server.service.impl;

import com.limn.update.server.bean.FileServerVo;
import com.limn.update.server.bean.QttUserInfoVo;
import com.limn.update.server.common.BaseUtil;
import com.limn.update.server.dao.QttRunRecordDao;
import com.limn.update.server.dao.QttUserAttachmentDao;
import com.limn.update.server.dao.QttUserDao;
import com.limn.update.server.entity.QttRunRecordEntity;
import com.limn.update.server.entity.QttUserAttachmentEntity;
import com.limn.update.server.entity.QttUserEntity;
import com.limn.update.server.enumeration.QttUserAttachmentEnum;
import com.limn.update.server.service.FileServerService;
import com.limn.update.server.service.QTTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Service
public class QTTServiceImpl implements QTTService {


    @Autowired
    FileServerService fileServerService;

    @Autowired
    QttUserAttachmentDao qttUserAttachmentDao;

    @Autowired
    QttUserDao qttUserDao;

    @Autowired
    QttRunRecordDao qttRunRecordDao;


    private final String qttPath = "/qtt/";


    @Override
    public List<QttUserAttachmentEntity> getFileListByUser(String key) {
        String phone = getPhoneByKey(key);
        if(BaseUtil.isEmpty(phone)){
            return null;
        }
        QttUserAttachmentEntity qtt = new QttUserAttachmentEntity();
        qtt.setPhone(phone);
        qtt.setType(QttUserAttachmentEnum.CACHE.getCode());
        return getFileListByUser(qtt);
    }


    @Override
    public String getPhoneByKey(String key){
        QttRunRecordEntity qttRunRecordEntity = qttRunRecordDao.getUserByKey(key);
        if(qttRunRecordEntity == null || BaseUtil.isEmpty(qttRunRecordEntity.getPhone())){
            return null;
        }
        return qttRunRecordEntity.getPhone();
    }



    @Override
    public List<QttUserAttachmentEntity> getFileListByUser(QttUserAttachmentEntity qtt) {
        List<QttUserAttachmentEntity> qttList = qttUserAttachmentDao.getUserAttachments(qtt);

        return qttList;
    }

    @Override
    public FileServerVo uploadUserCacheFile(MultipartFile file, String key, String type) {
        FileServerVo fileServerVo = new FileServerVo();
        QttRunRecordEntity qttRunRecordEntity = qttRunRecordDao.getUserByKey(key);
        if(qttRunRecordEntity == null || BaseUtil.isEmpty(qttRunRecordEntity.getPhone())){
            fileServerVo.setStatus("0");
            fileServerVo.setDetail("未查询到用户附件");
            return fileServerVo;
        }

        String phone = qttRunRecordEntity.getPhone();

        fileServerVo = fileServerService.upLoad(file,qttPath + "/" + phone + "/" + type,null );
        if(fileServerVo.getStatus().equalsIgnoreCase("1")){
            QttUserAttachmentEntity qttUserAttachmentEntity = new QttUserAttachmentEntity();
            qttUserAttachmentEntity.setFileName(fileServerVo.getFileName());
            qttUserAttachmentEntity.setPhone(phone);
            qttUserAttachmentEntity.setUrl(fileServerVo.getFilePath());
            qttUserAttachmentEntity.setType(QttUserAttachmentEnum.CACHE.getCode());
            qttUserAttachmentEntity.setKey(key);
            qttUserAttachmentEntity.setValid("Y");
            qttUserAttachmentDao.save(qttUserAttachmentEntity);
        }
        return fileServerVo;
    }

    @Override
    public QttUserInfoVo getExeUserInfo() {

        QttUserInfoVo qttUserInfoVo = new QttUserInfoVo();

        QttUserEntity qttUserEntity = qttUserDao.getExeUser();
        if(qttUserEntity == null){
            qttUserInfoVo.setStatus("0");
            qttUserInfoVo.setDetail("无用户信息");
            return qttUserInfoVo;
        }
        qttUserInfoVo.setStatus("1");

        QttRunRecordEntity qttRunRecordEntity = qttRunRecordDao.getLastUserByPhone(qttUserEntity.getPhone());


        QttUserAttachmentEntity qttUserAttachmentEntity = new QttUserAttachmentEntity();
        qttUserAttachmentEntity.setPhone(qttRunRecordEntity.getPhone());
        qttUserAttachmentEntity.setType(QttUserAttachmentEnum.CACHE.getCode());
        qttUserAttachmentEntity.setKey(qttRunRecordEntity.getKey());
        qttUserInfoVo.setQttUserAttachmentEntityList(getFileListByUser(qttUserAttachmentEntity));

        //没有缓存文件标记为第一次执行(存在图形识别码 需要人工参与)
        if(qttUserInfoVo.getQttUserAttachmentEntityList().size() == 0){
            qttUserInfoVo.setFirst(true);
        }else{
            qttUserInfoVo.setFirst(false);
        }

        qttUserEntity.setStatus(1);
        qttUserDao.update(qttUserEntity);

        QttRunRecordEntity qttRunRecordEntityNew = new QttRunRecordEntity();
        qttRunRecordEntityNew.setPhone(qttUserEntity.getPhone());
        String key = UUID.randomUUID().toString().replaceAll("-","");
        qttRunRecordEntityNew.setKey(key);


        qttRunRecordEntityNew.setCreateDate(new Timestamp(System.currentTimeMillis()));
        qttRunRecordDao.save(qttRunRecordEntityNew);


        qttUserInfoVo.setKey(key);
        qttUserInfoVo.setQttUserEntity(qttUserEntity);
        return qttUserInfoVo;
    }
}
