package com.limn.update.server.service;

import com.limn.update.server.bean.ResponseVo;
import com.limn.update.server.bean.ele.EleShopJsonBean;
import com.limn.update.server.entity.EleMenuEntity;
import com.limn.update.server.entity.FindCoordinateRecordEntity;

import java.util.List;

/**
 * Created by limengnan on 2017/11/30.
 */
public interface ElePullService {

    FindCoordinateRecordEntity saveShopByCoordinate(String latitude, String longitude,boolean update);

    ResponseVo analysisShop();

    ResponseVo analysisMenu();
    ResponseVo analysisFood();
    void saveShop(EleShopJsonBean shop, int findId);
    void analysisByFood(List<EleMenuEntity> eleMenuEntitys);
}
