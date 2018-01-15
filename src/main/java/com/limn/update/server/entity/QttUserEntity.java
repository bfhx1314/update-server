package com.limn.update.server.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "qtt_user", schema = "ele", catalog = "")
public class QttUserEntity {
    private int id;
    private String phone;
    private String pwd;
    private String imei;
    private Timestamp lastActivate;
    private BigDecimal balance;
    private Integer sumGetGolds;
    private Timestamp singDate;

    private String valid;


    @Basic
    @Column(name = "valid", nullable = false, length = 1)
    public String getValid() {
        return valid;
    }

    public void setValid(String valid) {
        this.valid = valid;
    }

    @Id
    @Column(name = "id", nullable = false)
    @GenericGenerator(name = "id", strategy = "assigned")
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
    @Column(name = "pwd", nullable = false, length = 50)
    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Basic
    @Column(name = "imei", nullable = false, length = 50)
    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    @Basic
    @Column(name = "lastActivate", nullable = true)
    public Timestamp getLastActivate() {
        return lastActivate;
    }

    public void setLastActivate(Timestamp lastActivate) {
        this.lastActivate = lastActivate;
    }

    @Basic
    @Column(name = "balance", nullable = true, precision = 2)
    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    @Basic
    @Column(name = "sumGetGolds", nullable = true)
    public Integer getSumGetGolds() {
        return sumGetGolds;
    }

    public void setSumGetGolds(Integer sumGetGolds) {
        this.sumGetGolds = sumGetGolds;
    }

    @Basic
    @Column(name = "singDate", nullable = true)
    public Timestamp getSingDate() {
        return singDate;
    }

    @Basic
    @Column(name = "uuid")
    private String uuid;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public void setSingDate(Timestamp singDate) {
        this.singDate = singDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        QttUserEntity that = (QttUserEntity) o;

        if (id != that.id) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
        if (pwd != null ? !pwd.equals(that.pwd) : that.pwd != null) return false;
        if (imei != null ? !imei.equals(that.imei) : that.imei != null) return false;
        if (lastActivate != null ? !lastActivate.equals(that.lastActivate) : that.lastActivate != null) return false;
        if (balance != null ? !balance.equals(that.balance) : that.balance != null) return false;
        if (sumGetGolds != null ? !sumGetGolds.equals(that.sumGetGolds) : that.sumGetGolds != null) return false;
        if (singDate != null ? !singDate.equals(that.singDate) : that.singDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (pwd != null ? pwd.hashCode() : 0);
        result = 31 * result + (imei != null ? imei.hashCode() : 0);
        result = 31 * result + (lastActivate != null ? lastActivate.hashCode() : 0);
        result = 31 * result + (balance != null ? balance.hashCode() : 0);
        result = 31 * result + (sumGetGolds != null ? sumGetGolds.hashCode() : 0);
        result = 31 * result + (singDate != null ? singDate.hashCode() : 0);
        return result;
    }
}
