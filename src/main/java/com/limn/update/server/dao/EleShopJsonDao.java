package com.limn.update.server.dao;

import com.limn.update.server.bean.CoordinateVO;
import com.limn.update.server.entity.EleShopJsonEntity;

import java.util.List;

/**
 * Created by limengnan on 2018/4/20.
 */
public interface EleShopJsonDao extends EleAnalysisDao<EleShopJsonEntity>{
    Object findMaxID();
    long count();
    CoordinateVO getCoordinateByID(int id);
    boolean isExistShop(int shopId,int version);
//    List<EleShopJsonEntity> getNoAnalysisShopJson();
//    void saveIsAnalysised(EleShopJsonEntity eleShopJsonEntity);
}
