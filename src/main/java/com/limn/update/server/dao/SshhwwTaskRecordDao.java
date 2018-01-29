package com.limn.update.server.dao;

import com.limn.update.server.entity.SshhwwTaskRecordEntity;

/**
 * Created by limengnan on 2018/1/29.
 */
public interface SshhwwTaskRecordDao extends BaseDao<SshhwwTaskRecordEntity> {

    SshhwwTaskRecordEntity getTaskRecord(SshhwwTaskRecordEntity sshhwwTaskRecordEntity);


}
