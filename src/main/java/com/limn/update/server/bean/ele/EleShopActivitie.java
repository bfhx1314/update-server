package com.limn.update.server.bean.ele;

import javax.persistence.Transient;
import java.io.Serializable;

/**
 * Created by limengnan on 2017/11/16.
 */
public class EleShopActivitie  implements Serializable {
    @Transient
    Object attribute;

    String description;
    String icon_color;
    String icon_name;
    String id;
    String is_exclusive_with_food_activity;
    String name;
    String tips;
    String type;


    public Object getAttribute() {
        return attribute;
    }

    public void setAttribute(Object attribute) {
        this.attribute = "";
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon_color() {
        return icon_color;
    }

    public void setIcon_color(String icon_color) {
        this.icon_color = icon_color;
    }

    public String getIcon_name() {
        return icon_name;
    }

    public void setIcon_name(String icon_name) {
        this.icon_name = icon_name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIs_exclusive_with_food_activity() {
        return is_exclusive_with_food_activity;
    }

    public void setIs_exclusive_with_food_activity(String is_exclusive_with_food_activity) {
        this.is_exclusive_with_food_activity = is_exclusive_with_food_activity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
