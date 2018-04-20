package com.limn.update.server.dao.impl;

import com.limn.update.server.bean.CoordinateVO;
import com.limn.update.server.dao.BaseDao;
import com.limn.update.server.dao.EleShopJsonDao;
import com.limn.update.server.entity.EleShopJsonEntity;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class EleShopJsonDaoImpl extends BaseDaoImpl<EleShopJsonEntity> implements EleShopJsonDao {
    @Autowired
    public void setDao(BaseDao<EleShopJsonEntity> dao) {
        super.setDao(dao);
    }

    @Override
    public Object findMaxID() {
        return getSession().createQuery("select max(findId) from com.limn.update.server.entity.EleShopJsonEntity").uniqueResult();
    }

    @Override
    public long count() {
        return (Long) getSession().createQuery("select count(DISTINCT id) from com.limn.update.server.entity.EleShopJsonEntity").uniqueResult();
    }

    @Override
    public CoordinateVO getCoordinateByID(int id) {
        Query query = getSession().createQuery("select max(longitude),min(longitude),max(latitude),min(latitude)  from com.limn.update.server.entity.EleShopJsonEntity where findId =" + id);
        if(query.list().size() == 1 ) {
            if(null != query.list().get(0)) {
                Object[] objects = (Object[]) query.uniqueResult();
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
    public boolean isExistShop(int shopId) {
        Query query = getSession().createQuery("from com.limn.update.server.entity.EleShopJsonEntity where shopId =" + shopId);
        if(query.list().size() > 0){
            getSession().refresh(query.list().get(0));
            return true;
        }
        return false;
    }
}
