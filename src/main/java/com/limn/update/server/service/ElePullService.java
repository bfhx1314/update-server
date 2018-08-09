package com.limn.update.server.service;

import com.limn.update.server.bean.ResponseVo;
import com.limn.update.server.bean.ele.EleShopJsonBean;
import com.limn.update.server.dao.EleAnalysisDao;
import com.limn.update.server.entity.*;

import java.util.List;

/**
 * Created by limengnan on 2017/11/30.
 */
public interface ElePullService {

    FindCoordinateRecordEntity saveShopByCoordinate(String latitude, String longitude,boolean update, int version);
    void analysisByShop(List<EleShopJsonEntity> eleShopJsonEntities);
    void analysisByMenu(List<EleMenuJsonEntity> eleShopJsonEntities);
    void analysisByFood(List<EleMenuEntity> eleMenuEntitys);
    void analysisBySpecFood(List<EleFoodEntity> eleFoodEntities);
    void saveShop(EleShopJsonBean shop, int findId, int version);
    List<EleShopEntity> search(String name,int version,int sales);
    ResponseVo analysis(String type);
}
