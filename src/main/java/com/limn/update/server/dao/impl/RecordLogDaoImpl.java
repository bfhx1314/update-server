package com.limn.update.server.dao.impl;

import com.limn.update.server.dao.BaseDao;
import com.limn.update.server.dao.RecordLogDao;
import com.limn.update.server.dao.WXCMinfoDao;
import com.limn.update.server.entity.RecordLogEntity;
import com.limn.update.server.entity.WXCMInfoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public class RecordLogDaoImpl extends BaseDaoImpl<RecordLogEntity> implements RecordLogDao {

    @Autowired
    public void setDao(BaseDao<RecordLogEntity> dao) {
        super.setDao(dao);
    }





}
