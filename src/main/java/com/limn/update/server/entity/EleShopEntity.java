package com.limn.update.server.entity;

import com.alibaba.fastjson.annotation.JSONField;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "ele_shop", schema = "ele", catalog = "")
public class EleShopEntity {
    private int id;
    private int version;
    private Date createDate;
    private Date analysisTime;
    private Date updateTime;
    private String name;
    private String address;
    @JSONField(name = "authentic_id")
    private String authenticId;
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
    private Integer isAnalysis;
    private Integer shopId;

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public void setPiecewiseAgentFee(String piecewiseAgentFee) {
        this.piecewiseAgentFee = piecewiseAgentFee;
    }

    public void setPosters(String posters) {
        this.posters = posters;
    }

    public void setRecommend(String recommend) {
        this.recommend = recommend;
    }

    public void setRecommendReasons(String recommendReasons) {
        this.recommendReasons = recommendReasons;
    }

    public void setSupports(String supports) {
        this.supports = supports;
    }

    public void setSupportTags(String supportTags) {
        this.supportTags = supportTags;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "version", nullable = true, length = 8)
    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @Basic
    @Column(name = "create_date", nullable = true)
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Basic
    @Column(name = "analysis_time", nullable = true)
    public Date getAnalysisTime() {
        return analysisTime;
    }

    public void setAnalysisTime(Date analysisTime) {
        this.analysisTime = analysisTime;
    }

    @Basic
    @Column(name = "update_time", nullable = true)
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 255)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "address", nullable = true, length = 255)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "authentic_id", nullable = true, length = 255)
    public String getAuthenticId() {
        return authenticId;
    }

    public void setAuthenticId(String authenticId) {
        this.authenticId = authenticId;
    }

    @Basic
    @Column(name = "description", nullable = true, length = 255)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "distance", nullable = true, length = 255)
    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    @Basic
    @Column(name = "favored", nullable = true, length = 255)
    public String getFavored() {
        return favored;
    }

    public void setFavored(String favored) {
        this.favored = favored;
    }

    @Basic
    @Column(name = "float_delivery_fee", nullable = true, length = 255)
    public String getFloatDeliveryFee() {
        return floatDeliveryFee;
    }

    public void setFloatDeliveryFee(String floatDeliveryFee) {
        this.floatDeliveryFee = floatDeliveryFee;
    }

    @Basic
    @Column(name = "float_minimum_order_amount", nullable = true, length = 255)
    public String getFloatMinimumOrderAmount() {
        return floatMinimumOrderAmount;
    }

    public void setFloatMinimumOrderAmount(String floatMinimumOrderAmount) {
        this.floatMinimumOrderAmount = floatMinimumOrderAmount;
    }

    @Basic
    @Column(name = "is_new", nullable = true, length = 255)
    public String getIsNew() {
        return isNew;
    }

    public void setIsNew(String isNew) {
        this.isNew = isNew;
    }

    @Basic
    @Column(name = "is_premium", nullable = true, length = 255)
    public String getIsPremium() {
        return isPremium;
    }

    public void setIsPremium(String isPremium) {
        this.isPremium = isPremium;
    }

    @Basic
    @Column(name = "is_stock_empty", nullable = true, length = 255)
    public String getIsStockEmpty() {
        return isStockEmpty;
    }

    public void setIsStockEmpty(String isStockEmpty) {
        this.isStockEmpty = isStockEmpty;
    }

    @Basic
    @Column(name = "is_valid", nullable = true, length = 255)
    public String getIsValid() {
        return isValid;
    }

    public void setIsValid(String isValid) {
        this.isValid = isValid;
    }

    @Basic
    @Column(name = "latitude", nullable = true, length = 255)
    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    @Basic
    @Column(name = "list_quality_icon", nullable = true, length = 255)
    public String getListQualityIcon() {
        return listQualityIcon;
    }

    public void setListQualityIcon(String listQualityIcon) {
        this.listQualityIcon = listQualityIcon;
    }

    @Basic
    @Column(name = "longitude", nullable = true, length = 255)
    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    @Basic
    @Column(name = "max_applied_quantity_per_order", nullable = true, length = 255)
    public String getMaxAppliedQuantityPerOrder() {
        return maxAppliedQuantityPerOrder;
    }

    public void setMaxAppliedQuantityPerOrder(String maxAppliedQuantityPerOrder) {
        this.maxAppliedQuantityPerOrder = maxAppliedQuantityPerOrder;
    }

    @Basic
    @Column(name = "next_business_time", nullable = true, length = 255)
    public String getNextBusinessTime() {
        return nextBusinessTime;
    }

    public void setNextBusinessTime(String nextBusinessTime) {
        this.nextBusinessTime = nextBusinessTime;
    }

    @Basic
    @Column(name = "only_use_poi", nullable = true, length = 255)
    public String getOnlyUsePoi() {
        return onlyUsePoi;
    }

    public void setOnlyUsePoi(String onlyUsePoi) {
        this.onlyUsePoi = onlyUsePoi;
    }

    @Basic
    @Column(name = "order_lead_time", nullable = true, length = 255)
    public String getOrderLeadTime() {
        return orderLeadTime;
    }

    public void setOrderLeadTime(String orderLeadTime) {
        this.orderLeadTime = orderLeadTime;
    }

    @Basic
    @Column(name = "phone", nullable = true, length = 255)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "rating", nullable = true, length = 255)
    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    @Basic
    @Column(name = "rating_count", nullable = true, length = 255)
    public String getRatingCount() {
        return ratingCount;
    }

    public void setRatingCount(String ratingCount) {
        this.ratingCount = ratingCount;
    }

    @Basic
    @Column(name = "recent_order_num", nullable = true, length = 255)
    public String getRecentOrderNum() {
        return recentOrderNum;
    }

    public void setRecentOrderNum(String recentOrderNum) {
        this.recentOrderNum = recentOrderNum;
    }

    @Basic
    @Column(name = "status", nullable = true, length = 255)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "type", nullable = true, length = 255)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "image_path", nullable = true, length = 255)
    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    @Basic
    @Column(name = "promotion_info", nullable = true, length = 255)
    public String getPromotionInfo() {
        return promotionInfo;
    }

    public void setPromotionInfo(String promotionInfo) {
        this.promotionInfo = promotionInfo;
    }

    @Basic
    @Column(name = "regular_customer_count", nullable = true, length = 255)
    public String getRegularCustomerCount() {
        return regularCustomerCount;
    }

    public void setRegularCustomerCount(String regularCustomerCount) {
        this.regularCustomerCount = regularCustomerCount;
    }

    @Basic
    @Column(name = "has_story", nullable = true, length = 255)
    public String getHasStory() {
        return hasStory;
    }

    public void setHasStory(String hasStory) {
        this.hasStory = hasStory;
    }

    @Basic
    @Column(name = "activities", nullable = true, length = -1)
    public String getActivities() {
        return activities.toString();
    }

    public void setActivities(String activities) {
        this.activities = activities;
    }

    @Basic
    @Column(name = "piecewise_agent_fee", nullable = true, length = -1)
    public String getPiecewiseAgentFee() {
        return piecewiseAgentFee.toString();
    }

    public void setPiecewiseAgentFee(Object piecewiseAgentFee) {
        this.piecewiseAgentFee = piecewiseAgentFee;
    }

    @Basic
    @Column(name = "posters", nullable = true, length = -1)
    public String getPosters() {
        return posters.toString();
    }

    public void setPosters(Object posters) {
        this.posters = posters;
    }

    @Basic
    @Column(name = "recommend", nullable = true, length = -1)
    public String getRecommend() {
        return recommend.toString();
    }

    public void setRecommend(Object recommend) {
        this.recommend = recommend;
    }

    @Basic
    @Column(name = "recommend_reasons", nullable = true, length = -1)
    public String getRecommendReasons() {
        return recommendReasons.toString();
    }

    public void setRecommendReasons(Object recommendReasons) {
        this.recommendReasons = recommendReasons;
    }

    @Basic
    @Column(name = "supports", nullable = true, length = -1)
    public String getSupports() {
        return supports.toString();
    }

    public void setSupports(Object supports) {
        this.supports = supports;
    }

    @Basic
    @Column(name = "support_tags", nullable = true, length = -1)
    public String getSupportTags() {
        return supportTags.toString();
    }

    public void setSupportTags(Object supportTags) {
        this.supportTags = supportTags;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EleShopEntity that = (EleShopEntity) o;
        return id == that.id &&
                Objects.equals(createDate, that.createDate) &&
                Objects.equals(updateTime, that.updateTime) &&
                Objects.equals(name, that.name) &&
                Objects.equals(address, that.address) &&
                Objects.equals(authenticId, that.authenticId) &&
                Objects.equals(description, that.description) &&
                Objects.equals(distance, that.distance) &&
                Objects.equals(favored, that.favored) &&
                Objects.equals(floatDeliveryFee, that.floatDeliveryFee) &&
                Objects.equals(floatMinimumOrderAmount, that.floatMinimumOrderAmount) &&
                Objects.equals(isNew, that.isNew) &&
                Objects.equals(isPremium, that.isPremium) &&
                Objects.equals(isStockEmpty, that.isStockEmpty) &&
                Objects.equals(isValid, that.isValid) &&
                Objects.equals(latitude, that.latitude) &&
                Objects.equals(listQualityIcon, that.listQualityIcon) &&
                Objects.equals(longitude, that.longitude) &&
                Objects.equals(maxAppliedQuantityPerOrder, that.maxAppliedQuantityPerOrder) &&
                Objects.equals(nextBusinessTime, that.nextBusinessTime) &&
                Objects.equals(onlyUsePoi, that.onlyUsePoi) &&
                Objects.equals(orderLeadTime, that.orderLeadTime) &&
                Objects.equals(phone, that.phone) &&
                Objects.equals(rating, that.rating) &&
                Objects.equals(ratingCount, that.ratingCount) &&
                Objects.equals(recentOrderNum, that.recentOrderNum) &&
                Objects.equals(status, that.status) &&
                Objects.equals(type, that.type) &&
                Objects.equals(imagePath, that.imagePath) &&
                Objects.equals(promotionInfo, that.promotionInfo) &&
                Objects.equals(regularCustomerCount, that.regularCustomerCount) &&
                Objects.equals(hasStory, that.hasStory) &&
                Objects.equals(activities, that.activities) &&
                Objects.equals(piecewiseAgentFee, that.piecewiseAgentFee) &&
                Objects.equals(posters, that.posters) &&
                Objects.equals(recommend, that.recommend) &&
                Objects.equals(recommendReasons, that.recommendReasons) &&
                Objects.equals(supports, that.supports) &&
                Objects.equals(supportTags, that.supportTags);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, createDate, updateTime,  name, address, authenticId, description, distance, favored, floatDeliveryFee, floatMinimumOrderAmount, isNew, isPremium, isStockEmpty, isValid, latitude, listQualityIcon, longitude, maxAppliedQuantityPerOrder, nextBusinessTime, onlyUsePoi, orderLeadTime, phone, rating, ratingCount, recentOrderNum, status, type, imagePath, promotionInfo, regularCustomerCount, hasStory, activities, piecewiseAgentFee, posters, recommend, recommendReasons, supports, supportTags);
    }

    @Basic
    @Column(name = "is_analysis", nullable = true)
    public Integer getIsAnalysis() {
        return isAnalysis;
    }

    public void setIsAnalysis(Integer isAnalysis) {
        this.isAnalysis = isAnalysis;
    }

    @Basic
    @Column(name = "shop_id", nullable = true)
    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }
}
