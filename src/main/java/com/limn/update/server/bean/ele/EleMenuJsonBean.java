package com.limn.update.server.bean.ele;

/**
 * Created by limengnan on 2018/4/20.
 */
public class EleMenuJsonBean {
    int shopId;
    String json;
    int menuId;

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }
}
