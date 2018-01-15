package com.limn.update.server.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "qtt_imei_record", schema = "ele", catalog = "")
public class QttImeiRecordEntity {
    private int id;
    private String phone;
    private String imei;
    private Timestamp usedTime;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "phone", nullable = true, length = 32)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "imei", nullable = false, length = 32)
    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    @Basic
    @Column(name = "usedTime", nullable = true)
    public Timestamp getUsedTime() {
        return usedTime;
    }

    public void setUsedTime(Timestamp usedTime) {
        this.usedTime = usedTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        QttImeiRecordEntity that = (QttImeiRecordEntity) o;

        if (id != that.id) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
        if (imei != null ? !imei.equals(that.imei) : that.imei != null) return false;
        if (usedTime != null ? !usedTime.equals(that.usedTime) : that.usedTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (imei != null ? imei.hashCode() : 0);
        result = 31 * result + (usedTime != null ? usedTime.hashCode() : 0);
        return result;
    }
}
