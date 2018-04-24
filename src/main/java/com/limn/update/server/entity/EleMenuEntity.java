package com.limn.update.server.entity;

import com.alibaba.fastjson.annotation.JSONField;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by limengnan on 2018/2/23.
 */
@Entity
@Table(name = "ele_menu", schema = "ele", catalog = "")
public class EleMenuEntity implements Serializable {
    private int id;
    private int shopId;
    @JSONField(name = "id")
    private int menuId;
    private String name;
    private String description;
    private String type;
    private Date createDate;
    private String attribute;
    @JSONField(name = "grey_icon_url")
    private String greyIconUrl;
    @JSONField(name = "icon_url")
    private String iconUrl;
    @JSONField(name = "is_activity")
    private String isActivity;
    @JSONField(name = "is_selected")
    private String isSelected;
    private Object foods;
    @JSONField(name = "is_analysis")
    private Integer isAnalysis;

    public void setFoods(String foods) {
        this.foods = foods;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
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

    @Column(name = "shop_id", nullable = false, length = 255)
    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    @Basic
    @Column(name = "menu_id", nullable = true, length = 255)
    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
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
    @Column(name = "description", nullable = true, length = 255)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
    @Column(name = "create_date", nullable = true)
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Basic
    @Column(name = "attribute", nullable = true, length = 255)
    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EleMenuEntity that = (EleMenuEntity) o;

        if (id != that.id) return false;
        if (shopId != that.shopId) return false;
        if (menuId != that.menuId) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (createDate != null ? !createDate.equals(that.createDate) : that.createDate != null) return false;
        if (attribute != null ? !attribute.equals(that.attribute) : that.attribute != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (attribute != null ? attribute.hashCode() : 0);
        return result;
    }

    @Basic
    @Column(name = "grey_icon_url", nullable = true, length = 255)
    public String getGreyIconUrl() {
        return greyIconUrl;
    }

    public void setGreyIconUrl(String greyIconUrl) {
        this.greyIconUrl = greyIconUrl;
    }

    @Basic
    @Column(name = "icon_url", nullable = true, length = 255)
    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    @Basic
    @Column(name = "is_activity", nullable = true, length = 255)
    public String getIsActivity() {
        return isActivity;
    }

    public void setIsActivity(String isActivity) {
        this.isActivity = isActivity;
    }

    @Basic
    @Column(name = "is_selected", nullable = true, length = 255)
    public String getIsSelected() {
        return isSelected;
    }

    public void setIsSelected(String isSelected) {
        this.isSelected = isSelected;
    }

    @Basic
    @Column(name = "foods", nullable = true, length = -1)
    public String getFoods() {
        return foods.toString();
    }

    public void setFoods(Object foods) {
        this.foods = foods;
    }

    @Basic
    @Column(name = "is_analysis", nullable = true)
    public Integer getIsAnalysis() {
        return isAnalysis;
    }

    public void setIsAnalysis(Integer isAnalysis) {
        this.isAnalysis = isAnalysis;
    }
}
