package com.limn.update.server.dao;

import com.limn.update.server.entity.EleShopEntity;

import java.util.List;

/**
 * Created by limengnan on 2017/11/30.
 */


public interface EleShopDao extends EleAnalysisDao<EleShopEntity> {

    List<EleShopEntity> getShopsByName(String name,int version,int sales);
}
