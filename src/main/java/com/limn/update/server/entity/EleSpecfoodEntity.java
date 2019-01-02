package com.limn.update.server.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "ele_specfood", schema = "ele", catalog = "")
public class EleSpecfoodEntity {
    private int id;
    private Integer eleFoodId;
    private Integer version;
    private String checkoutMode;
    private Long foodId;
    private String isEssential;
    private String itemId;
    private String name;
    private String originalPrice;
    private String packingFee;
    private String partialReduceActivityId;
    private String pinyinName;
    private String price;
    private String promotionStock;
    private String recentPopularity;
    private String recentRating;
    private String restaurantId;
    private String skuId;
    private String soldOut;
    private String specs;
    private String stock;
    private String virtualFoodId;
    private String weight;
    private String shopId;
    private Date createDate;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "ele_food_id", nullable = true)
    public Integer getEleFoodId() {
        return eleFoodId;
    }

    public void setEleFoodId(Integer eleFoodId) {
        this.eleFoodId = eleFoodId;
    }

    @Basic
    @Column(name = "version", nullable = true)
    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    @Basic
    @Column(name = "checkout_mode", nullable = true, length = 255)
    public String getCheckoutMode() {
        return checkoutMode;
    }

    public void setCheckoutMode(String checkoutMode) {
        this.checkoutMode = checkoutMode;
    }

    @Basic
    @Column(name = "food_id", nullable = true)
    public Long getFoodId() {
        return foodId;
    }

    public void setFoodId(Long foodId) {
        this.foodId = foodId;
    }

    @Basic
    @Column(name = "is_essential", nullable = true, length = 255)
    public String getIsEssential() {
        return isEssential;
    }

    public void setIsEssential(String isEssential) {
        this.isEssential = isEssential;
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
    @Column(name = "name", nullable = true, length = 255)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "original_price", nullable = true, length = 255)
    public String getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(String originalPrice) {
        this.originalPrice = originalPrice;
    }

    @Basic
    @Column(name = "packing_fee", nullable = true, length = 255)
    public String getPackingFee() {
        return packingFee;
    }

    public void setPackingFee(String packingFee) {
        this.packingFee = packingFee;
    }

    @Basic
    @Column(name = "partial_reduce_activity_id", nullable = true, length = 255)
    public String getPartialReduceActivityId() {
        return partialReduceActivityId;
    }

    public void setPartialReduceActivityId(String partialReduceActivityId) {
        this.partialReduceActivityId = partialReduceActivityId;
    }

    @Basic
    @Column(name = "pinyin_name", nullable = true, length = 255)
    public String getPinyinName() {
        return pinyinName;
    }

    public void setPinyinName(String pinyinName) {
        this.pinyinName = pinyinName;
    }

    @Basic
    @Column(name = "price", nullable = true, length = 255)
    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Basic
    @Column(name = "promotion_stock", nullable = true, length = 255)
    public String getPromotionStock() {
        return promotionStock;
    }

    public void setPromotionStock(String promotionStock) {
        this.promotionStock = promotionStock;
    }

    @Basic
    @Column(name = "recent_popularity", nullable = true, length = 255)
    public String getRecentPopularity() {
        return recentPopularity;
    }

    public void setRecentPopularity(String recentPopularity) {
        this.recentPopularity = recentPopularity;
    }

    @Basic
    @Column(name = "recent_rating", nullable = true, length = 255)
    public String getRecentRating() {
        return recentRating;
    }

    public void setRecentRating(String recentRating) {
        this.recentRating = recentRating;
    }

    @Basic
    @Column(name = "restaurant_id", nullable = true, length = 255)
    public String getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(String restaurantId) {
        this.restaurantId = restaurantId;
    }

    @Basic
    @Column(name = "sku_id", nullable = true, length = 255)
    public String getSkuId() {
        return skuId;
    }

    public void setSkuId(String skuId) {
        this.skuId = skuId;
    }

    @Basic
    @Column(name = "sold_out", nullable = true, length = 255)
    public String getSoldOut() {
        return soldOut;
    }

    public void setSoldOut(String soldOut) {
        this.soldOut = soldOut;
    }

    @Basic
    @Column(name = "specs", nullable = true, length = 255)
    public String getSpecs() {
        return specs;
    }

    public void setSpecs(String specs) {
        this.specs = specs;
    }

    @Basic
    @Column(name = "stock", nullable = true, length = 255)
    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    @Basic
    @Column(name = "virtual_food_id", nullable = true, length = 255)
    public String getVirtualFoodId() {
        return virtualFoodId;
    }

    public void setVirtualFoodId(String virtualFoodId) {
        this.virtualFoodId = virtualFoodId;
    }

    @Basic
    @Column(name = "weight", nullable = true, length = 255)
    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    @Basic
    @Column(name = "shop_id", nullable = true)
    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    @Basic
    @Column(name = "create_date", nullable = true)
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EleSpecfoodEntity that = (EleSpecfoodEntity) o;
        return id == that.id &&
                Objects.equals(eleFoodId, that.eleFoodId) &&
                Objects.equals(version, that.version) &&
                Objects.equals(checkoutMode, that.checkoutMode) &&
                Objects.equals(foodId, that.foodId) &&
                Objects.equals(isEssential, that.isEssential) &&
                Objects.equals(itemId, that.itemId) &&
                Objects.equals(name, that.name) &&
                Objects.equals(originalPrice, that.originalPrice) &&
                Objects.equals(packingFee, that.packingFee) &&
                Objects.equals(partialReduceActivityId, that.partialReduceActivityId) &&
                Objects.equals(pinyinName, that.pinyinName) &&
                Objects.equals(price, that.price) &&
                Objects.equals(promotionStock, that.promotionStock) &&
                Objects.equals(recentPopularity, that.recentPopularity) &&
                Objects.equals(recentRating, that.recentRating) &&
                Objects.equals(restaurantId, that.restaurantId) &&
                Objects.equals(skuId, that.skuId) &&
                Objects.equals(soldOut, that.soldOut) &&
                Objects.equals(specs, that.specs) &&
                Objects.equals(stock, that.stock) &&
                Objects.equals(virtualFoodId, that.virtualFoodId) &&
                Objects.equals(weight, that.weight) &&
                Objects.equals(shopId, that.shopId) &&
                Objects.equals(createDate, that.createDate);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, eleFoodId, version, checkoutMode, foodId, isEssential, itemId, name, originalPrice, packingFee, partialReduceActivityId, pinyinName, price, promotionStock, recentPopularity, recentRating, restaurantId, skuId, soldOut, specs, stock, virtualFoodId, weight, shopId, createDate);
    }
}
