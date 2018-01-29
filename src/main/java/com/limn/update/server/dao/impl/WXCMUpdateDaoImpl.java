package com.limn.update.server.dao.impl;

import com.limn.update.server.dao.BaseDao;
import com.limn.update.server.dao.WXCMUpdateDao;
import com.limn.update.server.entity.WXCMUpdateEntity;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

/**
 * Created by limengnan on 2018/1/25.
 */
@Repository
@Transactional
public class WXCMUpdateDaoImpl extends BaseDaoImpl<WXCMUpdateEntity> implements WXCMUpdateDao {
    @Autowired
    public void setDao(BaseDao<WXCMUpdateEntity> dao) {
        super.setDao(dao);
    }


    @Override
    public WXCMUpdateEntity getUpdateVersion(WXCMUpdateEntity wxcmUpdateEntity) {
        wxcmUpdateEntity.setValid("Y");
        Query query = getSession().createQuery("from WXCMUpdateEntity where version > ? and type = ? and md5 != ? and valid = 'Y' order by id desc");
        query.setParameter(0,wxcmUpdateEntity.getVersion());
        query.setParameter(1,wxcmUpdateEntity.getType());
        query.setParameter(2,wxcmUpdateEntity.getMd5());
        if(query.list() == null || query.list().size() == 0) {
            return null;
        }
        return (WXCMUpdateEntity)query.list().get(0);
    }
}
