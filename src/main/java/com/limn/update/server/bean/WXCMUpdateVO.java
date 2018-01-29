package com.limn.update.server.bean;

/**
 * Created by limengnan on 2018/1/25.
 */
public class WXCMUpdateVO extends ResponseVo{

    int version;
    String updateFilePath;

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getUpdateFilePath() {
        return updateFilePath;
    }

    public void setUpdateFilePath(String updateFilePath) {
        this.updateFilePath = updateFilePath;
    }
}
