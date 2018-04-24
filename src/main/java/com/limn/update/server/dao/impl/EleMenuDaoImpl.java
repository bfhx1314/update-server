package com.limn.update.server.dao.impl;

import com.limn.update.server.dao.BaseDao;
import com.limn.update.server.dao.EleMenuDao;
import com.limn.update.server.entity.EleFoodEntity;
import com.limn.update.server.entity.EleMenuEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class EleMenuDaoImpl extends BaseDaoImpl<EleMenuEntity> implements EleMenuDao {
    @Autowired
    public void setDao(BaseDao<EleMenuEntity> dao) {
        super.setDao(dao);
    }


    @Override
    public void deleteByShopId(int shopId) {
        Query query = getSession().createQuery("delete from com.limn.update.server.entity.EleMenuEntity where shopId = " + shopId);
        query.executeUpdate();
    }



    @Override
    public List<EleMenuEntity> getNoAnalysisShopJson() {
        Session session = createSession();
        Query query = session.createQuery("from com.limn.update.server.entity.EleMenuEntity where isAnalysis = 0" );
        query.setMaxResults(20);
        List<EleMenuEntity> eleMenuEntities = query.list();
        session.close();
        return eleMenuEntities;
    }



}
