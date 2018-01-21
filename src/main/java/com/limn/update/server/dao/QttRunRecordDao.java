package com.limn.update.server.dao;

import com.limn.update.server.entity.QttRunRecordEntity;

public interface QttRunRecordDao extends BaseDao<QttRunRecordEntity> {


    QttRunRecordEntity getUserByKey(String key);


}
