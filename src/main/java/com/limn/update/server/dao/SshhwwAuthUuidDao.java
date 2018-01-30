package com.limn.update.server.dao;

import com.limn.update.server.entity.SshhwwAuthUuidEntity;

/**
 * Created by limengnan on 2018/1/30.
 */
public interface SshhwwAuthUuidDao extends BaseDao<SshhwwAuthUuidEntity> {

    boolean isAuthByUuid(String uuid);


}
