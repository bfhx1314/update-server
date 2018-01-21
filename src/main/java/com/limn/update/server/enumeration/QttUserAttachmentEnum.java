package com.limn.update.server.enumeration;

public enum  QttUserAttachmentEnum {

    CACHE("缓存","CACHE");

    private String name;
    private String code;

    private QttUserAttachmentEnum(String name , String code){
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
