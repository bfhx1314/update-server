package com.limn.update.server.dao.impl;

import com.limn.update.server.dao.BaseDao;
import com.limn.update.server.dao.EleSpecfoodDao;
import com.limn.update.server.entity.EleSpecfoodEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
@Transactional
public class EleSpecfoodDaoImpl extends BaseDaoImpl<EleSpecfoodEntity> implements EleSpecfoodDao {
    @Autowired
    public void setDao(BaseDao<EleSpecfoodEntity> dao) {
        super.setDao(dao);
    }

    @Override
    public List<EleSpecfoodEntity> getNoAnalysis(int maxCount) {
        Session session = createSession();
        Query query = session.createQuery("from com.limn.update.server.entity.EleSpecfoodEntity where isAnalysis = 0" );
        query.setMaxResults(maxCount);
        List<EleSpecfoodEntity> eleShopJsonEntities = query.list();
        session.close();
        return eleShopJsonEntities;
    }
}
