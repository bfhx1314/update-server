package com.limn.update.server.dao.impl;

import com.limn.update.server.dao.BaseDao;
import com.limn.update.server.dao.QttUserAttachmentDao;
import com.limn.update.server.entity.QttUserAttachmentEntity;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
@Transactional
public class QttUserAttachmentDaoImpl extends BaseDaoImpl<QttUserAttachmentEntity> implements QttUserAttachmentDao {
    @Autowired
    public void setDao(BaseDao<QttUserAttachmentEntity> dao) {
        super.setDao(dao);
    }

    @Override
    public List<QttUserAttachmentEntity> getUserAttachments(QttUserAttachmentEntity entity) {
        Query query =  getSession().createQuery("from QttUserAttachmentEntity");
        query.setProperties(entity);
        return query.list();
    }



}
