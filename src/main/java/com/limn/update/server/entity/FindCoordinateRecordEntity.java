package com.limn.update.server.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "ele_find_coordinate_record", schema = "ele", catalog = "")
public class FindCoordinateRecordEntity {
    private int id;
    private String longitude;
    private String latitude;
    private Integer addcount;
    private Integer currentcount;
    private String maxlongitude;
    private String maxlatitude;
    private int findid;
    private String minlongitude;
    private String minlatitude;
    private BigDecimal avgdistance;
    private Date createDate;

    @Basic
    @Column(name = "create_date", nullable = true)
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Basic
    @Column(name = "avgdistance", nullable = true)
    public BigDecimal getAvgdistance() {
        return avgdistance;
    }

    public void setAvgdistance(BigDecimal avgdistance) {
        this.avgdistance = avgdistance;
    }

    @Basic
    @Column(name = "minlongitude", nullable = true)
    public String getMinlongitude() {
        return minlongitude;
    }

    public void setMinlongitude(String minlongitude) {
        this.minlongitude = minlongitude;
    }
    @Basic
    @Column(name = "minlatitude", nullable = true)
    public String getMinlatitude() {
        return minlatitude;
    }

    public void setMinlatitude(String minlatitude) {
        this.minlatitude = minlatitude;
    }

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "longitude", nullable = false, length = 50)
    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    @Basic
    @Column(name = "latitude", nullable = false, length = 50)
    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    @Basic
    @Column(name = "addcount", nullable = true)
    public Integer getAddcount() {
        return addcount;
    }

    public void setAddcount(Integer addcount) {
        this.addcount = addcount;
    }

    @Basic
    @Column(name = "currentcount", nullable = true)
    public Integer getCurrentcount() {
        return currentcount;
    }

    public void setCurrentcount(Integer currentcount) {
        this.currentcount = currentcount;
    }

    @Basic
    @Column(name = "maxlongitude", nullable = true, length = 50)
    public String getMaxlongitude() {
        return maxlongitude;
    }

    public void setMaxlongitude(String maxlongitude) {
        this.maxlongitude = maxlongitude;
    }

    @Basic
    @Column(name = "maxlatitude", nullable = true, length = 50)
    public String getMaxlatitude() {
        return maxlatitude;
    }

    public void setMaxlatitude(String maxlatitude) {
        this.maxlatitude = maxlatitude;
    }

    @Basic
    @Column(name = "findid", nullable = false)
    public int getFindid() {
        return findid;
    }

    public void setFindid(int findid) {
        this.findid = findid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FindCoordinateRecordEntity that = (FindCoordinateRecordEntity) o;

        if (id != that.id) return false;
        if (findid != that.findid) return false;
        if (longitude != null ? !longitude.equals(that.longitude) : that.longitude != null) return false;
        if (latitude != null ? !latitude.equals(that.latitude) : that.latitude != null) return false;
        if (addcount != null ? !addcount.equals(that.addcount) : that.addcount != null) return false;
        if (currentcount != null ? !currentcount.equals(that.currentcount) : that.currentcount != null) return false;
        if (maxlongitude != null ? !maxlongitude.equals(that.maxlongitude) : that.maxlongitude != null) return false;
        if (maxlatitude != null ? !maxlatitude.equals(that.maxlatitude) : that.maxlatitude != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (longitude != null ? longitude.hashCode() : 0);
        result = 31 * result + (latitude != null ? latitude.hashCode() : 0);
        result = 31 * result + (addcount != null ? addcount.hashCode() : 0);
        result = 31 * result + (currentcount != null ? currentcount.hashCode() : 0);
        result = 31 * result + (maxlongitude != null ? maxlongitude.hashCode() : 0);
        result = 31 * result + (maxlatitude != null ? maxlatitude.hashCode() : 0);
        result = 31 * result + findid;
        return result;
    }
}
