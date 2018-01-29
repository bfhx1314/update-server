package com.limn.update.server.dao.impl;

import com.limn.update.server.dao.BaseDao;
import com.limn.update.server.dao.SshhwwinfoDao;
import com.limn.update.server.entity.SshhhwwInfoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public class SshhwwinfoDaoImpl extends BaseDaoImpl<SshhhwwInfoEntity> implements SshhwwinfoDao {

    @Autowired
    public void setDao(BaseDao<SshhhwwInfoEntity> dao) {
        super.setDao(dao);
    }





}
