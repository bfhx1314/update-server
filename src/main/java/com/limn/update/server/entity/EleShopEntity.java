package com.limn.update.server.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "ele_shop", schema = "ele", catalog = "")
public class EleShopEntity {
    private Integer id;
    private String address;
    private Integer authentic_id;
    private String description;
    private String distance;
    private String favored;
    private String float_delivery_fee;
    private String float_minimum_order_amount;
    private String is_new;
    private String is_premium;
    private String is_stock_empty;
    private String is_valid;
    private String latitude;
    private String list_quality_icon;
    private String longitude;
    private String max_applied_quantity_per_order;
    private String name;
    private String next_business_time;
    private String only_use_poi;
    private String order_lead_time;
    private String phone;
    private String rating;
    private String rating_count;
    private String recent_order_num;
    private String status;
    private String type;
    private String image_path;
    private String promotion_info;
    private String regular_customer_count;
    private int shop_id;
    private String json;
    private int findid;

    @Basic
    @Column(name = "findid", nullable = true)
    public int getFindid() {
        return findid;
    }

    public void setFindid(int findid) {
        this.findid = findid;
    }

    @Basic
    @Column(name = "json", nullable = true)
    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }

    @Basic
    @GeneratedValue(generator = "id")
    @GenericGenerator(name = "id", strategy = "assigned")
    @Column(name = "id", nullable = true)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "address", nullable = true, length = 50)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "authentic_id", nullable = true)
    public Integer getAuthentic_id() {
        return authentic_id;
    }

    public void setAuthentic_id(Integer authentic_id) {
        this.authentic_id = authentic_id;
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
    public String getFloat_delivery_fee() {
        return float_delivery_fee;
    }

    public void setFloat_delivery_fee(String float_delivery_fee) {
        this.float_delivery_fee = float_delivery_fee;
    }

    @Basic
    @Column(name = "float_minimum_order_amount", nullable = true, length = 255)
    public String getFloat_minimum_order_amount() {
        return float_minimum_order_amount;
    }

    public void setFloat_minimum_order_amount(String float_minimum_order_amount) {
        this.float_minimum_order_amount = float_minimum_order_amount;
    }

    @Basic
    @Column(name = "is_new", nullable = true, length = 255)
    public String getIs_new() {
        return is_new;
    }

    public void setIs_new(String is_new) {
        this.is_new = is_new;
    }

    @Basic
    @Column(name = "is_premium", nullable = true, length = 255)
    public String getIs_premium() {
        return is_premium;
    }

    public void setIs_premium(String is_premium) {
        this.is_premium = is_premium;
    }

    @Basic
    @Column(name = "is_stock_empty", nullable = true, length = 255)
    public String getIs_stock_empty() {
        return is_stock_empty;
    }

    public void setIs_stock_empty(String is_stock_empty) {
        this.is_stock_empty = is_stock_empty;
    }

    @Basic
    @Column(name = "is_valid", nullable = true, length = 255)
    public String getIs_valid() {
        return is_valid;
    }

    public void setIs_valid(String is_valid) {
        this.is_valid = is_valid;
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
    public String getList_quality_icon() {
        return list_quality_icon;
    }

    public void setList_quality_icon(String list_quality_icon) {
        this.list_quality_icon = list_quality_icon;
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
    public String getMax_applied_quantity_per_order() {
        return max_applied_quantity_per_order;
    }

    public void setMax_applied_quantity_per_order(String max_applied_quantity_per_order) {
        this.max_applied_quantity_per_order = max_applied_quantity_per_order;
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
    @Column(name = "next_business_time", nullable = true, length = 255)
    public String getNext_business_time() {
        return next_business_time;
    }

    public void setNext_business_time(String next_business_time) {
        this.next_business_time = next_business_time;
    }

    @Basic
    @Column(name = "only_use_poi", nullable = true, length = 255)
    public String getOnly_use_poi() {
        return only_use_poi;
    }

    public void setOnly_use_poi(String only_use_poi) {
        this.only_use_poi = only_use_poi;
    }

    @Basic
    @Column(name = "order_lead_time", nullable = true, length = 255)
    public String getOrder_lead_time() {
        return order_lead_time;
    }

    public void setOrder_lead_time(String order_lead_time) {
        this.order_lead_time = order_lead_time;
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
    public String getRating_count() {
        return rating_count;
    }

    public void setRating_count(String rating_count) {
        this.rating_count = rating_count;
    }

    @Basic
    @Column(name = "recent_order_num", nullable = true, length = 255)
    public String getRecent_order_num() {
        return recent_order_num;
    }

    public void setRecent_order_num(String recent_order_num) {
        this.recent_order_num = recent_order_num;
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
    public String getImage_path() {
        return image_path;
    }

    public void setImage_path(String image_path) {
        this.image_path = image_path;
    }

    @Basic
    @Column(name = "promotion_info", nullable = true, length = 255)
    public String getPromotion_info() {
        return promotion_info;
    }

    public void setPromotion_info(String promotion_info) {
        this.promotion_info = promotion_info;
    }

    @Basic
    @Column(name = "regular_customer_count", nullable = true, length = 255)
    public String getRegular_customer_count() {
        return regular_customer_count;
    }

    public void setRegular_customer_count(String regular_customer_count) {
        this.regular_customer_count = regular_customer_count;
    }

    @Id
    @Column(name = "shop_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getShop_id() {
        return shop_id;
    }

    public void setShop_id(int shopId) {
        this.shop_id = shopId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EleShopEntity that = (EleShopEntity) o;

        if (shop_id != that.shop_id) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (authentic_id != null ? !authentic_id.equals(that.authentic_id) : that.authentic_id != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (distance != null ? !distance.equals(that.distance) : that.distance != null) return false;
        if (favored != null ? !favored.equals(that.favored) : that.favored != null) return false;
        if (float_delivery_fee != null ? !float_delivery_fee.equals(that.float_delivery_fee) : that.float_delivery_fee != null)
            return false;
        if (float_minimum_order_amount != null ? !float_minimum_order_amount.equals(that.float_minimum_order_amount) : that.float_minimum_order_amount != null)
            return false;
        if (is_new != null ? !is_new.equals(that.is_new) : that.is_new != null) return false;
        if (is_premium != null ? !is_premium.equals(that.is_premium) : that.is_premium != null) return false;
        if (is_stock_empty != null ? !is_stock_empty.equals(that.is_stock_empty) : that.is_stock_empty != null)
            return false;
        if (is_valid != null ? !is_valid.equals(that.is_valid) : that.is_valid != null) return false;
        if (latitude != null ? !latitude.equals(that.latitude) : that.latitude != null) return false;
        if (list_quality_icon != null ? !list_quality_icon.equals(that.list_quality_icon) : that.list_quality_icon != null)
            return false;
        if (longitude != null ? !longitude.equals(that.longitude) : that.longitude != null) return false;
        if (max_applied_quantity_per_order != null ? !max_applied_quantity_per_order.equals(that.max_applied_quantity_per_order) : that.max_applied_quantity_per_order != null)
            return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (next_business_time != null ? !next_business_time.equals(that.next_business_time) : that.next_business_time != null)
            return false;
        if (only_use_poi != null ? !only_use_poi.equals(that.only_use_poi) : that.only_use_poi != null) return false;
        if (order_lead_time != null ? !order_lead_time.equals(that.order_lead_time) : that.order_lead_time != null)
            return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
        if (rating != null ? !rating.equals(that.rating) : that.rating != null) return false;
        if (rating_count != null ? !rating_count.equals(that.rating_count) : that.rating_count != null) return false;
        if (recent_order_num != null ? !recent_order_num.equals(that.recent_order_num) : that.recent_order_num != null)
            return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (image_path != null ? !image_path.equals(that.image_path) : that.image_path != null) return false;
        if (promotion_info != null ? !promotion_info.equals(that.promotion_info) : that.promotion_info != null)
            return false;
        if (regular_customer_count != null ? !regular_customer_count.equals(that.regular_customer_count) : that.regular_customer_count != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (authentic_id != null ? authentic_id.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (distance != null ? distance.hashCode() : 0);
        result = 31 * result + (favored != null ? favored.hashCode() : 0);
        result = 31 * result + (float_delivery_fee != null ? float_delivery_fee.hashCode() : 0);
        result = 31 * result + (float_minimum_order_amount != null ? float_minimum_order_amount.hashCode() : 0);
        result = 31 * result + (is_new != null ? is_new.hashCode() : 0);
        result = 31 * result + (is_premium != null ? is_premium.hashCode() : 0);
        result = 31 * result + (is_stock_empty != null ? is_stock_empty.hashCode() : 0);
        result = 31 * result + (is_valid != null ? is_valid.hashCode() : 0);
        result = 31 * result + (latitude != null ? latitude.hashCode() : 0);
        result = 31 * result + (list_quality_icon != null ? list_quality_icon.hashCode() : 0);
        result = 31 * result + (longitude != null ? longitude.hashCode() : 0);
        result = 31 * result + (max_applied_quantity_per_order != null ? max_applied_quantity_per_order.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (next_business_time != null ? next_business_time.hashCode() : 0);
        result = 31 * result + (only_use_poi != null ? only_use_poi.hashCode() : 0);
        result = 31 * result + (order_lead_time != null ? order_lead_time.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (rating != null ? rating.hashCode() : 0);
        result = 31 * result + (rating_count != null ? rating_count.hashCode() : 0);
        result = 31 * result + (recent_order_num != null ? recent_order_num.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (image_path != null ? image_path.hashCode() : 0);
        result = 31 * result + (promotion_info != null ? promotion_info.hashCode() : 0);
        result = 31 * result + (regular_customer_count != null ? regular_customer_count.hashCode() : 0);
        result = 31 * result + shop_id;
        return result;
    }
}
