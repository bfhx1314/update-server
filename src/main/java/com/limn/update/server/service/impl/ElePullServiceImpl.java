package com.limn.update.server.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.limn.tool.common.BaseToolParameter;
import com.limn.tool.common.Common;
import com.limn.tool.common.DateFormat;
import com.limn.tool.random.RandomData;
import com.limn.update.server.bean.CoordinateVO;
import com.limn.update.server.bean.ResponseVo;
import com.limn.update.server.bean.ele.*;
import com.limn.update.server.common.BaseUtil;
import com.limn.update.server.common.GetEleOrderInfo;
import com.limn.update.server.dao.*;
import com.limn.update.server.entity.*;
import com.limn.update.server.service.ElePullService;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.*;

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

    @Autowired
    EleShopDao eleShopDao;

    @Autowired
    EleMenuDao eleMenuDao;

    @Autowired
    EleFoodDao eleFoodDao;

    @Autowired
    EleSpecfoodDao eleSpecfoodDao;

    @Autowired
    EleShopActivitieDao eleShopActivitieDao;

    private static Logger LOGGER = LogManager.getLogger(ElePullServiceImpl.class);

    @Override
    public FindCoordinateRecordEntity saveShopByCoordinate(String latitude, String longitude,boolean update, int version) {

        int latitudeNum = 6 - latitude.length() + latitude.lastIndexOf(".") + 1;
        int longitudeNum = 6 - longitude.length() + longitude.lastIndexOf(".") + 1;
        if(latitudeNum>0){
            latitude = latitude + RandomData.getInt(latitudeNum);
        }
        if(longitudeNum>0){
            longitude = longitude + RandomData.getInt(longitudeNum);
        }

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

        for(int i = 0 ; i <= 480 ; i = i + 24) {

            List<EleShopJsonBean> shops = GetEleOrderInfo.getEleShopByCoordinate(latitude, longitude,  String.valueOf(i),String.valueOf(i+24));
            for (EleShopJsonBean shop : shops) {
                //添加距离
                distance.add(BaseUtil.getDistance(latitude,longitude,shop.getLatitude(),shop.getLongitude()));
                if(eleShopJsonDao.isExistShop(shop.getShopId(),version)) {
//                    System.out.println("[已存在] shopId:" + shop.getShopId() + ",shopName:" + shop.getShopName());
                    if(!update){
                        continue;
                    }
                }
                System.out.println("<新增> shopId:" + shop.getShopId() + ",shopName:" + shop.getShopName());
                saveShop(shop, findId,version);
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

        Long addShopNum = newCount - originalCount;
        System.out.println("坐标：[" + longitude + ":" + latitude + "] 商店新增：[" + addShopNum + "] 总计：[" + newCount + "]");
        fcre.setCreateDate(new Date());
        findCoordinateRecordDao.saveAs(fcre);
        int num = addShopNum.intValue()/20;
        BaseToolParameter.getPrintThreadLocal().log("Wait : " + 60000 * num, 0);
        Common.wait(60000 * num);
        return fcre;
    }

    @Override
    public List<EleShopEntity> search(String name,int version,int sales){
        List<EleShopEntity>  lists = eleShopDao.getShopsByName(name,version,sales);
        Collections.sort(lists, new Comparator<EleShopEntity>() {
            @Override
            public int compare(EleShopEntity o1, EleShopEntity o2) {
                int i = Integer.valueOf(o2.getRecentOrderNum()) - Integer.valueOf(o1.getRecentOrderNum());
                if(i == 0){
                    return Integer.valueOf(o2.getRecentOrderNum()) - Integer.valueOf(o1.getRecentOrderNum());
                }
                return i;
            }

        });
        return lists;
    }

    @Override
    @Transactional
    public void saveShop(EleShopJsonBean shop, int findId,int version){

        try {
            EleShopJsonEntity eleShopJson = new EleShopJsonEntity();
            BeanUtils.copyProperties(eleShopJson, shop);
            eleShopJson.setFindId(findId);
            eleShopJson.setCreateDate(new Date());
            eleShopJson.setValid("Y");
            eleShopJson.setVersion(version);
            eleShopJson.setIsAnalysis(0);
            eleShopJsonDao.mergeAs(eleShopJson);

            //删除门店下所有分类菜单
            eleMenuJsonDao.deleteByShopId(shop.getShopId(),version);

            //分类菜单
            Common.wait(1000);
            List<EleMenuJsonBean> menus = GetEleOrderInfo.getEleMenuById(shop.getShopId());
            for(EleMenuJsonBean menu : menus){

                EleMenuJsonEntity eleMenuEntity = new EleMenuJsonEntity();
                BeanUtils.copyProperties(eleMenuEntity,menu);
                eleMenuEntity.setCreateDate(new Date());
                eleMenuEntity.setShopId(shop.getShopId());
                eleMenuEntity.setVersion(version);
                eleMenuEntity.setValid("Y");
                eleMenuEntity.setIsAnalysis(0);
                eleMenuJsonDao.mergeAs(eleMenuEntity);
            }
            //TODO 活动
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Autowired
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;

    @Override
    public void analysisByShop( List<EleShopJsonEntity> eleShopJsonEntities) {
        for(EleShopJsonEntity eleShopJsonEntity : eleShopJsonEntities){
            EleShopEntity eleShopEntity = JSONObject.parseObject(eleShopJsonEntity.getJson(),EleShopEntity.class);
            eleShopEntity.setCreateDate(new Date());
            eleShopEntity.setIsAnalysis(0);
            eleShopEntity.setShopId(eleShopJsonEntity.getShopId());
            eleShopEntity.setVersion(eleShopJsonEntity.getVersion());
            eleShopEntity.setAnalysisTime(eleShopJsonEntity.getCreateDate());
            eleShopDao.saveAs(eleShopEntity);
            eleShopJsonEntity.setIsAnalysis(1);
            eleShopJsonDao.updateAs(eleShopJsonEntity);
        }
    }
    @Override
    public void analysisByFood(List<EleMenuEntity> eleMenuEntitys){
        int count = 0;
        for(EleMenuEntity eleMenuEntity:eleMenuEntitys) {
            List<EleFoodEntity> eleFoodEntities = JSONObject.parseArray(eleMenuEntity.getFoods(), EleFoodEntity.class);
            for (EleFoodEntity eleFoodEntity : eleFoodEntities) {
                eleFoodEntity.setCreateDate(new Date());
                eleFoodEntity.setIsAnalysis(0);
                eleFoodEntity.setShopId(eleMenuEntity.getShopId());
                eleFoodEntity.setMenuId(eleMenuEntity.getMenuId());
                eleFoodEntity.setVersion(eleMenuEntity.getVersion());
                eleFoodEntity.setAnalysisTime(eleMenuEntity.getAnalysisTime());
                eleFoodDao.saveAs(eleFoodEntity);
                count++;
            }
            eleMenuEntity.setIsAnalysis(1);
            eleMenuDao.updateAs(eleMenuEntity);
        }
        System.out.println("新增Food数据:" +count);
    }

    @Override
    public void analysisBySpecFood(List<EleFoodEntity> eleFoodEntities) {
        for(EleFoodEntity eleFoodEntity : eleFoodEntities){
            EleSpecfoodEntity eleSpecfoodEntity = JSONArray.parseArray(eleFoodEntity.getSpecfoods(),EleSpecfoodEntity.class).get(0);
            eleFoodEntity.setIsAnalysis(1);
            eleFoodDao.updateAs(eleFoodEntity);

            eleSpecfoodEntity.setCreateDate(new Date());
            eleSpecfoodEntity.setShopId(eleFoodEntity.getShopId());
            eleSpecfoodEntity.setEleFoodId(eleFoodEntity.getId());
            eleSpecfoodEntity.setVersion(eleFoodEntity.getVersion());
            eleSpecfoodDao.save(eleSpecfoodEntity);

        }
    }

    @Override
    public void analysisByActivitie(List<EleShopEntity> eleShopEntities) {
        for(EleShopEntity eleShopEntity : eleShopEntities){
            List<EleShopActivitieEntity> eleShopActivitieEntitys = JSONArray.parseArray(eleShopEntity.getActivities(),EleShopActivitieEntity.class);
            for(EleShopActivitieEntity eleShopActivitieEntity : eleShopActivitieEntitys){
                eleShopActivitieEntity.setShopId(eleShopEntity.getShopId());
                eleShopActivitieEntity.setVersion(eleShopEntity.getVersion());
                eleShopActivitieEntity.setCreateDate(new Date());
                eleShopActivitieDao.save(eleShopActivitieEntity);
            }

            eleShopEntity.setIsAnalysis(1);
            eleShopDao.updateAs(eleShopEntity);
        }
    }

    @Override
    public void analysisByMenu(List<EleMenuJsonEntity> eleMenuJsonEntitys) {
        for(EleMenuJsonEntity eleMenuJsonEntity : eleMenuJsonEntitys){
            EleMenuEntity eleMenuEntity = JSONObject.parseObject(eleMenuJsonEntity.getJson(),EleMenuEntity.class);
            eleMenuEntity.setCreateDate(new Date());
            eleMenuEntity.setIsAnalysis(0);
            eleMenuEntity.setShopId(eleMenuJsonEntity.getShopId());
            eleMenuEntity.setVersion(eleMenuJsonEntity.getVersion());
            eleMenuEntity.setAnalysisTime(eleMenuJsonEntity.getCreateDate());
            eleMenuDao.saveAs(eleMenuEntity);
            eleMenuJsonEntity.setIsAnalysis(1);
            eleMenuJsonDao.updateAs(eleMenuJsonEntity);
        }
    }
    @Override
    public ResponseVo analysis(String type){
        ResponseVo responseVo = new ResponseVo();
        responseVo.setStatus("1");
        List<?> eleEntity = null;

        if(type.equalsIgnoreCase("shop")){
            eleEntity = eleShopJsonDao.getNoAnalysis(1000);
        }else if(type.equalsIgnoreCase("menu")){
            eleEntity = eleMenuJsonDao.getNoAnalysis(1000);
        }else if(type.equalsIgnoreCase("food")){
            eleEntity = eleMenuDao.getNoAnalysis(1000);
        }else if(type.equalsIgnoreCase("specfood")){
            eleEntity = eleFoodDao.getNoAnalysis(1000);
        }else if(type.equalsIgnoreCase("activitie")){
            eleEntity = eleShopDao.getNoAnalysis(1000);
        }else{
            responseVo.setDetail("解析类型错误");
            return responseVo;
        }

        int analysisNum = 0;
        List<FutureTask<String>> count = new ArrayList<>();
        while(null != eleEntity && eleEntity.size()>0) {
            long preLog = DateFormat.getCurrentTimeMillisByLong();
            int menuSize = eleEntity.size();
            int menuStart = 0;
            int menuEnd;
            int everyCount = 50;
            while (menuStart < menuSize) {
                if (menuStart + everyCount < menuSize) {
                    menuEnd = menuStart + everyCount;
                } else {
                    menuEnd = menuSize;
                }
                FutureTask<String> futureTask = new FutureTask<>(new ThreadPoolTaskByAnalysis(eleEntity.subList(menuStart, menuEnd), this));
                threadPoolTaskExecutor.execute(futureTask);
                count.add(futureTask);
                menuStart+=everyCount;
            }
            while (count.size() > 0) {
                try {
                    String res = count.get(0).get(1000, TimeUnit.MILLISECONDS);
                    if (res.equalsIgnoreCase("Sucess")) {
                        count.remove(0);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (TimeoutException e) {

                }
            }

            if(type.equalsIgnoreCase("shop")){
                eleEntity = eleShopJsonDao.getNoAnalysis(1000);
            }else if(type.equalsIgnoreCase("menu")){
                eleEntity = eleMenuJsonDao.getNoAnalysis(1000);
            }else if(type.equalsIgnoreCase("food")){
                eleEntity = eleMenuDao.getNoAnalysis(1000);
            }else if(type.equalsIgnoreCase("specfood")){
                eleEntity = eleFoodDao.getNoAnalysis(1000);
            }else if(type.equalsIgnoreCase("activitie")){
                eleEntity = eleShopDao.getNoAnalysis(1000);
            }

            analysisNum+=menuSize;
            long endLog = DateFormat.getCurrentTimeMillisByLong();

            System.out.println("类型:[" + type + "]  已解析1000条数据,用时:" + (endLog-preLog));
        }
        responseVo.setDetail("所有数据已解析完毕,本次解析:" + analysisNum + "条.");
        return responseVo;
    }

    class ThreadPoolTaskByAnalysis implements Callable<String>, Serializable {

        private static final long serialVersionUID = 0;

        private List<?> eleEntities;

        ElePullService elePullService;

        public ThreadPoolTaskByAnalysis(List<?> tasks, ElePullService elePullService) {
            this.eleEntities = tasks;
            this.elePullService = elePullService;
        }

        @Override
        public synchronized String call(){
            if(eleEntities.get(0) instanceof EleShopJsonEntity) {
                elePullService.analysisByShop((List<EleShopJsonEntity>) eleEntities);
            }else if(eleEntities.get(0) instanceof EleMenuJsonEntity){
                elePullService.analysisByMenu((List<EleMenuJsonEntity>) eleEntities);
            }else if(eleEntities.get(0) instanceof EleMenuEntity){
                elePullService.analysisByFood((List<EleMenuEntity>) eleEntities);
            }else if(eleEntities.get(0) instanceof EleFoodEntity){
                elePullService.analysisBySpecFood((List<EleFoodEntity>) eleEntities);
            }else if(eleEntities.get(0) instanceof EleShopEntity){
                elePullService.analysisByActivitie((List<EleShopEntity>) eleEntities);
            }
            return "Sucess";
        }
    }


//    class ThreadPoolTaskByMenu implements Callable<String>, Serializable {
//
//        private static final long serialVersionUID = 0;
//
//        private List<EleMenuEntity> eleMenuEntitys;
//
//        ElePullService elePullService;
//
//        public ThreadPoolTaskByMenu(List<EleMenuEntity> tasks, ElePullService elePullService) {
//            this.eleMenuEntitys = tasks;
//            this.elePullService = elePullService;
//        }
//
//        @Override
//        public synchronized String call(){
//            elePullService.analysisByFood(eleMenuEntitys);
//            return "Sucess";
//        }
//    }


//    class ThreadPoolTaskByShop implements Callable<String>, Serializable {
//
//        private static final long serialVersionUID = 0;
//
//        private List<EleShopJsonEntity> eleEntities;
//
//        ElePullService elePullService;
//
//        public ThreadPoolTaskByShop(List<EleShopJsonEntity> tasks, ElePullService elePullService) {
//            this.eleEntities = tasks;
//            this.elePullService = elePullService;
//        }
//
//        @Override
//        public synchronized String call(){
//            elePullService.analysisByShop(eleEntities);
//            return "Sucess";
//        }
//    }
//    @Override
//    public ResponseVo analysisFood() {
//        ResponseVo responseVo = new ResponseVo();
//        responseVo.setStatus("1");
//        int analysisNum = 0;
//        List<FutureTask<String>> count = new ArrayList<>();
//        List<EleMenuEntity> eleMenuEntitys = eleMenuDao.getNoAnalysis(1000);
//
//        while(null != eleMenuEntitys && eleMenuEntitys.size()>0) {
//            long preLog = DateFormat.getCurrentTimeMillisByLong();
//            int menuSize = eleMenuEntitys.size();
//            int menuStart = 0;
//            int menuEnd;
//            int everyCount = 50;
//            while (menuStart < menuSize) {
//                if (menuStart + everyCount < menuSize) {
//                    menuEnd = menuStart + everyCount;
//                } else {
//                    menuEnd = menuSize;
//                }
//                FutureTask<String> futureTask = new FutureTask<>(new ThreadPoolTaskByMenu(eleMenuEntitys.subList(menuStart, menuEnd), this));
//                threadPoolTaskExecutor.execute(futureTask);
//                count.add(futureTask);
//                menuStart+=everyCount;
//            }
//            while (count.size() > 0) {
//                try {
//                    String res = count.get(0).get(1000, TimeUnit.MILLISECONDS);
//                    if (res.equalsIgnoreCase("Sucess")) {
//                        count.remove(0);
//                    }
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                } catch (ExecutionException e) {
//                    e.printStackTrace();
//                } catch (TimeoutException e) {
//
//                }
//            }
//            eleMenuEntitys = eleMenuDao.getNoAnalysis(1000);
//            analysisNum+=menuSize;
//            long endLog = DateFormat.getCurrentTimeMillisByLong();
//
//            System.out.println("已解析1000条数据,用时:" + (endLog-preLog));
//        }
//        responseVo.setDetail("所有数据已解析完毕,本次解析:" + analysisNum + "条.");
//        return responseVo;
//    }
    //    @Override
//    public ResponseVo analysisShop() {
//        ResponseVo responseVo = new ResponseVo();
//        responseVo.setStatus("1");
//        int analysisNum = 0;
//        //每次拉取20条 循环解析
//        List<EleShopJsonEntity> eleShopJsonEntities = eleShopJsonDao.getNoAnalysis(20);
//        while(null != eleShopJsonEntities && eleShopJsonEntities.size() > 0){
//            for(EleShopJsonEntity eleShopJsonEntity : eleShopJsonEntities){
//                EleShopEntity eleShopEntity = JSONObject.parseObject(eleShopJsonEntity.getJson(),EleShopEntity.class);
//                eleShopEntity.setCreateDate(new Date());
//                eleShopEntity.setIsAnalysis(0);
//                eleShopEntity.setShopId(eleShopJsonEntity.getShopId());
//                eleShopEntity.setVersion(eleShopJsonEntity.getVersion());
//                eleShopDao.saveAs(eleShopEntity);
//                eleShopJsonEntity.setIsAnalysis(1);
//                eleShopJsonDao.updateAs(eleShopJsonEntity);
//                analysisNum++;
//            }
//            eleShopJsonEntities = eleShopJsonDao.getNoAnalysis(20);
//
//        }
//        responseVo.setDetail("所有数据已解析完毕,本次解析:" + analysisNum + "条.");
//        return responseVo;
//    }

//    @Override
//    public ResponseVo analysisMenu() {
//        ResponseVo responseVo = new ResponseVo();
//        responseVo.setStatus("1");
//        int analysisNum = 0;
//        //每次拉取20条 循环解析
//        List<EleMenuJsonEntity> eleMenuJsonEntitys = eleMenuJsonDao.getNoAnalysis(20);
//        while(null != eleMenuJsonEntitys && eleMenuJsonEntitys.size() > 0){
//            for(EleMenuJsonEntity eleMenuJsonEntity : eleMenuJsonEntitys){
//                EleMenuEntity eleShopEntity = JSONObject.parseObject(eleMenuJsonEntity.getJson(),EleMenuEntity.class);
//                eleShopEntity.setCreateDate(new Date());
//                eleShopEntity.setIsAnalysis(0);
//                eleShopEntity.setShopId(eleMenuJsonEntity.getShopId());
//                eleShopEntity.setVersion(eleMenuJsonEntity.getVersion());
//                eleMenuDao.saveAs(eleShopEntity);
//                eleMenuJsonEntity.setIsAnalysis(1);
//                eleMenuJsonDao.updateAs(eleMenuJsonEntity);
//                analysisNum++;
//            }
//            eleMenuJsonEntitys = eleMenuJsonDao.getNoAnalysis(20);
//        }
//        responseVo.setDetail("所有数据已解析完毕,本次解析:" + analysisNum + "条.");
//        return responseVo;
//    }
}
