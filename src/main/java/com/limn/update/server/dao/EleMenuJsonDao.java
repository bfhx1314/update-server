package com.limn.update.server.dao;

import com.limn.update.server.entity.EleMenuJsonEntity;

import java.util.List;

/**
 * Created by limengnan on 2018/4/20.
 */
public interface EleMenuJsonDao extends EleAnalysisDao<EleMenuJsonEntity>{

    void deleteByShopId(String shopId , int version);
//    List<EleMenuJsonEntity> getNoAnalysisMenuJson();
}
