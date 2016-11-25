package com.jc.rxjava_custom;

/**
 * Created by ivyxjc on on 2016/11/25.
 * This work is licensed under a Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International License.
 */

public class Contributor {
    private String ddd;
    private int id;
    private int contributions;
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Contributor(String ddd, int id, int contributions) {
        this.ddd = ddd;
        this.id = id;
        this.contributions = contributions;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getContributions() {
        return contributions;
    }

    public void setContributions(int contributions) {
        this.contributions = contributions;
    }
}