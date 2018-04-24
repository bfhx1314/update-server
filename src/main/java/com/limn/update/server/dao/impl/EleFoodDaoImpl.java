package com.limn.update.server.dao.impl;

import com.limn.update.server.bean.ResponseVo;
import com.limn.update.server.dao.BaseDao;
import com.limn.update.server.dao.EleFoodDao;
import com.limn.update.server.entity.EleFoodEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by limengnan on 2018/4/23.
 */
@Repository
@Transactional
public class EleFoodDaoImpl extends BaseDaoImpl<EleFoodEntity> implements EleFoodDao {
    @Autowired
    public void setDao(BaseDao<EleFoodEntity> dao) {
        super.setDao(dao);
    }

    @Override
    public List<EleFoodEntity> getNoAnalysisShopJson() {
        Session session = createSession();
        Query query = session.createQuery("from com.limn.update.server.entity.EleFoodEntity where isAnalysis = 0" );
        query.setMaxResults(20);
        List<EleFoodEntity> eleFoodEntities = query.list();
        session.close();
        return eleFoodEntities;
    }
}
