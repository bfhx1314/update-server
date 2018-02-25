package com.limn.update.server.dao.impl;

import com.limn.tool.common.DateFormat;
import com.limn.update.server.dao.BaseDao;
import com.limn.update.server.dao.SshhwwTaskDao;
import com.limn.update.server.entity.SshhwwTaskEntity;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by limengnan on 2018/1/29.
 */

@Repository
@Transactional
public class SshhwwTaskDaoImpl extends BaseDaoImpl<SshhwwTaskEntity> implements SshhwwTaskDao {
    @Autowired
    public void setDao(BaseDao<SshhwwTaskEntity> dao) {
        super.setDao(dao);
    }

    @Override
    public List<SshhwwTaskEntity> getTask(String uuid,String type) {
        Query query = getSession().createQuery("select t1 from SshhwwTaskEntity t1 " +
                "left join SshhwwTaskRecordEntity t2 on t1.id = t2.taskId and TO_DAYS(t2.createDate) = TO_DAYS(?) and t2.uuid = ? and t2.valid = 'Y'" +
                "where t1.startTime < ? and t1.endTime > ? and t2.id is null and t1.valid = 'Y' and t1.type = ?");
        query.setParameter(0,new Date());
        query.setParameter(1,uuid);
        query.setParameter(2,new Date());
        query.setParameter(3,new Date());
        query.setParameter(4,type);
        List<SshhwwTaskEntity> list = query.list();
        return list;
    }
}
