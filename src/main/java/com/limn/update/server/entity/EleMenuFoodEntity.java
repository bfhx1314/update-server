package com.limn.update.server.entity;

import javax.persistence.*;

/**
 * Created by limengnan on 2017/11/17.
 */
@Entity
@Table(name = "ele_menu_food", schema = "ele", catalog = "")
public class EleMenuFoodEntity {
    private String attribute;
    private String attributes;
    private String attrs;
    private String category_id;
    private String cold_box;
    private String description;
    private String display_times;
    private String image_path;
    private String is_essential;
    private String is_featured;
    private String item_id;
    private String limitation;
    private String min_purchase;
    private String month_sales;
    private String name;
    private String pinyin_name;
    private String rating;
    private String rating_count;
    private String restaurant_id;
    private String satisfy_count;
    private String satisfy_rate;
    private String server_utc;
    private String specifications;
    private String tips;
    private String virtualFoodId;
    private String menu_id;
    private int food_id;

    @Basic
    @Column(name = "attribute", nullable = true, length = 255)
    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    @Basic
    @Column(name = "attributes", nullable = true, length = 255)
    public String getAttributes() {
        return attributes;
    }

    public void setAttributes(String attributes) {
        this.attributes = attributes;
    }

    @Basic
    @Column(name = "attrs", nullable = true, length = 255)
    public String getAttrs() {
        return attrs;
    }

    public void setAttrs(String attrs) {
        this.attrs = attrs;
    }

    @Basic
    @Column(name = "category_id", nullable = true, length = 255)
    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    @Basic
    @Column(name = "cold_box", nullable = true, length = 255)
    public String getCold_box() {
        return cold_box;
    }

    public void setCold_box(String cold_box) {
        this.cold_box = cold_box;
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
    @Column(name = "display_times", nullable = true, length = 255)
    public String getDisplay_times() {
        return display_times;
    }

    public void setDisplay_times(String display_times) {
        this.display_times = display_times;
    }

    @Basic
    @Column(name = "image_path", nullable = true, length = 255)
    public String getImage_path() {
        return image_path;
    }

    public void setImage_path(String image_path) {
        this.image_path = image_path;
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
    @Column(name = "is_featured", nullable = true, length = 255)
    public String getIs_featured() {
        return is_featured;
    }

    public void setIs_featured(String is_featured) {
        this.is_featured = is_featured;
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
    @Column(name = "limitation", nullable = true, length = 255)
    public String getLimitation() {
        return limitation;
    }

    public void setLimitation(String limitation) {
        this.limitation = limitation;
    }

    @Basic
    @Column(name = "min_purchase", nullable = true, length = 255)
    public String getMin_purchase() {
        return min_purchase;
    }

    public void setMin_purchase(String min_purchase) {
        this.min_purchase = min_purchase;
    }

    @Basic
    @Column(name = "month_sales", nullable = true, length = 255)
    public String getMonth_sales() {
        return month_sales;
    }

    public void setMonth_sales(String month_sales) {
        this.month_sales = month_sales;
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
    @Column(name = "pinyin_name", nullable = true, length = 255)
    public String getPinyin_name() {
        return pinyin_name;
    }

    public void setPinyin_name(String pinyin_name) {
        this.pinyin_name = pinyin_name;
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
    public String getRating_count() {
        return rating_count;
    }

    public void setRating_count(String rating_count) {
        this.rating_count = rating_count;
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
    @Column(name = "satisfy_count", nullable = true, length = 255)
    public String getSatisfy_count() {
        return satisfy_count;
    }

    public void setSatisfy_count(String satisfy_count) {
        this.satisfy_count = satisfy_count;
    }

    @Basic
    @Column(name = "satisfy_rate", nullable = true, length = 255)
    public String getSatisfy_rate() {
        return satisfy_rate;
    }

    public void setSatisfy_rate(String satisfy_rate) {
        this.satisfy_rate = satisfy_rate;
    }

    @Basic
    @Column(name = "server_utc", nullable = true, length = 255)
    public String getServer_utc() {
        return server_utc;
    }

    public void setServer_utc(String server_utc) {
        this.server_utc = server_utc;
    }

    @Basic
    @Column(name = "specifications", nullable = true, length = 255)
    public String getSpecifications() {
        return specifications;
    }

    public void setSpecifications(String specifications) {
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
    @Column(name = "virtual_food_id", nullable = true, length = 255)
    public String getVirtualFoodId() {
        return virtualFoodId;
    }

    public void setVirtualFoodId(String virtualFoodId) {
        this.virtualFoodId = virtualFoodId;
    }

    @Basic
    @Column(name = "menu_id", nullable = true, length = 255)
    public String getMenu_id() {
        return menu_id;
    }

    public void setMenu_id(String menu_id) {
        this.menu_id = menu_id;
    }

    @Id
    @Column(name = "food_id", nullable = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public int getFood_id() {
        return food_id;
    }

    public void setFood_id(int food_id) {
        this.food_id = food_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EleMenuFoodEntity that = (EleMenuFoodEntity) o;

        if (food_id != that.food_id) return false;
        if (attribute != null ? !attribute.equals(that.attribute) : that.attribute != null) return false;
        if (attributes != null ? !attributes.equals(that.attributes) : that.attributes != null) return false;
        if (attrs != null ? !attrs.equals(that.attrs) : that.attrs != null) return false;
        if (category_id != null ? !category_id.equals(that.category_id) : that.category_id != null) return false;
        if (cold_box != null ? !cold_box.equals(that.cold_box) : that.cold_box != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (display_times != null ? !display_times.equals(that.display_times) : that.display_times != null)
            return false;
        if (image_path != null ? !image_path.equals(that.image_path) : that.image_path != null) return false;
        if (is_essential != null ? !is_essential.equals(that.is_essential) : that.is_essential != null) return false;
        if (is_featured != null ? !is_featured.equals(that.is_featured) : that.is_featured != null) return false;
        if (item_id != null ? !item_id.equals(that.item_id) : that.item_id != null) return false;
        if (limitation != null ? !limitation.equals(that.limitation) : that.limitation != null) return false;
        if (min_purchase != null ? !min_purchase.equals(that.min_purchase) : that.min_purchase != null) return false;
        if (month_sales != null ? !month_sales.equals(that.month_sales) : that.month_sales != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (pinyin_name != null ? !pinyin_name.equals(that.pinyin_name) : that.pinyin_name != null) return false;
        if (rating != null ? !rating.equals(that.rating) : that.rating != null) return false;
        if (rating_count != null ? !rating_count.equals(that.rating_count) : that.rating_count != null) return false;
        if (restaurant_id != null ? !restaurant_id.equals(that.restaurant_id) : that.restaurant_id != null)
            return false;
        if (satisfy_count != null ? !satisfy_count.equals(that.satisfy_count) : that.satisfy_count != null)
            return false;
        if (satisfy_rate != null ? !satisfy_rate.equals(that.satisfy_rate) : that.satisfy_rate != null) return false;
        if (server_utc != null ? !server_utc.equals(that.server_utc) : that.server_utc != null) return false;
        if (specifications != null ? !specifications.equals(that.specifications) : that.specifications != null)
            return false;
        if (tips != null ? !tips.equals(that.tips) : that.tips != null) return false;
        if (virtualFoodId != null ? !virtualFoodId.equals(that.virtualFoodId) : that.virtualFoodId != null)
            return false;
        if (menu_id != null ? !menu_id.equals(that.menu_id) : that.menu_id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = attribute != null ? attribute.hashCode() : 0;
        result = 31 * result + (attributes != null ? attributes.hashCode() : 0);
        result = 31 * result + (attrs != null ? attrs.hashCode() : 0);
        result = 31 * result + (category_id != null ? category_id.hashCode() : 0);
        result = 31 * result + (cold_box != null ? cold_box.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (display_times != null ? display_times.hashCode() : 0);
        result = 31 * result + (image_path != null ? image_path.hashCode() : 0);
        result = 31 * result + (is_essential != null ? is_essential.hashCode() : 0);
        result = 31 * result + (is_featured != null ? is_featured.hashCode() : 0);
        result = 31 * result + (item_id != null ? item_id.hashCode() : 0);
        result = 31 * result + (limitation != null ? limitation.hashCode() : 0);
        result = 31 * result + (min_purchase != null ? min_purchase.hashCode() : 0);
        result = 31 * result + (month_sales != null ? month_sales.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (pinyin_name != null ? pinyin_name.hashCode() : 0);
        result = 31 * result + (rating != null ? rating.hashCode() : 0);
        result = 31 * result + (rating_count != null ? rating_count.hashCode() : 0);
        result = 31 * result + (restaurant_id != null ? restaurant_id.hashCode() : 0);
        result = 31 * result + (satisfy_count != null ? satisfy_count.hashCode() : 0);
        result = 31 * result + (satisfy_rate != null ? satisfy_rate.hashCode() : 0);
        result = 31 * result + (server_utc != null ? server_utc.hashCode() : 0);
        result = 31 * result + (specifications != null ? specifications.hashCode() : 0);
        result = 31 * result + (tips != null ? tips.hashCode() : 0);
        result = 31 * result + (virtualFoodId != null ? virtualFoodId.hashCode() : 0);
        result = 31 * result + (menu_id != null ? menu_id.hashCode() : 0);
        result = 31 * result + food_id;
        return result;
    }
}
