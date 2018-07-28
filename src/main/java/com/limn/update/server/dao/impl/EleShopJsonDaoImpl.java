package com.limn.update.server.dao.impl;

import com.limn.update.server.bean.CoordinateVO;
import com.limn.update.server.dao.BaseDao;
import com.limn.update.server.dao.EleShopJsonDao;
import com.limn.update.server.entity.EleShopJsonEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class EleShopJsonDaoImpl extends BaseDaoImpl<EleShopJsonEntity> implements EleShopJsonDao {
    @Autowired
    public void setDao(BaseDao<EleShopJsonEntity> dao) {
        super.setDao(dao);
    }

    @Override
    public Object findMaxID() {
        return uniqueResult("select max(findId) from com.limn.update.server.entity.EleShopJsonEntity");
    }

    @Override
    public long count() {
        return (Long) uniqueResult("select count(DISTINCT id) from com.limn.update.server.entity.EleShopJsonEntity");
    }

    @Override
    public CoordinateVO getCoordinateByID(int id) {
        List<Object> lists = listResult("select max(longitude),min(longitude),max(latitude),min(latitude)  from com.limn.update.server.entity.EleShopJsonEntity where findId =" + id);
        if(lists.size() == 1 ) {
            if(null != lists.get(0)) {
                Object[] objects = (Object[])  lists.get(0);
                CoordinateVO coordinateVO = new CoordinateVO();
                coordinateVO.setMaxlongitude(objects[0].toString());
                coordinateVO.setMinlongitude(objects[1].toString());
                coordinateVO.setMaxlatitude(objects[2].toString());
                coordinateVO.setMinlatitude(objects[3].toString());
                return coordinateVO;
            }
        }
        return null;
    }
    @Override
    public boolean isExistShop(int shopId,int version) {
        List<Object> lists = listResult("from com.limn.update.server.entity.EleShopJsonEntity where shopId =" + shopId + " and version =" + version);
        if(lists.size() > 0){
            getSession().refresh(lists.get(0));
            return true;
        }
        return false;
    }

//    @Override
//    public List<EleShopJsonEntity> getNoAnalysisShopJson() {
//        Session session = createSession();
//        Query query = session.createQuery("from com.limn.update.server.entity.EleShopJsonEntity where isAnalysis = 0" );
//        query.setMaxResults(200);
//        List<EleShopJsonEntity> eleShopJsonEntities = query.list();
//        session.close();
//        return eleShopJsonEntities;
//    }


    @Override
    public List<EleShopJsonEntity> getNoAnalysis(int maxCount) {
        Session session = createSession();
        Query query = session.createQuery("from com.limn.update.server.entity.EleShopJsonEntity where isAnalysis = 0" );
        query.setMaxResults(maxCount);
        List<EleShopJsonEntity> eleShopJsonEntities = query.list();
        session.close();
        return eleShopJsonEntities;
    }
}
