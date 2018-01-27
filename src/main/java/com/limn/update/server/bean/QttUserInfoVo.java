package com.limn.update.server.bean;


import com.limn.update.server.entity.QttUserAttachmentEntity;
import com.limn.update.server.entity.QttUserEntity;

import java.util.List;

public class QttUserInfoVo extends ResponseVo {

    String key;

    List<QttUserAttachmentEntity> qttUserAttachmentEntityList;

    String phone;

    QttUserEntity qttUserEntity;

    public QttUserEntity getQttUserEntity() {
        return qttUserEntity;
    }

    public void setQttUserEntity(QttUserEntity qttUserEntity) {
        this.qttUserEntity = qttUserEntity;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<QttUserAttachmentEntity> getQttUserAttachmentEntityList() {
        return qttUserAttachmentEntityList;
    }

    public void setQttUserAttachmentEntityList(List<QttUserAttachmentEntity> qttUserAttachmentEntityList) {
        this.qttUserAttachmentEntityList = qttUserAttachmentEntityList;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
