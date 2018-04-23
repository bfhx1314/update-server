package com.limn.update.server.dao.impl;

import com.limn.update.server.dao.BaseDao;
import com.limn.update.server.dao.EleMenuJsonDao;
import com.limn.update.server.entity.EleMenuJsonEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

//    @Override
//    public void deleteByShopId(int shopId) {
//        Session session = createSession();
//        session.beginTransaction();
//        Query query = session.createQuery("delete from com.limn.update.server.entity.EleMenuJsonEntity where shopId = " + shopId);
//        query.executeUpdate();
//        session.getTransaction().commit();
//        session.close();
//    }

    @Override
    public List<EleMenuJsonEntity> getNoAnalysisShopJson() {
        Session session = createSession();
        Query query = session.createQuery("from com.limn.update.server.entity.EleMenuJsonEntity where isAnalysis = 0" );
        query.setMaxResults(20);
        List<EleMenuJsonEntity> eleShopJsonEntities = query.list();
        session.close();
        return eleShopJsonEntities;
    }

}
