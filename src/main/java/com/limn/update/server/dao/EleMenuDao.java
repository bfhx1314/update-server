package com.limn.update.server.dao;

import com.limn.update.server.entity.EleMenuEntity;

public interface EleMenuDao  extends BaseDao<EleMenuEntity> {

    void deleteByShopId(int shopId);



}
