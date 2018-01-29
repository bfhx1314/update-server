package com.limn.update.server.enumeration;

/**
 * Created by limengnan on 2018/1/26.
 */
public enum WXCMEnum {

    LUA("lua脚本","test.lua"),
    PHP("php脚本","daemon_test.php"),
    UPDATEPATH("更新路径","wxcm/script");

    private String name;
    private String code;

    private WXCMEnum(String name , String code){
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }



}
