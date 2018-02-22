package com.limn.update.server.service.impl;

import com.limn.update.server.bean.CoordinateVO;
import com.limn.update.server.bean.ele.EleFoodBean;
import com.limn.update.server.bean.ele.EleMenuBean;
import com.limn.update.server.bean.ele.EleShopBean;
import com.limn.update.server.common.BaseUtil;
import com.limn.update.server.common.GetEleOrderInfo;
import com.limn.update.server.dao.EleMenuDao;
import com.limn.update.server.dao.EleMenuFoodDao;
import com.limn.update.server.dao.EleShopDao;
import com.limn.update.server.dao.FindCoordinateRecordDao;
import com.limn.update.server.entity.EleMenuEntity;
import com.limn.update.server.entity.EleMenuFoodEntity;
import com.limn.update.server.entity.EleShopEntity;
import com.limn.update.server.entity.FindCoordinateRecordEntity;
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
                    eleShopDao.save(eleshop);

                    //添加距离
                    distance.add(BaseUtil.getDistance(latitude,longitude,eleshop.getLatitude(),eleshop.getLongitude()));


                    //获取菜单
                    List<EleMenuBean> menus = GetEleOrderInfo.getEleMenuById(eleshop.getId().toString());
                    for(EleMenuBean menu : menus){
                        EleMenuEntity eleMenuEntity = new EleMenuEntity();
                        BeanUtils.copyProperties(eleMenuEntity,menu);
                        eleMenuEntity.setShopId(eleshop.getId().toString());
                        eleMenuEntity.setCreateDate(new Date());
                        eleMenuDao.save(eleMenuEntity);

                        List<EleFoodBean> foods = menu.getFoods();
                        for(EleFoodBean food : foods){
                            EleMenuFoodEntity eleMenuFoodEntity = new EleMenuFoodEntity();
                            BeanUtils.copyProperties(eleMenuFoodEntity,food);
                            eleMenuFoodEntity.setMenu_id(eleMenuEntity.getMenu_id());
                            eleMenuFoodEntity.setCreateDate(new Date());
                            eleMenuFoodDao.save(eleMenuFoodEntity);
                        }

                    }

//                    saveActivitie(shop, conn);
//                    saveMenu(shop.getId(), conn);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        eleShopDao.flush();

        Long newCount = eleShopDao.count();
//                (Long) conn1.query("select count(DISTINCT id) from com.ele.entity.EleShopEntity");

        fcre.setAddcount(newCount.intValue()-originalCount.intValue());
        fcre.setCurrentcount(newCount.intValue());

        CoordinateVO coordinateVO = eleShopDao.getCoordinateByID(findId);
//        Object[] coo = (Object[])conn1.query("select max(longitude),min(longitude),max(latitude),min(latitude) from com.ele.entity.EleShopEntity where findid =" + findId);
        fcre.setMaxlongitude(coordinateVO.getMaxlongitude());
        fcre.setMinlongitude(coordinateVO.getMinlongitude());
        fcre.setMaxlatitude(coordinateVO.getMaxlatitude());
        fcre.setMinlatitude(coordinateVO.getMinlatitude());
        fcre.setAvgdistance(new BigDecimal(BaseUtil.getAvgByList(distance)).setScale(2,BigDecimal.ROUND_HALF_DOWN));

        System.out.print("原：" + originalCount);
        System.out.print("新：" + newCount);
        System.out.print("新增：" + (newCount - originalCount));

        findCoordinateRecordDao.save(fcre);
//        conn1.executeSave(fcre);
//        conn1.commit();
        return fcre;

    }


}
