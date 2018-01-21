package com.limn.update.server.dao.impl;

import com.limn.update.server.dao.BaseDao;
import com.limn.update.server.dao.WXCMinfoDao;
import com.limn.update.server.entity.WXCMInfoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public class WXCMinfoDaoImpl extends BaseDaoImpl<WXCMInfoEntity> implements WXCMinfoDao {

    @Autowired
    public void setDao(BaseDao<WXCMInfoEntity> dao) {
        super.setDao(dao);
    }





}
