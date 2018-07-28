package com.limn.update.server.entity;

import com.alibaba.fastjson.annotation.JSONField;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by limengnan on 2018/4/23.
 */
@Entity
@Table(name = "ele_food", schema = "ele", catalog = "")
public class EleFoodEntity {
    private int id;
    private Integer shopId;
    private Long menuId;
    private Date analysisTime;
    private int version;
    private Date createDate;
    @JSONField(name = "is_analysis")
    private Integer isAnalysis;
    private Object limitation;
    @JSONField(name = "virtual_food_id")
    private Long virtualFoodId;
    @JSONField(name = "month_sales")
    private Integer monthSales;
    @JSONField(name = "min_purchase")
    private Integer minPurchase;
    @JSONField(name = "satisfy_count")
    private Integer satisfyCount;
    private Object activity;
    @JSONField(name = "restaurant_id")
    private Integer restaurantId;
    @JSONField(name = "server_utc")
    private Integer serverUtc;
    private Integer rating;
    private String description;
    private Object specifications;
    private String tips;
    @JSONField(name = "category_id")
    private Long categoryId;
    @JSONField(name = "display_times")
    private String displayTimes;
    private Object specfoods;
    @JSONField(name = "item_id")
    private String itemId;
    @JSONField(name = "satisfy_rate")
    private Integer satisfyRate;
    private Object attrs;
    @JSONField(name = "rating_count")
    private Integer ratingCount;
    @JSONField(name = "is_essential")
    private String isEssential;
    @JSONField(name = "pinyin_name")
    private String pinyinName;
    @JSONField(name = "image_path")
    private String imagePath;
    private String name;
    private Object attributes;
    @JSONField(name = "is_featured")
    private Integer isFeatured;

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
    @Column(name = "version", nullable = true)
    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @Basic
    @Column(name = "shop_id", nullable = true)
    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    @Basic
    @Column(name = "menu_id", nullable = true)
    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
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
    @Column(name = "is_analysis", nullable = true)
    public Integer getIsAnalysis() {
        return isAnalysis;
    }

    public void setIsAnalysis(Integer isAnalysis) {
        this.isAnalysis = isAnalysis;
    }

    @Basic
    @Column(name = "limitation", nullable = true, length = -1)
    public String getLimitation() {
        return limitation == null ? "" : limitation.toString();
    }

    public void setLimitation(Object limitation) {
        this.limitation = limitation;
    }

    @Basic
    @Column(name = "virtual_food_id", nullable = true)
    public Long getVirtualFoodId() {
        return virtualFoodId;
    }

    public void setVirtualFoodId(Long virtualFoodId) {
        this.virtualFoodId = virtualFoodId;
    }

    @Basic
    @Column(name = "month_sales", nullable = true)
    public Integer getMonthSales() {
        return monthSales;
    }

    public void setMonthSales(Integer monthSales) {
        this.monthSales = monthSales;
    }

    @Basic
    @Column(name = "min_purchase", nullable = true)
    public Integer getMinPurchase() {
        return minPurchase;
    }

    public void setMinPurchase(Integer minPurchase) {
        this.minPurchase = minPurchase;
    }

    @Basic
    @Column(name = "satisfy_count", nullable = true)
    public Integer getSatisfyCount() {
        return satisfyCount;
    }

    public void setSatisfyCount(Integer satisfyCount) {
        this.satisfyCount = satisfyCount;
    }

    @Basic
    @Column(name = "activity", nullable = true, length = -1)
    public String getActivity() {
        return activity == null ? "" : activity.toString();
    }

    public void setActivity(Object activity) {
        this.activity = activity;
    }

    @Basic
    @Column(name = "restaurant_id", nullable = true)
    public Integer getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Integer restaurantId) {
        this.restaurantId = restaurantId;
    }

    @Basic
    @Column(name = "server_utc", nullable = true)
    public Integer getServerUtc() {
        return serverUtc;
    }

    public void setServerUtc(Integer serverUtc) {
        this.serverUtc = serverUtc;
    }

    @Basic
    @Column(name = "rating", nullable = true)
    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    @Basic
    @Column(name = "description", nullable = true, length = 500)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "specifications", nullable = true, length = -1)
    public String getSpecifications() {
        return specifications == null ? "" :  specifications.toString();
    }

    public void setSpecifications(Object specifications) {
        this.specifications = specifications;
    }

    @Basic
    @Column(name = "tips", nullable = true, length = 255)
    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips;
    }

    @Basic
    @Column(name = "category_id", nullable = true)
    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    @Basic
    @Column(name = "display_times", nullable = true, length = -1)
    public String getDisplayTimes() {
        return displayTimes;
    }

    public void setDisplayTimes(String displayTimes) {
        this.displayTimes = displayTimes;
    }

    @Basic
    @Column(name = "specfoods", nullable = true, length = -1)
    public String getSpecfoods() {
        return specfoods == null ? "" : specfoods.toString();
    }

    public void setSpecfoods(Object specfoods) {
        this.specfoods = specfoods;
    }

    @Basic
    @Column(name = "item_id", nullable = true, length = 255)
    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    @Basic
    @Column(name = "satisfy_rate", nullable = true)
    public Integer getSatisfyRate() {
        return satisfyRate;
    }

    public void setSatisfyRate(Integer satisfyRate) {
        this.satisfyRate = satisfyRate;
    }

    @Basic
    @Column(name = "attrs", nullable = true, length = -1)
    public String getAttrs() {
        return attrs == null ? "" : attrs.toString();
    }

    public void setAttrs(Object attrs) {
        this.attrs = attrs;
    }

    @Basic
    @Column(name = "rating_count", nullable = true)
    public Integer getRatingCount() {
        return ratingCount;
    }

    public void setRatingCount(Integer ratingCount) {
        this.ratingCount = ratingCount;
    }

    @Basic
    @Column(name = "is_essential", nullable = true, length = 50)
    public String getIsEssential() {
        return isEssential;
    }

    public void setIsEssential(String isEssential) {
        this.isEssential = isEssential;
    }

    @Basic
    @Column(name = "pinyin_name", nullable = true, length = 500)
    public String getPinyinName() {
        return pinyinName;
    }

    public void setPinyinName(String pinyinName) {
        this.pinyinName = pinyinName;
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
    @Column(name = "name", nullable = true, length = 255)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "attributes", nullable = true, length = -1)
    public String getAttributes() {
        return attributes == null ? "" : attributes.toString();
    }

    public void setAttributes(Object attributes) {
        this.attributes = attributes;
    }

    @Basic
    @Column(name = "is_featured", nullable = true)
    public Integer getIsFeatured() {
        return isFeatured;
    }

    public void setIsFeatured(Integer isFeatured) {
        this.isFeatured = isFeatured;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EleFoodEntity that = (EleFoodEntity) o;

        if (id != that.id) return false;
        if (shopId != null ? !shopId.equals(that.shopId) : that.shopId != null) return false;
        if (menuId != null ? !menuId.equals(that.menuId) : that.menuId != null) return false;
        if (createDate != null ? !createDate.equals(that.createDate) : that.createDate != null) return false;
        if (isAnalysis != null ? !isAnalysis.equals(that.isAnalysis) : that.isAnalysis != null) return false;
        if (limitation != null ? !limitation.equals(that.limitation) : that.limitation != null) return false;
        if (virtualFoodId != null ? !virtualFoodId.equals(that.virtualFoodId) : that.virtualFoodId != null)
            return false;
        if (monthSales != null ? !monthSales.equals(that.monthSales) : that.monthSales != null) return false;
        if (minPurchase != null ? !minPurchase.equals(that.minPurchase) : that.minPurchase != null) return false;
        if (satisfyCount != null ? !satisfyCount.equals(that.satisfyCount) : that.satisfyCount != null) return false;
        if (activity != null ? !activity.equals(that.activity) : that.activity != null) return false;
        if (restaurantId != null ? !restaurantId.equals(that.restaurantId) : that.restaurantId != null) return false;
        if (serverUtc != null ? !serverUtc.equals(that.serverUtc) : that.serverUtc != null) return false;
        if (rating != null ? !rating.equals(that.rating) : that.rating != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (specifications != null ? !specifications.equals(that.specifications) : that.specifications != null)
            return false;
        if (tips != null ? !tips.equals(that.tips) : that.tips != null) return false;
        if (categoryId != null ? !categoryId.equals(that.categoryId) : that.categoryId != null) return false;
        if (displayTimes != null ? !displayTimes.equals(that.displayTimes) : that.displayTimes != null) return false;
        if (specfoods != null ? !specfoods.equals(that.specfoods) : that.specfoods != null) return false;
        if (itemId != null ? !itemId.equals(that.itemId) : that.itemId != null) return false;
        if (satisfyRate != null ? !satisfyRate.equals(that.satisfyRate) : that.satisfyRate != null) return false;
        if (attrs != null ? !attrs.equals(that.attrs) : that.attrs != null) return false;
        if (ratingCount != null ? !ratingCount.equals(that.ratingCount) : that.ratingCount != null) return false;
        if (isEssential != null ? !isEssential.equals(that.isEssential) : that.isEssential != null) return false;
        if (pinyinName != null ? !pinyinName.equals(that.pinyinName) : that.pinyinName != null) return false;
        if (imagePath != null ? !imagePath.equals(that.imagePath) : that.imagePath != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (attributes != null ? !attributes.equals(that.attributes) : that.attributes != null) return false;
        if (isFeatured != null ? !isFeatured.equals(that.isFeatured) : that.isFeatured != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (shopId != null ? shopId.hashCode() : 0);
        result = 31 * result + (menuId != null ? menuId.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (isAnalysis != null ? isAnalysis.hashCode() : 0);
        result = 31 * result + (limitation != null ? limitation.hashCode() : 0);
        result = 31 * result + (virtualFoodId != null ? virtualFoodId.hashCode() : 0);
        result = 31 * result + (monthSales != null ? monthSales.hashCode() : 0);
        result = 31 * result + (minPurchase != null ? minPurchase.hashCode() : 0);
        result = 31 * result + (satisfyCount != null ? satisfyCount.hashCode() : 0);
        result = 31 * result + (activity != null ? activity.hashCode() : 0);
        result = 31 * result + (restaurantId != null ? restaurantId.hashCode() : 0);
        result = 31 * result + (serverUtc != null ? serverUtc.hashCode() : 0);
        result = 31 * result + (rating != null ? rating.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (specifications != null ? specifications.hashCode() : 0);
        result = 31 * result + (tips != null ? tips.hashCode() : 0);
        result = 31 * result + (categoryId != null ? categoryId.hashCode() : 0);
        result = 31 * result + (displayTimes != null ? displayTimes.hashCode() : 0);
        result = 31 * result + (specfoods != null ? specfoods.hashCode() : 0);
        result = 31 * result + (itemId != null ? itemId.hashCode() : 0);
        result = 31 * result + (satisfyRate != null ? satisfyRate.hashCode() : 0);
        result = 31 * result + (attrs != null ? attrs.hashCode() : 0);
        result = 31 * result + (ratingCount != null ? ratingCount.hashCode() : 0);
        result = 31 * result + (isEssential != null ? isEssential.hashCode() : 0);
        result = 31 * result + (pinyinName != null ? pinyinName.hashCode() : 0);
        result = 31 * result + (imagePath != null ? imagePath.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (attributes != null ? attributes.hashCode() : 0);
        result = 31 * result + (isFeatured != null ? isFeatured.hashCode() : 0);
        return result;
    }
}
