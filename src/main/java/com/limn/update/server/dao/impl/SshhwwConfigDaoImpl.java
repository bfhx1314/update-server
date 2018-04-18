package com.limn.update.server.dao.impl;

import com.limn.update.server.common.BaseUtil;
import com.limn.update.server.dao.BaseDao;
import com.limn.update.server.dao.SshhwwConfigDao;
import com.limn.update.server.entity.SshhwwConfigEntity;
import com.limn.update.server.entity.SshhwwTaskEntity;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by limengnan on 2018/4/18.
 */
@Repository
@Transactional
public class SshhwwConfigDaoImpl extends BaseDaoImpl<SshhwwConfigEntity>  implements SshhwwConfigDao{
    @Autowired
    public void setDao(BaseDao<SshhwwConfigEntity> dao) {
        super.setDao(dao);
    }

    @Override
    public String getConfigByKey(String key) {
        Query query = getSession().createQuery("select value from SshhwwConfigEntity where key = ?");
        query.setParameter(0,key);
        List<String> list = query.list();
        if(null != list && list.size() == 1){
            return list.get(0);
        }
        return null;
    }
}
