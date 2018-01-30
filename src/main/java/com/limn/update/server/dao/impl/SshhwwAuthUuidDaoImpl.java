package com.limn.update.server.dao.impl;

import com.limn.update.server.dao.BaseDao;
import com.limn.update.server.dao.SshhwwAuthUuidDao;
import com.limn.update.server.entity.SshhwwAuthUuidEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by limengnan on 2018/1/30.
 */
@Repository
@Transactional
public class SshhwwAuthUuidDaoImpl extends BaseDaoImpl<SshhwwAuthUuidEntity> implements SshhwwAuthUuidDao {
    @Autowired
    public void setDao(BaseDao<SshhwwAuthUuidEntity> dao) {
        super.setDao(dao);
    }

    @Override
    public boolean isAuthByUuid(String uuid) {
        List<SshhwwAuthUuidEntity> list =  getSession().createQuery("from SshhwwAuthUuidEntity where uuid = ? and valid = 'Y' and status = '1'").setParameter(0,uuid).list();
        if(null == list || list.size() == 0 ) {
            return false;
        }
        return true;
    }
}
