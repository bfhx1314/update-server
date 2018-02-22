package com.limn.update.server.dao.impl;

import com.limn.update.server.dao.BaseDao;
import com.limn.update.server.dao.EleMenuDao;
import com.limn.update.server.entity.EleMenuEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class EleMenuDaoImpl extends BaseDaoImpl<EleMenuEntity> implements EleMenuDao {
    @Autowired
    public void setDao(BaseDao<EleMenuEntity> dao) {
        super.setDao(dao);
    }
}
