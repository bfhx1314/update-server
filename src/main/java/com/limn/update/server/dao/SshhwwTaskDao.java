package com.limn.update.server.dao;

import com.limn.update.server.entity.SshhwwTaskEntity;

import java.util.List;

/**
 * Created by limengnan on 2018/1/29.
 */
public interface SshhwwTaskDao extends BaseDao<SshhwwTaskEntity> {

    List<SshhwwTaskEntity> getTask(String uuid);


}
