package com.limn.update.server.dao.impl;

import com.limn.update.server.dao.BaseDao;
import com.limn.update.server.dao.SshhwwTaskUuidDao;
import com.limn.update.server.entity.SshhwwTaskUuidEntity;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by limengnan on 2018/4/24.
 */
@Repository
@Transactional
public class SshhwwTaskUuidDaoImpl extends BaseDaoImpl<SshhwwTaskUuidEntity> implements SshhwwTaskUuidDao {
    @Autowired
    public void setDao(BaseDao<SshhwwTaskUuidEntity> dao) {
        super.setDao(dao);
    }

    @Override
    public SshhwwTaskUuidEntity getTaskData(String taskName, String uuid) {
        SshhwwTaskUuidEntity task = null;
        Query query = getSession().createQuery("from com.limn.update.server.entity.SshhwwTaskUuidEntity where taskName = ? and (uuid = ? or isGlobal = 1)");
        query.setParameter(0,taskName);
        query.setParameter(1,uuid);
        List<SshhwwTaskUuidEntity> sshhwwTaskUuidEntitys = query.list();
        for(SshhwwTaskUuidEntity sshhwwTaskUuidEntity : sshhwwTaskUuidEntitys){
            if(null == task){
                task = sshhwwTaskUuidEntity;
            }else if(sshhwwTaskUuidEntity.getIsGlobal() == 1){
                task = sshhwwTaskUuidEntity;
            }
        }
        return task;
    }
}
