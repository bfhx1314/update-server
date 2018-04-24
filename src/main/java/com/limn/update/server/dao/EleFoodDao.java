package com.limn.update.server.dao;

import com.limn.update.server.bean.ResponseVo;
import com.limn.update.server.entity.EleFoodEntity;

import java.util.List;

/**
 * Created by limengnan on 2018/4/23.
 */
public interface EleFoodDao  extends BaseDao<EleFoodEntity> {

    List<EleFoodEntity> getNoAnalysisShopJson();
}
