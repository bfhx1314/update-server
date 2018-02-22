package com.limn.update.server.bean.ele;

import java.io.Serializable;
import java.util.List;

/**
 * Created by limengnan on 2017/11/7.
 */
public class EleShopBean implements Serializable {
    List<EleShopActivitie> activities;
    String address;
    String authentic_id;
    String description;
    String distance;
    String favored;
    String float_delivery_fee;
    String float_minimum_order_amount;
    String id;
    String is_new;
    String is_premium;
    String is_stock_empty;
    String is_valid;
    String latitude;
    String list_quality_icon;
    String longitude;
    String max_applied_quantity_per_order;
    String name;
    String next_business_time;
    String only_use_poi;
    String order_lead_time;
    String phone;
    String rating;
    String rating_count;
    String recent_order_num;
    String regular_customer_count;
    String status;
    String type;
    String json;
    EleShopRecommend recommend;
    EleShopDeliveryMode delivery_mode;
    List<EleShopFoldingRestaurant> folding_restaurants;
    String image_path;

    List<String> opening_hours;
    EleShopPiecewiseAgentFee piecewise_agent_fee;
    String promotion_info;
    List<EleShopSupport> supports;
    EleShopBidding bidding;
    Object flavors;
    Object recommend_reasons;
    Object support_tags;

    public Object getSupport_tags() {
        return support_tags;
    }

    public void setSupport_tags(Object support_tags) {
        this.support_tags = support_tags;
    }

    public Object getRecommend_reasons() {
        return recommend_reasons;
    }

    public void setRecommend_reasons(Object recommend_reasons) {
        this.recommend_reasons = recommend_reasons;
    }

    public Object getFlavors() {
        return flavors;
    }

    public void setFlavors(Object flavors) {
        this.flavors = flavors;
    }

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }

    public EleShopBidding getBidding() {
        return bidding;
    }

    public void setBidding(EleShopBidding bidding) {
        this.bidding = bidding;
    }

    public List<EleShopFoldingRestaurant> getFolding_restaurants() {
        return folding_restaurants;
    }

    public void setFolding_restaurants(List<EleShopFoldingRestaurant> folding_restaurants) {
        this.folding_restaurants = folding_restaurants;
    }

    public EleShopRecommend getRecommend() {
        return recommend;
    }

    public void setRecommend(EleShopRecommend recommend) {
        this.recommend = recommend;
    }

    public String getImage_path() {
        return image_path;
    }

    public void setImage_path(String image_path) {
        this.image_path = image_path;
    }



    public List<String> getOpening_hours() {
        return opening_hours;
    }

    public void setOpening_hours(List<String> opening_hours) {
        this.opening_hours = opening_hours;
    }

    public EleShopPiecewiseAgentFee getPiecewise_agent_fee() {
        return piecewise_agent_fee;
    }

    public void setPiecewise_agent_fee(EleShopPiecewiseAgentFee piecewise_agent_fee) {
        this.piecewise_agent_fee = piecewise_agent_fee;
    }

    public EleShopDeliveryMode getDelivery_mode() {
        return delivery_mode;
    }

    public void setDelivery_mode(EleShopDeliveryMode delivery_mode) {
        this.delivery_mode = delivery_mode;
    }

    public String getPromotion_info() {
        return promotion_info;
    }

    public void setPromotion_info(String promotion_info) {
        this.promotion_info = promotion_info;
    }

    public List<EleShopSupport> getSupports() {
        return supports;
    }

    public void setSupports(List<EleShopSupport> supports) {
        this.supports = supports;
    }

    public List<EleShopActivitie> getActivities() {
        return activities;
    }

    public void setActivities(List<EleShopActivitie> activities) {
        this.activities = activities;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAuthentic_id() {
        return authentic_id;
    }

    public void setAuthentic_id(String authentic_id) {
        this.authentic_id = authentic_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getFavored() {
        return favored;
    }

    public void setFavored(String favored) {
        this.favored = favored;
    }

    public String getFloat_delivery_fee() {
        return float_delivery_fee;
    }

    public void setFloat_delivery_fee(String float_delivery_fee) {
        this.float_delivery_fee = float_delivery_fee;
    }

    public String getFloat_minimum_order_amount() {
        return float_minimum_order_amount;
    }

    public void setFloat_minimum_order_amount(String float_minimum_order_amount) {
        this.float_minimum_order_amount = float_minimum_order_amount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIs_new() {
        return is_new;
    }

    public void setIs_new(String is_new) {
        this.is_new = is_new;
    }

    public String getIs_premium() {
        return is_premium;
    }

    public void setIs_premium(String is_premium) {
        this.is_premium = is_premium;
    }

    public String getIs_stock_empty() {
        return is_stock_empty;
    }

    public void setIs_stock_empty(String is_stock_empty) {
        this.is_stock_empty = is_stock_empty;
    }

    public String getIs_valid() {
        return is_valid;
    }

    public void setIs_valid(String is_valid) {
        this.is_valid = is_valid;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getList_quality_icon() {
        return list_quality_icon;
    }

    public void setList_quality_icon(String list_quality_icon) {
        this.list_quality_icon = list_quality_icon;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getMax_applied_quantity_per_order() {
        return max_applied_quantity_per_order;
    }

    public void setMax_applied_quantity_per_order(String max_applied_quantity_per_order) {
        this.max_applied_quantity_per_order = max_applied_quantity_per_order;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNext_business_time() {
        return next_business_time;
    }

    public void setNext_business_time(String next_business_time) {
        this.next_business_time = next_business_time;
    }

    public String getOnly_use_poi() {
        return only_use_poi;
    }

    public void setOnly_use_poi(String only_use_poi) {
        this.only_use_poi = only_use_poi;
    }

    public String getOrder_lead_time() {
        return order_lead_time;
    }

    public void setOrder_lead_time(String order_lead_time) {
        this.order_lead_time = order_lead_time;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getRating_count() {
        return rating_count;
    }

    public void setRating_count(String rating_count) {
        this.rating_count = rating_count;
    }

    public String getRecent_order_num() {
        return recent_order_num;
    }

    public void setRecent_order_num(String recent_order_num) {
        this.recent_order_num = recent_order_num;
    }

    public String getRegular_customer_count() {
        return regular_customer_count;
    }

    public void setRegular_customer_count(String regular_customer_count) {
        this.regular_customer_count = regular_customer_count;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}




class Rule{
    String fee;
    String price;

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}

class EleShopSupport {
    String description;
    String icon_color;
    String icon_name;
    int id;
    String name;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


