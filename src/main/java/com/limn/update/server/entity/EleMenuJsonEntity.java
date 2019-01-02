package com.limn.update.server.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by limengnan on 2018/4/20.
 */
@Entity
@Table(name = "ele_menu_json", schema = "ele", catalog = "")
public class EleMenuJsonEntity {
    private int id;
    private int menuId;
    private Date createDate;
    private int version;
    private String valid;
    private String json;
    private int findId;
    private String shopId;
    private Integer isAnalysis;

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

    @Basic
    @Column(name = "menu_id", nullable = false)
    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    @Basic
    @Column(name = "create_date", nullable = false)
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Basic
    @Column(name = "version", nullable = false)
    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @Basic
    @Column(name = "valid", nullable = false, length = 1)
    public String getValid() {
        return valid;
    }

    public void setValid(String valid) {
        this.valid = valid;
    }

    @Basic
    @Column(name = "json", nullable = false, length = -1)
    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EleMenuJsonEntity that = (EleMenuJsonEntity) o;

        if (id != that.id) return false;
        if (menuId != that.menuId) return false;
        if (version != that.version) return false;
        if (createDate != null ? !createDate.equals(that.createDate) : that.createDate != null) return false;
        if (valid != null ? !valid.equals(that.valid) : that.valid != null) return false;
        if (json != null ? !json.equals(that.json) : that.json != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + menuId;
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + version;
        result = 31 * result + (valid != null ? valid.hashCode() : 0);
        result = 31 * result + (json != null ? json.hashCode() : 0);
        return result;
    }

    @Basic
    @Column(name = "find_id", nullable = false)
    public int getFindId() {
        return findId;
    }

    public void setFindId(int findId) {
        this.findId = findId;
    }

    @Basic
    @Column(name = "shop_id", nullable = false)
    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
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
