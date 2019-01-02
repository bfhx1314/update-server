package com.limn.update.server.bean.ele;

/**
 * Created by limengnan on 2018/4/20.
 */
public class EleMenuJsonBean {
    String shopId;
    String json;
    int menuId;

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }
}
