package com.limn.update.server.bean.ele;

import java.util.List;

/**
 * Created by limengnan on 2017/11/10.
 */
public class EleShopPiecewiseAgentFee {
    String description;
    int extra_fee;
    boolean is_extra;
    List<Rule> rules;
    String tips;

    public int getExtra_fee() {
        return extra_fee;
    }

    public void setExtra_fee(int extra_fee) {
        this.extra_fee = extra_fee;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean is_extra() {
        return is_extra;
    }

    public void setIs_extra(boolean is_extra) {
        this.is_extra = is_extra;
    }

    public List<Rule> getRules() {
        return rules;
    }

    public void setRules(List<Rule> rules) {
        this.rules = rules;
    }

    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips;
    }
}
