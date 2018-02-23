package com.limn.update.server.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by limengnan on 2018/2/23.
 */
@Entity
@Table(name = "ele_menu", schema = "ele", catalog = "")
@IdClass(EleMenuEntityPK.class)
public class EleMenuEntity {
    private int id;
    private String shopId;
    private String menuId;
    private String name;
    private String json;
    private String description;
    private String grey_icon_url;
    private String icon_url;
    private String is_activity;
    private String is_selected;
    private String type;
    private Date createDate;
    private String attribute;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Id
    @Column(name = "shop_id", nullable = false, length = 255)
    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    @Basic
    @Column(name = "menu_id", nullable = true)
    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
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
    @Column(name = "json", nullable = true, length = -1)
    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
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
    @Column(name = "grey_icon_url", nullable = true, length = 255)
    public String getGrey_icon_url() {
        return grey_icon_url;
    }

    public void setGrey_icon_url(String greyIconUrl) {
        this.grey_icon_url = greyIconUrl;
    }

    @Basic
    @Column(name = "icon_url", nullable = true, length = 255)
    public String getIcon_url() {
        return icon_url;
    }

    public void setIcon_url(String icon_url) {
        this.icon_url = icon_url;
    }

    @Basic
    @Column(name = "is_activity", nullable = true, length = 255)
    public String getIs_activity() {
        return is_activity;
    }

    public void setIs_activity(String isActivity) {
        this.is_activity = isActivity;
    }

    @Basic
    @Column(name = "is_selected", nullable = true, length = 255)
    public String getIs_selected() {
        return is_selected;
    }

    public void setIs_selected(String isSelected) {
        this.is_selected = isSelected;
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
        if (shopId != null ? !shopId.equals(that.shopId) : that.shopId != null) return false;
        if (menuId != null ? !menuId.equals(that.menuId) : that.menuId != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (json != null ? !json.equals(that.json) : that.json != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (grey_icon_url != null ? !grey_icon_url.equals(that.grey_icon_url) : that.grey_icon_url != null) return false;
        if (icon_url != null ? !icon_url.equals(that.icon_url) : that.icon_url != null) return false;
        if (is_activity != null ? !is_activity.equals(that.is_activity) : that.is_activity != null) return false;
        if (is_selected != null ? !is_selected.equals(that.is_selected) : that.is_selected != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (createDate != null ? !createDate.equals(that.createDate) : that.createDate != null) return false;
        if (attribute != null ? !attribute.equals(that.attribute) : that.attribute != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (shopId != null ? shopId.hashCode() : 0);
        result = 31 * result + (menuId != null ? menuId.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (json != null ? json.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (grey_icon_url != null ? grey_icon_url.hashCode() : 0);
        result = 31 * result + (icon_url != null ? icon_url.hashCode() : 0);
        result = 31 * result + (is_activity != null ? is_activity.hashCode() : 0);
        result = 31 * result + (is_selected != null ? is_selected.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (attribute != null ? attribute.hashCode() : 0);
        return result;
    }
}
