package com.limn.update.server.dao.impl;

import com.limn.update.server.dao.BaseDao;
import com.limn.update.server.dao.EleMenuJsonDao;
import com.limn.update.server.entity.EleMenuJsonEntity;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class EleMenuJsonDaoImpl extends BaseDaoImpl<EleMenuJsonEntity> implements EleMenuJsonDao {
    @Autowired
    public void setDao(BaseDao<EleMenuJsonEntity> dao) {
        super.setDao(dao);
    }

    @Override
    public void deleteByShopId(int shopId) {
        Query query = getSession().createQuery("delete from com.limn.update.server.entity.EleMenuJsonEntity where shopId = " + shopId);
        query.executeUpdate();
    }

}
