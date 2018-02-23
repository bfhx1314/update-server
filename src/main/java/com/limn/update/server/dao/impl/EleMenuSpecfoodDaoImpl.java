package com.limn.update.server.dao.impl;

import com.limn.update.server.dao.BaseDao;
import com.limn.update.server.dao.EleMenuSpecfoodDao;
import com.limn.update.server.entity.EleMenuSpecfoodEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public class EleMenuSpecfoodDaoImpl extends BaseDaoImpl<EleMenuSpecfoodEntity> implements EleMenuSpecfoodDao {
    @Autowired
    public void setDao(BaseDao<EleMenuSpecfoodEntity> dao) {
        super.setDao(dao);
    }
}
