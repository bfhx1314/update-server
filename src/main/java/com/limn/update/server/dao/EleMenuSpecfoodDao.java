package com.limn.update.server.dao;

import com.limn.update.server.entity.EleMenuSpecfoodEntity;

public interface EleMenuSpecfoodDao extends BaseDao<EleMenuSpecfoodEntity> {
    void deleteByShopId(String shopId);

}
