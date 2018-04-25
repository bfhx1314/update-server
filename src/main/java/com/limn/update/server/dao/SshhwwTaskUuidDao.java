package com.limn.update.server.dao;

import com.limn.update.server.entity.SshhwwTaskUuidEntity;

/**
 * Created by limengnan on 2018/4/24.
 */
public interface SshhwwTaskUuidDao extends BaseDao<SshhwwTaskUuidEntity>  {

    SshhwwTaskUuidEntity getTaskData(String taskName,String uuid);

}
