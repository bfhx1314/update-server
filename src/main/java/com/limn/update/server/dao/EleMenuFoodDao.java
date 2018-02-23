package com.limn.update.server.dao;

import com.limn.update.server.entity.EleMenuFoodEntity;

public interface EleMenuFoodDao extends BaseDao<EleMenuFoodEntity> {
    void deleteByShopId(String shopId);

}
