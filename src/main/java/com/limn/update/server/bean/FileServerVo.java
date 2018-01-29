package com.limn.update.server.bean;

public class FileServerVo extends ResponseVo{

    String fileName;
    String filePath;
    String md5;
    String type;
    String size;
    String lastModfiyTime;

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getLastModfiyTime() {
        return lastModfiyTime;
    }

    public void setLastModfiyTime(String lastModfiyTime) {
        this.lastModfiyTime = lastModfiyTime;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
