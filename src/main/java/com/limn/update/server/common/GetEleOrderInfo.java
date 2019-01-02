package com.limn.update.server.common;

import com.limn.tool.common.BaseToolParameter;
import com.limn.tool.random.RandomData;
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
    public static List<EleShopJsonBean> getEleShopByCoordinate(String latitude, String longitude, String limit, String offset){

        Map<String, Class> classMap = new HashMap<String, Class>();
        List<EleShopJsonBean> eleshos = new ArrayList<EleShopJsonBean>();
        classMap.put("activities", EleShopActivitie.class);


        String shopList = BaseHttpConnection.doGetSSL("https://www.ele.me/restapi/shopping/restaurants?extras%5B%5D=activities&geohash=wtw6j0r9bz5&latitude=" + latitude+ "&limit=" + limit + "&longitude=" + longitude + "&offset=" + offset + "&terminal=web");

        System.out.println("https://www.ele.me/restapi/shopping/restaurants?extras%5B%5D=activities&geohash=wtw6j0r9bz5&latitude=" + latitude+ "&limit=" + limit + "&longitude=" + longitude + "&offset=" + offset + "&terminal=web");

        if(null == shopList || shopList.isEmpty()){
            BaseToolParameter.getPrintThreadLocal().log("店铺列表无数据返回 latitude : " + latitude + " longitude : " + longitude + " limit : " + limit + " offset : " + offset ,2);
            return eleshos;
        }


        JSONArray shops = JSONArray.fromObject(shopList);

        for(int i = 0 ; i < shops.size() ; i++){
            JSONObject json = (JSONObject)shops.get(i);
            EleShopJsonBean shop = new EleShopJsonBean();
            shop.setJson(json.toString());
            shop.setShopId(json.getString("id"));
            shop.setLatitude(json.getString("latitude"));
            shop.setLongitude(json.getString("longitude"));
            shop.setShopName(json.getString("name"));
            eleshos.add(shop);
        }
        return  eleshos;

    }



    public static List<EleMenuJsonBean> getEleMenuById(String restaurant_id){
        List<EleMenuJsonBean> eleMenus = new ArrayList<EleMenuJsonBean>();

        String menusList = BaseUtil.filterEmoji(BaseHttpConnection.doGetSSL("https://www.ele.me/restapi/shopping/v2/menu?restaurant_id=" + restaurant_id));

        if(null == menusList || menusList.isEmpty()){
            BaseToolParameter.getPrintThreadLocal().log("菜单列表无数据返回 restaurant_id : " + restaurant_id,2);
            return eleMenus;
        }


//        menusList = menusList.replace("{}","\"\"");
//        Print.log("menusList : " + menusList,1);
        JSONArray menus = JSONArray.fromObject(menusList);
//        Print.log("menus : " + menus.toString(),1);


        for(int i = 0 ; i < menus.size() ; i++){
            JSONObject json = (JSONObject)menus.get(i);
            EleMenuJsonBean eleMenuBean = new EleMenuJsonBean();
            eleMenuBean.setJson(json.toString());
            eleMenuBean.setShopId(restaurant_id);
            eleMenuBean.setMenuId(json.getInt("id"));
            eleMenus.add(eleMenuBean);
        }

        return  eleMenus;

    }


    public static void main(String[] args) {
        String a= "121.111";
        System.out.println();
        int b = 6-a.length() + a.lastIndexOf(".") + 1;
        if(b>0){
            a = a + RandomData.getInt(b);
        }
        for(int i = 0;i<100;i++){
            System.out.println(RandomData.getInt(b));
        }
        System.out.println(a);
    }
}

