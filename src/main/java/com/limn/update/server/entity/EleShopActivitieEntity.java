package com.limn.update.server.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "ele_shop_activitie", schema = "ele", catalog = "")
public class EleShopActivitieEntity {
    private int activitieId;
    private String shopId;
    private Integer version;
    private Date createDate;
    private String attribute;
    private String description;
    private String iconColor;
    private String iconName;
    private String id;
    private String isExclusiveWithFoodActivity;
    private String name;
    private String tips;
    private String type;

    @Id
    @Column(name = "activitie_id", nullable = false)
    public int getActivitieId() {
        return activitieId;
    }

    public void setActivitieId(int activitieId) {
        this.activitieId = activitieId;
    }

    @Basic
    @Column(name = "shop_id", nullable = true, length = 255)
    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
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
    @Column(name = "create_date", nullable = true)
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Basic
    @Column(name = "attribute", nullable = true, length = 2000)
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
    public String getIconColor() {
        return iconColor;
    }

    public void setIconColor(String iconColor) {
        this.iconColor = iconColor;
    }

    @Basic
    @Column(name = "icon_name", nullable = true, length = 255)
    public String getIconName() {
        return iconName;
    }

    public void setIconName(String iconName) {
        this.iconName = iconName;
    }

    @Basic
    @Column(name = "id", nullable = true)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "is_exclusive_with_food_activity", nullable = true, length = 255)
    public String getIsExclusiveWithFoodActivity() {
        return isExclusiveWithFoodActivity;
    }

    public void setIsExclusiveWithFoodActivity(String isExclusiveWithFoodActivity) {
        this.isExclusiveWithFoodActivity = isExclusiveWithFoodActivity;
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
    @Column(name = "type", nullable = true)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EleShopActivitieEntity that = (EleShopActivitieEntity) o;
        return activitieId == that.activitieId &&
                Objects.equals(shopId, that.shopId) &&
                Objects.equals(version, that.version) &&
                Objects.equals(createDate, that.createDate) &&
                Objects.equals(attribute, that.attribute) &&
                Objects.equals(description, that.description) &&
                Objects.equals(iconColor, that.iconColor) &&
                Objects.equals(iconName, that.iconName) &&
                Objects.equals(id, that.id) &&
                Objects.equals(isExclusiveWithFoodActivity, that.isExclusiveWithFoodActivity) &&
                Objects.equals(name, that.name) &&
                Objects.equals(tips, that.tips) &&
                Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {

        return Objects.hash(activitieId, shopId, version, createDate, attribute, description, iconColor, iconName, id, isExclusiveWithFoodActivity, name, tips, type);
    }
}
