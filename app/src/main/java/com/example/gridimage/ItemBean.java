package com.example.gridimage;

import android.widget.TextView;

public class ItemBean {

    public String title;
    public String explain;
    public String path;
    public String faraway;

    /**
     * @param title   标题
     * @param explain 说明
     * @param path    图片路径
     * @param faraway 距离
     */
    public ItemBean(String title, String explain, String path, String faraway) {
        this.title = title;
        this.explain = explain;
        this.path = path;
        this.faraway = faraway;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getFaraway() {
        return faraway;
    }

    public void setFaraway(String faraway) {
        this.faraway = faraway;
    }
}
