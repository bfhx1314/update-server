package com.limn.update.server.common;

import java.util.List;

public class BaseUtil {

    private static double EARTH_RADIUS = 6378.137;

    private static double rad(double d) {
        return d * Math.PI / 180.0;
    }

    /**
     * 通过经纬度获取距离(单位：米)
     * @param lat1Str
     * @param lng1Str
     * @param lat2Str
     * @param lng2Str
     * @return
     */
    public static double getDistance(String lat1Str, String lng1Str, String lat2Str,
                                     String lng2Str) {


        double lat1 = new Double(lat1Str);
        double lng1 = new Double(lng1Str);
        double lat2 = new Double(lat2Str);
        double lng2 = new Double(lng2Str);

        double radLat1 = rad(lat1);
        double radLat2 = rad(lat2);
        double a = radLat1 - radLat2;
        double b = rad(lng1) - rad(lng2);
        double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2)
                + Math.cos(radLat1) * Math.cos(radLat2)
                * Math.pow(Math.sin(b / 2), 2)));
        s = s * EARTH_RADIUS;
        s = Math.round(s * 10000d) / 10000d;
        s = s*1000;
        return s;
    }


    public static double getAvgByList(List<Double> values){

        if(null == values || values.size() == 0){
            return 0;
        }

        Double sum = 0.00;

        for(Double value : values){
            sum = sum + value;
        }

        return sum/values.size();


    }

    public static boolean isEmpty(String string){

        if(string == null || string.isEmpty()) {
            return true;
        }
        return false;
    }




}
