package com.limn.update.server.service;

import com.limn.update.server.entity.FindCoordinateRecordEntity;

/**
 * Created by limengnan on 2017/11/30.
 */
public interface ElePullService {

    FindCoordinateRecordEntity saveShopByCoordinate(String latitude, String longitude,boolean update);

}
