package com.limn.update.server.entity;

import javax.persistence.*;

/**
 * Created by limengnan on 2018/1/25.
 */
@Entity
@Table(name = "wxcm_update", schema = "ele", catalog = "")
public class WXCMUpdateEntity {
    private int id;
    private int version;
    private String updatePath;
    private String valid;
    private String type;
    private String md5;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    @Column(name = "updatePath", nullable = false, length = 300)
    public String getUpdatePath() {
        return updatePath;
    }

    public void setUpdatePath(String updatePath) {
        this.updatePath = updatePath;
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
    @Column(name = "type", nullable = false, length = 255)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "md5", nullable = false, length = 32)
    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WXCMUpdateEntity that = (WXCMUpdateEntity) o;

        if (id != that.id) return false;
        if (version != that.version) return false;
        if (updatePath != null ? !updatePath.equals(that.updatePath) : that.updatePath != null) return false;
        if (valid != null ? !valid.equals(that.valid) : that.valid != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (md5 != null ? !md5.equals(that.md5) : that.md5 != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + version;
        result = 31 * result + (updatePath != null ? updatePath.hashCode() : 0);
        result = 31 * result + (valid != null ? valid.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (md5 != null ? md5.hashCode() : 0);
        return result;
    }
}
