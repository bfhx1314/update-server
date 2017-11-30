package com.limn.update.server.common;

import com.limn.tool.common.Print;
import com.limn.update.server.bean.ele.*;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by limengnan on 2017/11/10.
 */
public class GetEleOrderInfo {


    /**
     * 获取坐标附近的门店
     * @param latitude 经度
     * @param longitude 纬度
     * @param limit 个数
     * @param offset 第几个开始
     * @return
     */
    public static List<EleShopBean> getEleShopByCoordinate(String latitude, String longitude, String limit, String offset){

        Map<String, Class> classMap = new HashMap<String, Class>();
        List<EleShopBean> eleshos = new ArrayList<EleShopBean>();
        classMap.put("activities", EleShopActivitie.class);

        String shopList = BaseHttpConnection.doGetSSL("https://www.ele.me/restapi/shopping/restaurants?extras[]=activities&geohash=wtw3s78hjff&latitude=" + latitude+ "&limit=" + limit + "&longitude=" + longitude + "&offset=" + offset + "&terminal=web");

        if(null == shopList || shopList.isEmpty()){
            Print.log("店铺列表无数据返回 latitude : " + latitude + " longitude : " + longitude + " limit : " + limit + " offset : " + offset ,2);
            return eleshos;
        }


        JSONArray shops = JSONArray.fromObject(shopList);

        for(int i = 0 ; i < shops.size() ; i++){
            JSONObject json = (JSONObject)shops.get(i);
            EleShopBean shop = (EleShopBean) JSONObject.toBean(json,EleShopBean.class,classMap);
            shop.setJson(json.toString());
            eleshos.add(shop);
        }
        return  eleshos;

    }



    public static List<EleMenuBean> getEleMenuById(String restaurant_id){
        List<EleMenuBean> eleMenus = new ArrayList<EleMenuBean>();
        Map<String, Class> classMap = new HashMap<String, Class>();
        classMap.put("foods", EleFoodBean.class);
        classMap.put("specfoods", EleMenuSpecfood.class);
        classMap.put("attr", Attr.class);

        String menusList = BaseHttpConnection.doGetSSL("https://www.ele.me/restapi/shopping/v2/menu?restaurant_id=" + restaurant_id);


        if(null == menusList || menusList.isEmpty()){
            Print.log("菜单列表无数据返回 restaurant_id : " + restaurant_id,2);
            return eleMenus;
        }


        menusList = menusList.replace("{}","\"\"");
//        Print.log("menusList : " + menusList,1);
        JSONArray menus = JSONArray.fromObject(menusList);
//        Print.log("menus : " + menus.toString(),1);




        for(int i = 0 ; i < menus.size() ; i++){

            eleMenus.add((EleMenuBean) JSONObject.toBean((JSONObject)menus.get(i),EleMenuBean.class,classMap));
        }

        return  eleMenus;

    }



}

