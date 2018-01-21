package com.limn.update.server.dao;

import com.limn.update.server.entity.QttUserAttachmentEntity;

import java.util.List;


public interface QttUserAttachmentDao extends BaseDao<QttUserAttachmentEntity> {

    List<QttUserAttachmentEntity> getUserAttachments(QttUserAttachmentEntity entity);



}
