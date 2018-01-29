package com.limn.update.server.dao.impl;

import com.limn.update.server.dao.BaseDao;
import com.limn.update.server.dao.SshhwwUpdateDao;
import com.limn.update.server.entity.SshhwwUpdateEntity;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by limengnan on 2018/1/25.
 */
@Repository
@Transactional
public class SshhwwUpdateDaoImpl extends BaseDaoImpl<SshhwwUpdateEntity> implements SshhwwUpdateDao {
    @Autowired
    public void setDao(BaseDao<SshhwwUpdateEntity> dao) {
        super.setDao(dao);
    }


    @Override
    public SshhwwUpdateEntity getUpdateVersion(SshhwwUpdateEntity sshhwwUpdateEntity) {
        sshhwwUpdateEntity.setValid("Y");
        Query query = getSession().createQuery("from SshhwwUpdateEntity where version > ? and type = ? and md5 != ? and valid = 'Y' order by id desc");
        query.setParameter(0, sshhwwUpdateEntity.getVersion());
        query.setParameter(1, sshhwwUpdateEntity.getType());
        query.setParameter(2, sshhwwUpdateEntity.getMd5());
        if(query.list() == null || query.list().size() == 0) {
            return null;
        }
        return (SshhwwUpdateEntity)query.list().get(0);
    }
}
