package com.limn.update.server.bean.ele;

/**
 * Created by limengnan on 2017/11/10.
 */
public class EleShopRecommend {
    boolean is_ad;
    String reason;
    String track;

    public String getTrack() {
        return track;
    }

    public void setTrack(String track) {
        this.track = track;
    }

    public boolean is_ad() {
        return is_ad;
    }

    public void setIs_ad(boolean is_ad) {
        this.is_ad = is_ad;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
