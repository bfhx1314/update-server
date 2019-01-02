package com.limn.update.server.dao.impl;

import com.limn.update.server.common.BaseUtil;
import com.limn.update.server.dao.BaseDao;
import com.limn.update.server.dao.EleShopActivitieDao;
import com.limn.update.server.dao.EleShopDao;
import com.limn.update.server.entity.EleShopActivitieEntity;
import com.limn.update.server.entity.EleShopEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by limengnan on 2017/11/30.
 */

@Repository
@Transactional
public class EleShopActivitieDaoImpl extends BaseDaoImpl<EleShopActivitieEntity> implements EleShopActivitieDao {

    @Autowired
    public void setDao(BaseDao<EleShopActivitieEntity> dao) {
        super.setDao(dao);
    }


    @Override
    public List<EleShopActivitieEntity> getNoAnalysis(int maxCount) {
        return null;
    }
}
