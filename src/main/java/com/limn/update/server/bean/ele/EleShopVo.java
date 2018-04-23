package com.limn.update.server.bean.ele;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.Date;

public class EleShopVo implements Serializable {

    private Date createDate;
    private Date updateTime;
    private Integer shopId;
    private String name;
    private String address;
    @JSONField(name = "authentic_id")
    private Integer authenticId;
    private String description;
    private String distance;
    private String favored;
    @JSONField(name = "float_delivery_fee")
    private String floatDeliveryFee;
    @JSONField(name = "float_minimum_order_amount")
    private String floatMinimumOrderAmount;
    @JSONField(name = "is_new")
    private String isNew;
    @JSONField(name = "is_premium")
    private String isPremium;
    @JSONField(name = "is_stock_empty")
    private String isStockEmpty;
    @JSONField(name = "is_valid")
    private String isValid;
    private String latitude;
    @JSONField(name = "list_quality_icon")
    private String listQualityIcon;
    private String longitude;
    @JSONField(name = "max_applied_quantity_per_order")
    private String maxAppliedQuantityPerOrder;
    @JSONField(name = "next_business_time")
    private String nextBusinessTime;
    @JSONField(name = "only_use_poi")
    private String onlyUsePoi;
    @JSONField(name = "order_lead_time")
    private String orderLeadTime;
    private String phone;
    private String rating;
    @JSONField(name = "rating_count")
    private String ratingCount;
    @JSONField(name = "recent_order_num")
    private String recentOrderNum;
    private String status;
    private String type;
    @JSONField(name = "image_path")
    private String imagePath;
    @JSONField(name = "float_delivery_fee")
    private String promotionInfo;
    @JSONField(name = "regular_customer_count")
    private String regularCustomerCount;
    @JSONField(name = "has_story")
    private String hasStory;
    private Object activities;
    @JSONField(name = "piecewise_agent_fee")
    private Object piecewiseAgentFee;
    private Object posters;
    private Object recommend;
    @JSONField(name = "recommend_reasons")
    private Object recommendReasons;
    private Object supports;
    @JSONField(name = "support_tags")
    private Object supportTags;

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getAuthenticId() {
        return authenticId;
    }

    public void setAuthenticId(Integer authenticId) {
        this.authenticId = authenticId;
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

    public String getFloatDeliveryFee() {
        return floatDeliveryFee;
    }

    public void setFloatDeliveryFee(String floatDeliveryFee) {
        this.floatDeliveryFee = floatDeliveryFee;
    }

    public String getFloatMinimumOrderAmount() {
        return floatMinimumOrderAmount;
    }

    public void setFloatMinimumOrderAmount(String floatMinimumOrderAmount) {
        this.floatMinimumOrderAmount = floatMinimumOrderAmount;
    }

    public String getIsNew() {
        return isNew;
    }

    public void setIsNew(String isNew) {
        this.isNew = isNew;
    }

    public String getIsPremium() {
        return isPremium;
    }

    public void setIsPremium(String isPremium) {
        this.isPremium = isPremium;
    }

    public String getIsStockEmpty() {
        return isStockEmpty;
    }

    public void setIsStockEmpty(String isStockEmpty) {
        this.isStockEmpty = isStockEmpty;
    }

    public String getIsValid() {
        return isValid;
    }

    public void setIsValid(String isValid) {
        this.isValid = isValid;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getListQualityIcon() {
        return listQualityIcon;
    }

    public void setListQualityIcon(String listQualityIcon) {
        this.listQualityIcon = listQualityIcon;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getMaxAppliedQuantityPerOrder() {
        return maxAppliedQuantityPerOrder;
    }

    public void setMaxAppliedQuantityPerOrder(String maxAppliedQuantityPerOrder) {
        this.maxAppliedQuantityPerOrder = maxAppliedQuantityPerOrder;
    }

    public String getNextBusinessTime() {
        return nextBusinessTime;
    }

    public void setNextBusinessTime(String nextBusinessTime) {
        this.nextBusinessTime = nextBusinessTime;
    }

    public String getOnlyUsePoi() {
        return onlyUsePoi;
    }

    public void setOnlyUsePoi(String onlyUsePoi) {
        this.onlyUsePoi = onlyUsePoi;
    }

    public String getOrderLeadTime() {
        return orderLeadTime;
    }

    public void setOrderLeadTime(String orderLeadTime) {
        this.orderLeadTime = orderLeadTime;
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

    public String getRatingCount() {
        return ratingCount;
    }

    public void setRatingCount(String ratingCount) {
        this.ratingCount = ratingCount;
    }

    public String getRecentOrderNum() {
        return recentOrderNum;
    }

    public void setRecentOrderNum(String recentOrderNum) {
        this.recentOrderNum = recentOrderNum;
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

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getPromotionInfo() {
        return promotionInfo;
    }

    public void setPromotionInfo(String promotionInfo) {
        this.promotionInfo = promotionInfo;
    }

    public String getRegularCustomerCount() {
        return regularCustomerCount;
    }

    public void setRegularCustomerCount(String regularCustomerCount) {
        this.regularCustomerCount = regularCustomerCount;
    }

    public String getHasStory() {
        return hasStory;
    }

    public void setHasStory(String hasStory) {
        this.hasStory = hasStory;
    }

    public Object getActivities() {
        return activities;
    }

    public void setActivities(Object activities) {
        this.activities = activities;
    }

    public Object getPiecewiseAgentFee() {
        return piecewiseAgentFee;
    }

    public void setPiecewiseAgentFee(Object piecewiseAgentFee) {
        this.piecewiseAgentFee = piecewiseAgentFee;
    }

    public Object getPosters() {
        return posters;
    }

    public void setPosters(Object posters) {
        this.posters = posters;
    }

    public Object getRecommend() {
        return recommend;
    }

    public void setRecommend(Object recommend) {
        this.recommend = recommend;
    }

    public Object getRecommendReasons() {
        return recommendReasons;
    }

    public void setRecommendReasons(Object recommendReasons) {
        this.recommendReasons = recommendReasons;
    }

    public Object getSupports() {
        return supports;
    }

    public void setSupports(Object supports) {
        this.supports = supports;
    }

    public Object getSupportTags() {
        return supportTags;
    }

    public void setSupportTags(Object supportTags) {
        this.supportTags = supportTags;
    }
}
