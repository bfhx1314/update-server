package com.limn.update.server.entity;

import javax.persistence.*;

/**
 * Created by limengnan on 2017/11/17.
 */
@Entity
@Table(name = "ele_menu_specfood", schema = "ele", catalog = "")
public class EleMenuSpecfoodEntity {
    private String checkout_mode;
    private String food_id;
    private String is_essential;
    private String item_id;
    private String name;
    private String original_price;
    private String packing_fee;
    private String partial_reduce_activity_id;
    private String pinyin_name;
    private String price;
    private String promotion_stock;
    private String recent_popularity;
    private String recent_rating;
    private String restaurant_id;
    private String sku_id;
    private String sold_out;
    private String specs;
    private String stock;
    private String virtualFoodId;
    private String weight;
    private String foodId;
    private int specfood_id;

    @Basic
    @Column(name = "checkout_mode", nullable = true, length = 255)
    public String getCheckout_mode() {
        return checkout_mode;
    }

    public void setCheckout_mode(String checkout_mode) {
        this.checkout_mode = checkout_mode;
    }

    @Basic
    @Column(name = "food_id", nullable = true, length = 255)
    public String getFood_id() {
        return food_id;
    }

    public void setFood_id(String food_id) {
        this.food_id = food_id;
    }

    @Basic
    @Column(name = "is_essential", nullable = true, length = 255)
    public String getIs_essential() {
        return is_essential;
    }

    public void setIs_essential(String is_essential) {
        this.is_essential = is_essential;
    }

    @Basic
    @Column(name = "item_id", nullable = true, length = 255)
    public String getItem_id() {
        return item_id;
    }

    public void setItem_id(String item_id) {
        this.item_id = item_id;
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
    public String getOriginal_price() {
        return original_price;
    }

    public void setOriginal_price(String original_price) {
        this.original_price = original_price;
    }

    @Basic
    @Column(name = "packing_fee", nullable = true, length = 255)
    public String getPacking_fee() {
        return packing_fee;
    }

    public void setPacking_fee(String packing_fee) {
        this.packing_fee = packing_fee;
    }

    @Basic
    @Column(name = "partial_reduce_activity_id", nullable = true, length = 255)
    public String getPartial_reduce_activity_id() {
        return partial_reduce_activity_id;
    }

    public void setPartial_reduce_activity_id(String partial_reduce_activity_id) {
        this.partial_reduce_activity_id = partial_reduce_activity_id;
    }

    @Basic
    @Column(name = "pinyin_name", nullable = true, length = 255)
    public String getPinyin_name() {
        return pinyin_name;
    }

    public void setPinyin_name(String pinyin_name) {
        this.pinyin_name = pinyin_name;
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
    public String getPromotion_stock() {
        return promotion_stock;
    }

    public void setPromotion_stock(String promotion_stock) {
        this.promotion_stock = promotion_stock;
    }

    @Basic
    @Column(name = "recent_popularity", nullable = true, length = 255)
    public String getRecent_popularity() {
        return recent_popularity;
    }

    public void setRecent_popularity(String recent_popularity) {
        this.recent_popularity = recent_popularity;
    }

    @Basic
    @Column(name = "recent_rating", nullable = true, length = 255)
    public String getRecent_rating() {
        return recent_rating;
    }

    public void setRecent_rating(String recent_rating) {
        this.recent_rating = recent_rating;
    }

    @Basic
    @Column(name = "restaurant_id", nullable = true, length = 255)
    public String getRestaurant_id() {
        return restaurant_id;
    }

    public void setRestaurant_id(String restaurant_id) {
        this.restaurant_id = restaurant_id;
    }

    @Basic
    @Column(name = "sku_id", nullable = true, length = 255)
    public String getSku_id() {
        return sku_id;
    }

    public void setSku_id(String sku_id) {
        this.sku_id = sku_id;
    }

    @Basic
    @Column(name = "sold_out", nullable = true, length = 255)
    public String getSold_out() {
        return sold_out;
    }

    public void setSold_out(String sold_out) {
        this.sold_out = sold_out;
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
    @Column(name = "foodId", nullable = true, length = 255)
    public String getFoodId() {
        return foodId;
    }

    public void setFoodId(String foodId) {
        this.foodId = foodId;
    }

    @Id
    @Column(name = "specfood_id", nullable = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public int getSpecfood_id() {
        return specfood_id;
    }

    public void setSpecfood_id(int specfood_id) {
        this.specfood_id = specfood_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EleMenuSpecfoodEntity that = (EleMenuSpecfoodEntity) o;

        if (specfood_id != that.specfood_id) return false;
        if (checkout_mode != null ? !checkout_mode.equals(that.checkout_mode) : that.checkout_mode != null)
            return false;
        if (food_id != null ? !food_id.equals(that.food_id) : that.food_id != null) return false;
        if (is_essential != null ? !is_essential.equals(that.is_essential) : that.is_essential != null) return false;
        if (item_id != null ? !item_id.equals(that.item_id) : that.item_id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (original_price != null ? !original_price.equals(that.original_price) : that.original_price != null)
            return false;
        if (packing_fee != null ? !packing_fee.equals(that.packing_fee) : that.packing_fee != null) return false;
        if (partial_reduce_activity_id != null ? !partial_reduce_activity_id.equals(that.partial_reduce_activity_id) : that.partial_reduce_activity_id != null)
            return false;
        if (pinyin_name != null ? !pinyin_name.equals(that.pinyin_name) : that.pinyin_name != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (promotion_stock != null ? !promotion_stock.equals(that.promotion_stock) : that.promotion_stock != null)
            return false;
        if (recent_popularity != null ? !recent_popularity.equals(that.recent_popularity) : that.recent_popularity != null)
            return false;
        if (recent_rating != null ? !recent_rating.equals(that.recent_rating) : that.recent_rating != null)
            return false;
        if (restaurant_id != null ? !restaurant_id.equals(that.restaurant_id) : that.restaurant_id != null)
            return false;
        if (sku_id != null ? !sku_id.equals(that.sku_id) : that.sku_id != null) return false;
        if (sold_out != null ? !sold_out.equals(that.sold_out) : that.sold_out != null) return false;
        if (specs != null ? !specs.equals(that.specs) : that.specs != null) return false;
        if (stock != null ? !stock.equals(that.stock) : that.stock != null) return false;
        if (virtualFoodId != null ? !virtualFoodId.equals(that.virtualFoodId) : that.virtualFoodId != null)
            return false;
        if (weight != null ? !weight.equals(that.weight) : that.weight != null) return false;
        if (foodId != null ? !foodId.equals(that.foodId) : that.foodId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = checkout_mode != null ? checkout_mode.hashCode() : 0;
        result = 31 * result + (food_id != null ? food_id.hashCode() : 0);
        result = 31 * result + (is_essential != null ? is_essential.hashCode() : 0);
        result = 31 * result + (item_id != null ? item_id.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (original_price != null ? original_price.hashCode() : 0);
        result = 31 * result + (packing_fee != null ? packing_fee.hashCode() : 0);
        result = 31 * result + (partial_reduce_activity_id != null ? partial_reduce_activity_id.hashCode() : 0);
        result = 31 * result + (pinyin_name != null ? pinyin_name.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (promotion_stock != null ? promotion_stock.hashCode() : 0);
        result = 31 * result + (recent_popularity != null ? recent_popularity.hashCode() : 0);
        result = 31 * result + (recent_rating != null ? recent_rating.hashCode() : 0);
        result = 31 * result + (restaurant_id != null ? restaurant_id.hashCode() : 0);
        result = 31 * result + (sku_id != null ? sku_id.hashCode() : 0);
        result = 31 * result + (sold_out != null ? sold_out.hashCode() : 0);
        result = 31 * result + (specs != null ? specs.hashCode() : 0);
        result = 31 * result + (stock != null ? stock.hashCode() : 0);
        result = 31 * result + (virtualFoodId != null ? virtualFoodId.hashCode() : 0);
        result = 31 * result + (weight != null ? weight.hashCode() : 0);
        result = 31 * result + (foodId != null ? foodId.hashCode() : 0);
        result = 31 * result + specfood_id;
        return result;
    }
}
