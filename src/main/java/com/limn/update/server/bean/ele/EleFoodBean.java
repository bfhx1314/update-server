package com.limn.update.server.bean.ele;

import java.io.Serializable;
import java.util.List;

/**
 * Created by limengnan on 2017/11/10.
 */
public class EleFoodBean implements Serializable {
    String rating;
    String is_featured;
    String virtual_food_id;
    String cold_box;
    String restaurant_id;
    String pinyin_name;
    List<String> display_times;
    List<Attr> attrs;
    Object description;

    String month_sales;
    String rating_count;
    String tips;
    String image_path;
    List<String> specifications;
    String server_utc;
    String is_essential;
    List<String> attributes;
    String item_id;
    String min_purchase;

    String limitation;
    String name;
    String satisfy_count;
    Activity activity;
    String satisfy_rate;
    List<EleMenuSpecfood> specfoods;
    String category_id;

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getIs_featured() {
        return is_featured;
    }

    public void setIs_featured(String is_featured) {
        this.is_featured = is_featured;
    }

    public String getVirtual_food_id() {
        return virtual_food_id;
    }

    public void setVirtual_food_id(String virtual_food_id) {
        this.virtual_food_id = virtual_food_id;
    }

    public String getCold_box() {
        return cold_box;
    }

    public void setCold_box(String cold_box) {
        this.cold_box = cold_box;
    }

    public String getRestaurant_id() {
        return restaurant_id;
    }

    public void setRestaurant_id(String restaurant_id) {
        this.restaurant_id = restaurant_id;
    }

    public String getPinyin_name() {
        return pinyin_name;
    }

    public void setPinyin_name(String pinyin_name) {
        this.pinyin_name = pinyin_name;
    }

    public List<String> getDisplay_times() {
        return display_times;
    }

    public void setDisplay_times(List<String> display_times) {
        this.display_times = display_times;
    }


    public List<Attr> getAttrs() {
        return attrs;
    }

    public void setAttrs(List<Attr> attrs) {
        this.attrs = attrs;
    }

    public Object getDescription() {
        return "无法解析";
    }

    public void setDescription(Object description) {
        this.description = description;
    }

    public String getMonth_sales() {
        return month_sales;
    }

    public void setMonth_sales(String month_sales) {
        this.month_sales = month_sales;
    }

    public String getRating_count() {
        return rating_count;
    }

    public void setRating_count(String rating_count) {
        this.rating_count = rating_count;
    }

    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips;
    }

    public String getImage_path() {
        return image_path;
    }

    public void setImage_path(String image_path) {
        this.image_path = image_path;
    }

    public List<String> getSpecifications() {
        return specifications;
    }

    public void setSpecifications(List<String> specifications) {
        this.specifications = specifications;
    }

    public String getServer_utc() {
        return server_utc;
    }

    public void setServer_utc(String server_utc) {
        this.server_utc = server_utc;
    }


    public List<String> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<String> attributes) {
        this.attributes = attributes;
    }

    public String getItem_id() {
        return item_id;
    }

    public void setItem_id(String item_id) {
        this.item_id = item_id;
    }

    public String getMin_purchase() {
        return min_purchase;
    }

    public void setMin_purchase(String min_purchase) {
        this.min_purchase = min_purchase;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSatisfy_count() {
        return satisfy_count;
    }

    public void setSatisfy_count(String satisfy_count) {
        this.satisfy_count = satisfy_count;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public String getSatisfy_rate() {
        return satisfy_rate;
    }

    public void setSatisfy_rate(String satisfy_rate) {
        this.satisfy_rate = satisfy_rate;
    }

    public List<EleMenuSpecfood> getSpecfoods() {
        return specfoods;
    }

    public void setSpecfoods(List<EleMenuSpecfood> specfoods) {
        this.specfoods = specfoods;
    }

    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    public String getIs_essential() {
        return is_essential;
    }

    public void setIs_essential(String is_essential) {
        this.is_essential = is_essential;
    }

    public String getLimitation() {
        return limitation;
    }

    public void setLimitation(String limitation) {
        this.limitation = limitation;
    }
}


