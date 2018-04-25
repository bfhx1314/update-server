package com.limn.update.server.entity;

import javax.persistence.*;

/**
 * Created by limengnan on 2018/4/24.
 */
@Entity
@Table(name = "sshhww_task_uuid", schema = "ele", catalog = "")
public class SshhwwTaskUuidEntity {
    private int id;
    private String taskName;
    private String uuid;
    private String value;
    private String valid;
    private Integer isGlobal;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "task_name", nullable = true, length = 255)
    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    @Basic
    @Column(name = "uuid", nullable = true, length = 255)
    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @Basic
    @Column(name = "value", nullable = true, length = 255)
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Basic
    @Column(name = "valid", nullable = true, length = 1)
    public String getValid() {
        return valid;
    }

    public void setValid(String valid) {
        this.valid = valid;
    }

    @Basic
    @Column(name = "is_global", nullable = true)
    public Integer getIsGlobal() {
        return isGlobal;
    }

    public void setIsGlobal(Integer isGlobal) {
        this.isGlobal = isGlobal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SshhwwTaskUuidEntity that = (SshhwwTaskUuidEntity) o;

        if (id != that.id) return false;
        if (taskName != null ? !taskName.equals(that.taskName) : that.taskName != null) return false;
        if (uuid != null ? !uuid.equals(that.uuid) : that.uuid != null) return false;
        if (value != null ? !value.equals(that.value) : that.value != null) return false;
        if (valid != null ? !valid.equals(that.valid) : that.valid != null) return false;
        if (isGlobal != null ? !isGlobal.equals(that.isGlobal) : that.isGlobal != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (taskName != null ? taskName.hashCode() : 0);
        result = 31 * result + (uuid != null ? uuid.hashCode() : 0);
        result = 31 * result + (value != null ? value.hashCode() : 0);
        result = 31 * result + (valid != null ? valid.hashCode() : 0);
        result = 31 * result + (isGlobal != null ? isGlobal.hashCode() : 0);
        return result;
    }
}
