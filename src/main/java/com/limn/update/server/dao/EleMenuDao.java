package com.limn.update.server.dao;

import com.limn.update.server.entity.EleMenuEntity;

import java.util.List;

public interface EleMenuDao  extends BaseDao<EleMenuEntity> {

    void deleteByShopId(int shopId);
    List<EleMenuEntity> getNoAnalysisShopJson();

}
