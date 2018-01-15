package com.limn.update.server.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "qtt_user_day_gold_record", schema = "ele", catalog = "")
public class QttUserDayGoldRecordEntity {
    private int id;
    private String phone;
    private Timestamp activateDate;
    private Integer originalGolds;
    private Integer newGolds;
    private Integer getGolds;
    private Integer usedTime;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "phone", nullable = false, length = 32)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "activateDate", nullable = true)
    public Timestamp getActivateDate() {
        return activateDate;
    }

    public void setActivateDate(Timestamp activateDate) {
        this.activateDate = activateDate;
    }

    @Basic
    @Column(name = "originalGolds", nullable = true)
    public Integer getOriginalGolds() {
        return originalGolds;
    }

    public void setOriginalGolds(Integer originalGolds) {
        this.originalGolds = originalGolds;
    }

    @Basic
    @Column(name = "newGolds", nullable = true)
    public Integer getNewGolds() {
        return newGolds;
    }

    public void setNewGolds(Integer newGolds) {
        this.newGolds = newGolds;
    }

    @Basic
    @Column(name = "getGolds", nullable = true)
    public Integer getGetGolds() {
        return getGolds;
    }

    public void setGetGolds(Integer getGolds) {
        this.getGolds = getGolds;
    }

    @Basic
    @Column(name = "usedTime", nullable = true)
    public Integer getUsedTime() {
        return usedTime;
    }

    public void setUsedTime(Integer usedTime) {
        this.usedTime = usedTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        QttUserDayGoldRecordEntity that = (QttUserDayGoldRecordEntity) o;

        if (id != that.id) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
        if (activateDate != null ? !activateDate.equals(that.activateDate) : that.activateDate != null) return false;
        if (originalGolds != null ? !originalGolds.equals(that.originalGolds) : that.originalGolds != null)
            return false;
        if (newGolds != null ? !newGolds.equals(that.newGolds) : that.newGolds != null) return false;
        if (getGolds != null ? !getGolds.equals(that.getGolds) : that.getGolds != null) return false;
        if (usedTime != null ? !usedTime.equals(that.usedTime) : that.usedTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (activateDate != null ? activateDate.hashCode() : 0);
        result = 31 * result + (originalGolds != null ? originalGolds.hashCode() : 0);
        result = 31 * result + (newGolds != null ? newGolds.hashCode() : 0);
        result = 31 * result + (getGolds != null ? getGolds.hashCode() : 0);
        result = 31 * result + (usedTime != null ? usedTime.hashCode() : 0);
        return result;
    }
}
