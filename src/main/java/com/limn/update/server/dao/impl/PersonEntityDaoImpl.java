package com.limn.update.server.dao.impl;

import com.limn.update.server.dao.BaseDao;
import com.limn.update.server.dao.PersonEntityDao;
import com.limn.update.server.entity.PersonEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by limengnan on 2017/11/30.
 */

@Repository
public class PersonEntityDaoImpl extends BaseDaoImpl<PersonEntity> implements PersonEntityDao {


    @Autowired
    public void setDao(BaseDao<PersonEntity> dao) {
        super.setDao(dao);
    }


}
