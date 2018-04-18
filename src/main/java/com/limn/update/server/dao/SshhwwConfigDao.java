package com.limn.update.server.dao;

import com.limn.update.server.entity.SshhwwConfigEntity;

/**
 * Created by limengnan on 2018/4/18.
 */
public interface SshhwwConfigDao extends BaseDao<SshhwwConfigEntity> {

    String getConfigByKey(String key);

}
