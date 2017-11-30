package com.limn.update.server.dao.impl;

import com.limn.update.server.bean.CoordinateVO;
import com.limn.update.server.dao.BaseDao;
import com.limn.update.server.dao.EleShopDao;
import com.limn.update.server.entity.EleShopEntity;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by limengnan on 2017/11/30.
 */

@Repository
public class EleShopDaoImpl extends BaseDaoImpl<EleShopEntity> implements EleShopDao {

    @Autowired
    public void setDao(BaseDao<EleShopEntity> dao) {
        super.setDao(dao);
    }

    @Override
    public Object findMaxID() {
        return getSession().createQuery("select max(findid) from com.limn.update.server.entity.EleShopEntity").uniqueResult();
    }

    @Override
    public long count() {
        return 0;
//                (Long) getSession().createQuery("select count(DISTINCT id) from com.limn.update.server.entity.EleShopEntity").uniqueResult();
    }

    @Override
    public CoordinateVO getCoordinateByID(int id) {
        Query query = getSession().createQuery("select max(longitude),min(longitude),max(latitude),min(latitude)  from com.limn.update.server.entity.EleShopEntity where findid =" + id);
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
}
