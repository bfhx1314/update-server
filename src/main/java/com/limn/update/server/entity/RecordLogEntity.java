package com.limn.update.server.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by limengnan on 2018/1/30.
 */
@Entity
@Table(name = "record_log", schema = "ele", catalog = "")
public class RecordLogEntity {
    private int id;
    private String type;
    private String source;
    private String exeResult;
    private String log1;
    private String log2;
    private String log3;
    private String log4;
    private Date createDate;
    private String uuid;
    private String deviceName;

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "type", nullable = false, length = 255)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "source", nullable = false, length = 255)
    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    @Basic
    @Column(name = "exe_result", nullable = true, length = 255)
    public String getExeResult() {
        return exeResult;
    }

    public void setExeResult(String exeResult) {
        this.exeResult = exeResult;
    }

    @Basic
    @Column(name = "log1", nullable = true, length = 5000)
    public String getLog1() {
        return log1;
    }

    public void setLog1(String log1) {
        this.log1 = log1;
    }

    @Basic
    @Column(name = "log2", nullable = true, length = 5000)
    public String getLog2() {
        return log2;
    }

    public void setLog2(String log2) {
        this.log2 = log2;
    }

    @Basic
    @Column(name = "log3", nullable = true, length = 5000)
    public String getLog3() {
        return log3;
    }

    public void setLog3(String log3) {
        this.log3 = log3;
    }

    @Basic
    @Column(name = "log4", nullable = true, length = 5000)
    public String getLog4() {
        return log4;
    }

    public void setLog4(String log4) {
        this.log4 = log4;
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
    @Column(name = "uuid", nullable = true, length = 255)
    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RecordLogEntity that = (RecordLogEntity) o;

        if (id != that.id) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (source != null ? !source.equals(that.source) : that.source != null) return false;
        if (exeResult != null ? !exeResult.equals(that.exeResult) : that.exeResult != null) return false;
        if (log1 != null ? !log1.equals(that.log1) : that.log1 != null) return false;
        if (log2 != null ? !log2.equals(that.log2) : that.log2 != null) return false;
        if (log3 != null ? !log3.equals(that.log3) : that.log3 != null) return false;
        if (log4 != null ? !log4.equals(that.log4) : that.log4 != null) return false;
        if (createDate != null ? !createDate.equals(that.createDate) : that.createDate != null) return false;
        if (uuid != null ? !uuid.equals(that.uuid) : that.uuid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (source != null ? source.hashCode() : 0);
        result = 31 * result + (exeResult != null ? exeResult.hashCode() : 0);
        result = 31 * result + (log1 != null ? log1.hashCode() : 0);
        result = 31 * result + (log2 != null ? log2.hashCode() : 0);
        result = 31 * result + (log3 != null ? log3.hashCode() : 0);
        result = 31 * result + (log4 != null ? log4.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (uuid != null ? uuid.hashCode() : 0);
        return result;
    }

    @Basic
    @Column(name = "device_name", nullable = true, length = 255)
    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }
}
