package com.limn.update.server.bean;

import com.limn.tool.common.DateFormat;
import com.limn.update.server.common.BaseUtil;

public class FileServerVo extends ResponseVo implements Comparable<FileServerVo>{

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

    @Override
    public int compareTo(FileServerVo o) {

        if(this.getType().equalsIgnoreCase("Folder")) {
            return-1;
        }else if(o.getType().equalsIgnoreCase("Folder")){
            return 1;
        }else{
            if(BaseUtil.isEmpty(this.getLastModfiyTime()) || BaseUtil.isEmpty(o.getLastModfiyTime())){
                return 1;
            }
            if(DateFormat.getData("yyyy/MM/dd HH:mm:ss",this.getLastModfiyTime()).getTime() < DateFormat.getData("yyyy/MM/dd HH:mm:ss", o.getLastModfiyTime()).getTime()){
                return 1;
            }else{
                return -1;
            }
        }
    }


}
