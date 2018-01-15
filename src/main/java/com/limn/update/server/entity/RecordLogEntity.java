package com.limn.update.server.entity;

import org.joda.time.DateTime;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;


@Entity
@Table(name = "record_log")
public class RecordLogEntity {


    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Basic
    @Column(name = "type")
    private String type;

    @Basic
    @Column(name = "source")
    private String source;

    @Basic
    @Column(name = "exeResult")
    private String exeResult;

    @Basic
    @Column(name = "log1")
    private String log1;

    @Basic
    @Column(name = "log2")
    private String log2;

    @Basic
    @Column(name = "log3")
    private String log3;

    @Basic
    @Column(name = "log4")
    private String log4;

    @Basic
    @Column(name = "createDate")
    private Date createDate;

    @Basic
    @Column(name = "uuid")
    private String uuid;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getExeResult() {
        return exeResult;
    }

    public void setExeResult(String exeResult) {
        this.exeResult = exeResult;
    }

    public String getLog1() {
        return log1;
    }

    public void setLog1(String log1) {
        this.log1 = log1;
    }

    public String getLog2() {
        return log2;
    }

    public void setLog2(String log2) {
        this.log2 = log2;
    }

    public String getLog3() {
        return log3;
    }

    public void setLog3(String log3) {
        this.log3 = log3;
    }

    public String getLog4() {
        return log4;
    }

    public void setLog4(String log4) {
        this.log4 = log4;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
