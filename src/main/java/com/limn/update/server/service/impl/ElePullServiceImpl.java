package com.limn.update.server.service.impl;

import com.limn.update.server.bean.CoordinateVO;
import com.limn.update.server.bean.ele.EleFoodBean;
import com.limn.update.server.bean.ele.EleMenuBean;
import com.limn.update.server.bean.ele.EleMenuSpecfood;
import com.limn.update.server.bean.ele.EleShopBean;
import com.limn.update.server.common.BaseUtil;
import com.limn.update.server.common.GetEleOrderInfo;
import com.limn.update.server.dao.*;
import com.limn.update.server.entity.*;
import com.limn.update.server.service.ElePullService;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by limengnan on 2017/11/30.
 */


@Service
public class ElePullServiceImpl implements ElePullService {

    @Autowired
    EleShopDao eleShopDao;

    @Autowired
    EleMenuDao eleMenuDao;

    @Autowired
    EleMenuFoodDao eleMenuFoodDao;

    @Autowired
    EleMenuSpecfoodDao eleMenuSpecfoodDao;

    @Autowired
    FindCoordinateRecordDao findCoordinateRecordDao;

    @Override
    @Transactional
    public FindCoordinateRecordEntity saveShopByCoordinate(String latitude, String longitude) {

        FindCoordinateRecordEntity fcre = new FindCoordinateRecordEntity();
        fcre.setLatitude(latitude);
        fcre.setLongitude(longitude);
        int findId = 1;
        Object findIdObject = eleShopDao.findMaxID();
        if(null != findIdObject && !findIdObject.toString().isEmpty()){
            findId = (int) findIdObject;
        }
        fcre.setFindid(++findId);

        Long originalCount = eleShopDao.count();

        List<Double> distance = new ArrayList<>();

        for(int i = 0 ; i <= 240 ; i = i + 24) {

            List<EleShopBean> shops = GetEleOrderInfo.getEleShopByCoordinate(latitude, longitude,  String.valueOf(i),String.valueOf(i+24));
            for (EleShopBean shop : shops) {
                try {
                    EleShopEntity eleshop = new EleShopEntity();
                    BeanUtils.copyProperties(eleshop, shop);
                    eleshop.setFindid(findId);
                    eleShopDao.saveOrUpdate(eleshop);

                    //添加距离
                    distance.add(BaseUtil.getDistance(latitude,longitude,eleshop.getLatitude(),eleshop.getLongitude()));

                    //获取菜单大类
                    List<EleMenuBean> menus = GetEleOrderInfo.getEleMenuById(eleshop.getId().toString());
                    for(EleMenuBean menu : menus){
                        EleMenuEntity eleMenuEntity = new EleMenuEntity();
                        BeanUtils.copyProperties(eleMenuEntity,menu);
                        eleMenuEntity.setShopId(eleshop.getId().toString());
                        eleMenuEntity.setCreateDate(new Date());
                        eleMenuDao.saveOrUpdate(eleMenuEntity);
//
                        //获取具体明细
                        List<EleFoodBean> foods = menu.getFoods();
                        for(EleFoodBean food : foods){
                            EleMenuFoodEntity eleMenuFoodEntity = new EleMenuFoodEntity();
                            BeanUtils.copyProperties(eleMenuFoodEntity,food);
                            eleMenuFoodEntity.setMenuId(eleMenuEntity.getId());
                            eleMenuFoodEntity.setCreateDate(new Date());
                            eleMenuFoodDao.saveOrUpdate(eleMenuFoodEntity);

                            List<EleMenuSpecfood> eleMenuSpecfoods = food.getSpecfoods();
                            for(EleMenuSpecfood eleMenuSpecfood : eleMenuSpecfoods){
                                EleMenuSpecfoodEntity eleMenuSpecfoodEntity = new EleMenuSpecfoodEntity();
                                BeanUtils.copyProperties(eleMenuSpecfoodEntity,eleMenuSpecfood);

                                eleMenuSpecfoodDao.saveOrUpdate(eleMenuSpecfoodEntity);

                            }
                        }
//
                    }
                    //TODO 活动
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        eleShopDao.flush();

        Long newCount = eleShopDao.count();

        fcre.setAddcount(newCount.intValue()-originalCount.intValue());
        fcre.setCurrentcount(newCount.intValue());

        CoordinateVO coordinateVO = eleShopDao.getCoordinateByID(findId);
        fcre.setMaxlongitude(coordinateVO.getMaxlongitude());
        fcre.setMinlongitude(coordinateVO.getMinlongitude());
        fcre.setMaxlatitude(coordinateVO.getMaxlatitude());
        fcre.setMinlatitude(coordinateVO.getMinlatitude());
        fcre.setAvgdistance(new BigDecimal(BaseUtil.getAvgByList(distance)).setScale(2,BigDecimal.ROUND_HALF_DOWN));

        System.out.print("原：" + originalCount);
        System.out.print("新：" + newCount);
        System.out.print("新增：" + (newCount - originalCount));

        findCoordinateRecordDao.save(fcre);
        return fcre;
    }


}
