package com.limn.update.server.dao.impl;

import com.limn.update.server.dao.BaseDao;
import com.limn.update.server.dao.FindCoordinateRecordDao;
import com.limn.update.server.entity.FindCoordinateRecordEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by limengnan on 2017/11/30.
 */

@Repository
public class FindCoordinateRecordDaoImpl extends BaseDaoImpl<FindCoordinateRecordEntity> implements FindCoordinateRecordDao {

    @Autowired
    public void setDao(BaseDao<FindCoordinateRecordEntity> dao) {
        super.setDao(dao);
    }

}
