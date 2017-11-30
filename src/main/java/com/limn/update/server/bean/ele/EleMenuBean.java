package com.limn.update.server.bean.ele;

import com.limn.tool.regexp.RegExp;

import java.util.List;

/**
 * Created by limengnan on 2017/11/10.
 */
public class EleMenuBean {

    String description;
    boolean is_selected;
    String icon_url;
    String name;
    List<EleFoodBean> foods;
    String activity;
    String type;
    String id;
    String is_activity;
    String grey_icon_url;

    public String getGrey_icon_url() {
        return grey_icon_url;
    }

    public void setGrey_icon_url(String grey_icon_url) {
        this.grey_icon_url = grey_icon_url;
    }

    public String getDescription() {

        if(RegExp.findCharacters(description,"注意（口味，另选必点哦）")){
            System.out.println(description);
        }


        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean is_selected() {
        return is_selected;
    }

    public void setIs_selected(boolean is_selected) {
        this.is_selected = is_selected;
    }

    public String getIcon_url() {
        return icon_url;
    }

    public void setIcon_url(String icon_url) {
        this.icon_url = icon_url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<EleFoodBean> getFoods() {
        return foods;
    }

    public void setFoods(List<EleFoodBean> foods) {
        this.foods = foods;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIs_activity() {
        return is_activity;
    }

    public void setIs_activity(String is_activity) {
        this.is_activity = is_activity;
    }
}
