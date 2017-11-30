package com.limn.update.server.bean.ele;

import java.util.List;

/**
 * Created by limengnan on 2017/11/17.
 */
public class Attr {

    String name;
    List<String> values;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getValues() {
        return values;
    }

    public void setValues(List<String> values) {
        this.values = values;
    }
}
