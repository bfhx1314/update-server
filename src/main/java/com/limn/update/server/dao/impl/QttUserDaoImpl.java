package com.limn.update.server.dao.impl;

import com.limn.update.server.dao.BaseDao;
import com.limn.update.server.dao.QttUserDao;
import com.limn.update.server.dao.RecordLogDao;
import com.limn.update.server.entity.QttUserEntity;
import com.limn.update.server.entity.RecordLogEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class QttUserDaoImpl extends BaseDaoImpl<QttUserEntity> implements QttUserDao {

    @Autowired
    public void setDao(BaseDao<QttUserEntity> dao) {
        super.setDao(dao);
    }





}
