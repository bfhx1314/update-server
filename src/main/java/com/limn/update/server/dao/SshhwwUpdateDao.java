package com.limn.update.server.dao;

import com.limn.update.server.entity.SshhwwUpdateEntity;

/**
 * Created by limengnan on 2018/1/25.
 */
public interface SshhwwUpdateDao extends BaseDao<SshhwwUpdateEntity> {

    SshhwwUpdateEntity getUpdateVersion(SshhwwUpdateEntity sshhwwUpdateEntity);

}
