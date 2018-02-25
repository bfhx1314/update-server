package com.limn.update.server.bean;


import com.limn.update.server.entity.QttUserAttachmentEntity;
import com.limn.update.server.entity.QttUserEntity;

import java.util.List;

public class QttUserInfoVo extends ResponseVo {

    String key;

    List<QttUserAttachmentEntity> qttUserAttachmentEntityList;

    QttUserEntity qttUserEntity;

    boolean isFirst;

    public boolean isFirst() {
        return isFirst;
    }

    public void setFirst(boolean first) {
        isFirst = first;
    }

    public QttUserEntity getQttUserEntity() {
        return qttUserEntity;
    }

    public void setQttUserEntity(QttUserEntity qttUserEntity) {
        this.qttUserEntity = qttUserEntity;
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
