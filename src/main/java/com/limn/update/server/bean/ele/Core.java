package com.limn.update.server.bean.ele;

/**
 * Created by limengnan on 2017/11/13.
 */
public class Core {

    String index;
    Target target;
    String come_from;
    Next next;
    Object extraInfo;

    public Object getExtraInfo() {
        return extraInfo;
    }

    public void setExtraInfo(Object extraInfo) {
        this.extraInfo = extraInfo;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public Target getTarget() {
        return target;
    }

    public void setTarget(Target target) {
        this.target = target;
    }

    public String getCome_from() {
        return come_from;
    }

    public void setCome_from(String come_from) {
        this.come_from = come_from;
    }

    public Next getNext() {
        return next;
    }

    public void setNext(Next next) {
        this.next = next;
    }
}
