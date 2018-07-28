package com.limn.update.server.dao;

import com.limn.update.server.entity.EleMenuEntity;

import java.util.List;

public interface EleMenuDao  extends EleAnalysisDao<EleMenuEntity> {

    void deleteByShopId(int shopId);
//    List<EleMenuEntity> getNoAnalysisMemuJson(int start,int count);

}
