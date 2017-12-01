package com.limn.update.server.service.impl;

import com.limn.update.server.bean.CoordinateVO;
import com.limn.update.server.bean.ele.EleShopBean;
import com.limn.update.server.common.BaseUtil;
import com.limn.update.server.common.GetEleOrderInfo;
import com.limn.update.server.dao.EleShopDao;
import com.limn.update.server.dao.FindCoordinateRecordDao;
import com.limn.update.server.entity.EleShopEntity;
import com.limn.update.server.entity.FindCoordinateRecordEntity;
import com.limn.update.server.service.ElePullService;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by limengnan on 2017/11/30.
 */


@Service
public class ElePullServiceImpl implements ElePullService {

    @Autowired
    EleShopDao eleShopDao;

    @Autowired
    FindCoordinateRecordDao findCoordinateRecordDao;

    @Override
    @Transactional
    public FindCoordinateRecordEntity saveShopByCoordinate(String latitude, String longitude) {
//        DataBaseConnection conn1 = new DataBaseConnection();

        FindCoordinateRecordEntity fcre = new FindCoordinateRecordEntity();
        fcre.setLatitude(latitude);
        fcre.setLongitude(longitude);
        int findId = 1;
        Object findIdObject = eleShopDao.findMaxID();
//                conn1.query("select max(findid) from com.ele.entity.EleShopEntity");
        if(null != findIdObject && !findIdObject.toString().isEmpty()){
            findId = (int) findIdObject;
        }
        fcre.setFindid(++findId);


        Long originalCount = eleShopDao.count();
//                (Long) conn1.query("select count(DISTINCT id) from com.ele.entity.EleShopEntity");

        List<Double> distance = new ArrayList<>();

        for(int i = 0 ; i <= 240 ; i = i + 24) {

            List<EleShopBean> shops = GetEleOrderInfo.getEleShopByCoordinate(latitude, longitude,  String.valueOf(i),String.valueOf(i+24));
            for (EleShopBean shop : shops) {
//                DataBaseConnection conn = new DataBaseConnection();
                try {

                    EleShopEntity eleshop = new EleShopEntity();
                    BeanUtils.copyProperties(eleshop, shop);
                    eleshop.setFindid(findId);
                    eleShopDao.save(eleshop);
//                    conn.executeSave(eleshop);

                    //添加距离
                    distance.add(BaseUtil.getDistance(latitude,longitude,eleshop.getLatitude(),eleshop.getLongitude()));

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
