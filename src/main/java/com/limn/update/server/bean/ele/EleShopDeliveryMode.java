package com.limn.update.server.bean.ele;

/**
 * Created by limengnan on 2017/11/13.
 */
public class EleShopDeliveryMode {
    String border;
    String color;
    String id;
    String is_solid;
    String text;
    String text_color;
    Gradient gradient;

    public String getBorder() {
        return border;
    }

    public void setBorder(String border) {
        this.border = border;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIs_solid() {
        return is_solid;
    }

    public void setIs_solid(String is_solid) {
        this.is_solid = is_solid;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText_color() {
        return text_color;
    }

    public void setText_color(String text_color) {
        this.text_color = text_color;
    }

    public Gradient getGradient() {
        return gradient;
    }

    public void setGradient(Gradient gradient) {
        this.gradient = gradient;
    }
}

