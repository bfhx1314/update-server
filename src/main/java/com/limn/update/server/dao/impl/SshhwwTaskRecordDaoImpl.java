package com.limn.update.server.dao.impl;

import com.limn.update.server.dao.BaseDao;
import com.limn.update.server.dao.SshhwwTaskRecordDao;
import com.limn.update.server.entity.SshhwwTaskRecordEntity;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by limengnan on 2018/1/29.
 */
@Repository
@Transactional
public class SshhwwTaskRecordDaoImpl extends BaseDaoImpl<SshhwwTaskRecordEntity> implements SshhwwTaskRecordDao {

    @Autowired
    public void setDao(BaseDao<SshhwwTaskRecordEntity> dao) {
        super.setDao(dao);
    }


    @Override
    public SshhwwTaskRecordEntity getTaskRecord(SshhwwTaskRecordEntity sshhwwTaskRecordEntity) {

        Query query = getSession().createQuery("from SshhwwTaskRecordEntity where uuid = ? and id = ? and status = ?");
        query.setParameter(0,sshhwwTaskRecordEntity.getUuid());
        query.setParameter(1,sshhwwTaskRecordEntity.getId());
        query.setParameter(2,sshhwwTaskRecordEntity.getStatus());
        List<SshhwwTaskRecordEntity> list = query.list();
        if(list == null || list.size() == 0){
            return null;
        }
        return list.get(0);
    }
}
