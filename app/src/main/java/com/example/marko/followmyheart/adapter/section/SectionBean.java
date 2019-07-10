package com.example.marko.followmyheart.adapter.section;

public class SectionBean {
    private int iv_icon;
    private String tv_icon;

    public SectionBean(int iv_icon, String tv_icon) {
        this.iv_icon = iv_icon;
        this.tv_icon = tv_icon;
    }

    public int getIv_icon() {
        return iv_icon;
    }

    public String getTv_icon() {
        return tv_icon;
    }

    public void setIv_icon(int iv_icon) {
        this.iv_icon = iv_icon;
    }

    public void setTv_icon(String tv_icon) {
        this.tv_icon = tv_icon;
    }
}
