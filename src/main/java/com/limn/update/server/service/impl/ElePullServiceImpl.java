package com.limn.update.server.service.impl;

import com.limn.tool.common.Print;
import com.limn.update.server.bean.CoordinateVO;
import com.limn.update.server.bean.ele.*;
import com.limn.update.server.common.BaseUtil;
import com.limn.update.server.common.GetEleOrderInfo;
import com.limn.update.server.dao.*;
import com.limn.update.server.entity.*;
import com.limn.update.server.service.ElePullService;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.helpers.Loader;
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
    EleShopJsonDao eleShopJsonDao;

    @Autowired
    EleMenuJsonDao eleMenuJsonDao;

    @Autowired
    FindCoordinateRecordDao findCoordinateRecordDao;

    private static Logger LOGGER = LogManager.getLogger(ElePullServiceImpl.class);

    @Override
    @Transactional
    public FindCoordinateRecordEntity saveShopByCoordinate(String latitude, String longitude,boolean update) {

        FindCoordinateRecordEntity fcre = new FindCoordinateRecordEntity();
        fcre.setLatitude(latitude);
        fcre.setLongitude(longitude);
        int findId = 1;
        Object findIdObject = eleShopJsonDao.findMaxID();
        if(null != findIdObject && !findIdObject.toString().isEmpty()){
            findId = (int) findIdObject;
        }
        fcre.setFindid(++findId);

        Long originalCount = eleShopJsonDao.count();

        List<Double> distance = new ArrayList<>();

        for(int i = 0 ; i <= 240 ; i = i + 24) {

            List<EleShopJsonBean> shops = GetEleOrderInfo.getEleShopByCoordinate(latitude, longitude,  String.valueOf(i),String.valueOf(i+24));
            for (EleShopJsonBean shop : shops) {
                //添加距离
                distance.add(BaseUtil.getDistance(latitude,longitude,shop.getLatitude(),shop.getLongitude()));
                if(eleShopJsonDao.isExistShop(shop.getShopId())) {
                    System.out.println("[已存在] shopId:" + shop.getShopId() + ",shopName:" + shop.getShopName());
                    if(!update){
                        continue;
                    }
                }
                System.out.println("<未存在> shopId:" + shop.getShopId() + ",shopName:" + shop.getShopName());
                saveShop(shop, findId);
            }
        }
        eleShopJsonDao.flush();

        Long newCount = eleShopJsonDao.count();

        fcre.setAddcount(newCount.intValue()-originalCount.intValue());
        fcre.setCurrentcount(newCount.intValue());

        if(fcre.getAddcount() != 0) {
            CoordinateVO coordinateVO = eleShopJsonDao.getCoordinateByID(findId);
            fcre.setMaxlongitude(coordinateVO.getMaxlongitude());
            fcre.setMinlongitude(coordinateVO.getMinlongitude());
            fcre.setMaxlatitude(coordinateVO.getMaxlatitude());
            fcre.setMinlatitude(coordinateVO.getMinlatitude());
            fcre.setAvgdistance(new BigDecimal(BaseUtil.getAvgByList(distance)).setScale(2, BigDecimal.ROUND_HALF_DOWN));
        }

        System.out.print("原：" + originalCount);
        System.out.print("新：" + newCount);
        System.out.println("新增：" + (newCount - originalCount));

        findCoordinateRecordDao.save(fcre);
        return fcre;
    }


    private void saveShop(EleShopJsonBean shop, int findId){

        try {
            EleShopJsonEntity eleShopJson = new EleShopJsonEntity();
            BeanUtils.copyProperties(eleShopJson, shop);
            eleShopJson.setFindId(findId);
            eleShopJson.setCreateDate(new Date());
            eleShopJson.setValid("Y");
            eleShopJson.setVersion(1);
            eleShopJsonDao.merge(eleShopJson);

            //删除门店下所有分类菜单
            eleMenuJsonDao.deleteByShopId(shop.getShopId());
//            eleMenuFoodDao.deleteByShopId(shop.getId());
//            eleMenuSpecfoodDao.deleteByShopId(shop.getId());

            //分类菜单
            List<EleMenuJsonBean> menus = GetEleOrderInfo.getEleMenuById(shop.getShopId());
            for(EleMenuJsonBean menu : menus){
                EleMenuJsonEntity eleMenuEntity = new EleMenuJsonEntity();
                BeanUtils.copyProperties(eleMenuEntity,menu);
                eleMenuEntity.setCreateDate(new Date());
                eleMenuEntity.setShopId(shop.getShopId());
                eleMenuEntity.setVersion(0);
                eleMenuEntity.setValid("Y");
                eleMenuJsonDao.saveOrUpdate(eleMenuEntity);

//                //食物菜单
//                List<EleFoodBean> foods = menu.getFoods();
//                for(EleFoodBean food : foods){
//                    EleMenuFoodEntity eleMenuFoodEntity = new EleMenuFoodEntity();
//                    BeanUtils.copyProperties(eleMenuFoodEntity,food);
//                    eleMenuFoodEntity.setShopId(eleMenuEntity.getShopId());
//                    eleMenuFoodEntity.setMenuId(eleMenuEntity.getId());
//                    eleMenuFoodEntity.setCreateDate(new Date());
//                    eleMenuFoodDao.saveOrUpdate(eleMenuFoodEntity);
//
//                    //食物明细
//                    List<EleMenuSpecfood> eleMenuSpecfoods = food.getSpecfoods();
//                    for(EleMenuSpecfood eleMenuSpecfood : eleMenuSpecfoods){
//                        EleMenuSpecfoodEntity eleMenuSpecfoodEntity = new EleMenuSpecfoodEntity();
//                        BeanUtils.copyProperties(eleMenuSpecfoodEntity,eleMenuSpecfood);
//                        eleMenuSpecfoodEntity.setCreateDate(new Date());
//                        eleMenuSpecfoodEntity.setShopId(eleMenuEntity.getShopId());
//                        eleMenuSpecfoodDao.saveOrUpdate(eleMenuSpecfoodEntity);
//                    }
//                }
//
            }
            //TODO 活动
        } catch (Exception e) {
            e.printStackTrace();
        }


    }




}
