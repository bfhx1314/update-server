package com.limn.update.server.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by limengnan on 2017/11/17.
 */
@Entity
@Table(name = "ele_menu", schema = "ele", catalog = "")
public class EleMenuEntity {
    private String attribute;
    private String description;
    private String grey_icon_url;
    private String icon_url;
    private String id;
    private String is_activity;
    private String is_selected;
    private String name;
    private String type;
    private String shopId;
    private int menu_id;
    private String greyIconUrl;
    private String iconUrl;
    private String isActivity;
    private String isSelected;
    private Date createDate;

    public String getGreyIconUrl() {
        return greyIconUrl;
    }

    public void setGreyIconUrl(String greyIconUrl) {
        this.greyIconUrl = greyIconUrl;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getIsActivity() {
        return isActivity;
    }

    public void setIsActivity(String isActivity) {
        this.isActivity = isActivity;
    }

    public String getIsSelected() {
        return isSelected;
    }

    public void setIsSelected(String isSelected) {
        this.isSelected = isSelected;
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

    public void setGrey_icon_url(String grey_icon_url) {
        this.grey_icon_url = grey_icon_url;
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
    @Column(name = "id", nullable = true, length = 255)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "is_activity", nullable = true, length = 255)
    public String getIs_activity() {
        return is_activity;
    }

    public void setIs_activity(String is_activity) {
        this.is_activity = is_activity;
    }

    @Basic
    @Column(name = "is_selected", nullable = true, length = 255)
    public String getIs_selected() {
        return is_selected;
    }

    public void setIs_selected(String is_selected) {
        this.is_selected = is_selected;
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
    @Column(name = "type", nullable = true, length = 255)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "shop_id", nullable = true, length = 255)
    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    @Id
    @Column(name = "menu_id", nullable = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public int getMenu_id() {
        return menu_id;
    }

    public void setMenu_id(int menu_id) {
        this.menu_id = menu_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EleMenuEntity that = (EleMenuEntity) o;

        if (menu_id != that.menu_id) return false;
        if (attribute != null ? !attribute.equals(that.attribute) : that.attribute != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (grey_icon_url != null ? !grey_icon_url.equals(that.grey_icon_url) : that.grey_icon_url != null)
            return false;
        if (icon_url != null ? !icon_url.equals(that.icon_url) : that.icon_url != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (is_activity != null ? !is_activity.equals(that.is_activity) : that.is_activity != null) return false;
        if (is_selected != null ? !is_selected.equals(that.is_selected) : that.is_selected != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (shopId != null ? !shopId.equals(that.shopId) : that.shopId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = attribute != null ? attribute.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (grey_icon_url != null ? grey_icon_url.hashCode() : 0);
        result = 31 * result + (icon_url != null ? icon_url.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (is_activity != null ? is_activity.hashCode() : 0);
        result = 31 * result + (is_selected != null ? is_selected.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (shopId != null ? shopId.hashCode() : 0);
        result = 31 * result + menu_id;
        return result;
    }

}
