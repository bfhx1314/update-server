package com.limn.update.server.dao;

import com.limn.update.server.bean.CoordinateVO;
import com.limn.update.server.entity.EleShopEntity;
import org.springframework.stereotype.Repository;

/**
 * Created by limengnan on 2017/11/30.
 */


public interface EleShopDao extends BaseDao<EleShopEntity> {

    Object findMaxID();

    long count();

    CoordinateVO getCoordinateByID(int id);

    boolean isExistShop(int shopId);


}
