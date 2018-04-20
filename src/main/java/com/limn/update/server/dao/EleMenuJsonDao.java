package com.limn.update.server.dao;

import com.limn.update.server.entity.EleMenuJsonEntity;

/**
 * Created by limengnan on 2018/4/20.
 */
public interface EleMenuJsonDao extends BaseDao<EleMenuJsonEntity>{

    void deleteByShopId(int shopId);
}
