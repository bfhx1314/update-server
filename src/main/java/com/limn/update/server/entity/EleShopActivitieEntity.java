package com.limn.update.server.entity;

import javax.persistence.*;

/**
 * Created by limengnan on 2017/11/16.
 */
@Entity
@Table(name = "ele_shop_activitie", schema = "ele", catalog = "")
public class EleShopActivitieEntity {
    private String attribute;
    private String description;
    private String icon_color;
    private String icon_name;
    private String id;
    private String is_exclusive_with_food_activity;
    private String name;
    private String tips;
    private String type;
    private String shopId;
    private int activitie_id;

    @Basic
    @Column(name = "attribute", nullable = true, length = 255)
    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
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
    @Column(name = "icon_color", nullable = true, length = 255)
    public String getIcon_color() {
        return icon_color;
    }

    public void setIcon_color(String icon_color) {
        this.icon_color = icon_color;
    }

    @Basic
    @Column(name = "icon_name", nullable = true, length = 255)
    public String getIcon_name() {
        return icon_name;
    }

    public void setIcon_name(String icon_name) {
        this.icon_name = icon_name;
    }

    @Basic
    @Column(name = "id", nullable = true, length = 255)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "is_exclusive_with_food_activity", nullable = true, length = 255)
    public String getIs_exclusive_with_food_activity() {
        return is_exclusive_with_food_activity;
    }

    public void setIs_exclusive_with_food_activity(String is_exclusive_with_food_activity) {
        this.is_exclusive_with_food_activity = is_exclusive_with_food_activity;
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
    @Column(name = "tips", nullable = true, length = 255)
    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips;
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
    @Column(name = "shop_id", nullable = true)
    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    @Id
    @Column(name = "activitie_id", nullable = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public int getActivitie_id() {
        return activitie_id;
    }

    public void setActivitie_id(int activitie_id) {
        this.activitie_id = activitie_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EleShopActivitieEntity that = (EleShopActivitieEntity) o;

        if (activitie_id != that.activitie_id) return false;
        if (attribute != null ? !attribute.equals(that.attribute) : that.attribute != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (icon_color != null ? !icon_color.equals(that.icon_color) : that.icon_color != null) return false;
        if (icon_name != null ? !icon_name.equals(that.icon_name) : that.icon_name != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (is_exclusive_with_food_activity != null ? !is_exclusive_with_food_activity.equals(that.is_exclusive_with_food_activity) : that.is_exclusive_with_food_activity != null)
            return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (tips != null ? !tips.equals(that.tips) : that.tips != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (shopId != null ? !shopId.equals(that.shopId) : that.shopId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = attribute != null ? attribute.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (icon_color != null ? icon_color.hashCode() : 0);
        result = 31 * result + (icon_name != null ? icon_name.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (is_exclusive_with_food_activity != null ? is_exclusive_with_food_activity.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (tips != null ? tips.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (shopId != null ? shopId.hashCode() : 0);
        result = 31 * result + activitie_id;
        return result;
    }
}
