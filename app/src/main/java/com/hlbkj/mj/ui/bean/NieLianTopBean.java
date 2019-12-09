package com.hlbkj.mj.ui.bean;

import java.io.Serializable;

/**
 * Created by EDZ on 2019/12/6.
 */

public class NieLianTopBean implements Serializable{
    private int id;
    private String ImageSeleteUrl;
    private String ImageUnSeleteUrl;
    private int iconSelUrl;
    private int iconUnSelUrl;
    private boolean isChecked;
    private boolean isNewGood;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImageSeleteUrl() {
        return ImageSeleteUrl;
    }

    public void setImageSeleteUrl(String imageSeleteUrl) {
        ImageSeleteUrl = imageSeleteUrl;
    }

    public String getImageUnSeleteUrl() {
        return ImageUnSeleteUrl;
    }

    public void setImageUnSeleteUrl(String imageUnSeleteUrl) {
        ImageUnSeleteUrl = imageUnSeleteUrl;
    }

    public int getIconSelUrl() {
        return iconSelUrl;
    }

    public void setIconSelUrl(int iconSelUrl) {
        this.iconSelUrl = iconSelUrl;
    }

    public int getIconUnSelUrl() {
        return iconUnSelUrl;
    }

    public void setIconUnSelUrl(int iconUnSelUrl) {
        this.iconUnSelUrl = iconUnSelUrl;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public boolean isNewGood() {
        return isNewGood;
    }

    public void setNewGood(boolean newGood) {
        isNewGood = newGood;
    }
}
