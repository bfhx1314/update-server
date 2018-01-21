package com.limn.update.server.dao.impl;

import com.limn.update.server.dao.BaseDao;
import com.limn.update.server.dao.QttRunRecordDao;
import com.limn.update.server.entity.QttRunRecordEntity;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;



@Repository
@Transactional
public class QttRunRecordDaoImpl extends BaseDaoImpl<QttRunRecordEntity> implements QttRunRecordDao {

    @Autowired
    public void setDao(BaseDao<QttRunRecordEntity> dao) {
        super.setDao(dao);
    }


    @Override
    public QttRunRecordEntity getUserByKey(String key) {

        Query query = getSession().createQuery("from QttRunRecordEntity where key = ?");
        query.setParameter(0,key);
        QttRunRecordEntity  qttRunRecordEntity = (QttRunRecordEntity)query.uniqueResult();
        return qttRunRecordEntity;
    }
}
