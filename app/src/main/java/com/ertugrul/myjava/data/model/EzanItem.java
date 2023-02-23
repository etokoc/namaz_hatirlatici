package com.ertugrul.myjava.data.model;

public class EzanItem {
    public String getEzanName() {
        return ezanName;
    }

    public void setEzanName(String ezanName) {
        this.ezanName = ezanName;
    }

    public String getEzanStartTime() {
        return ezanStartTime;
    }

    public void setEzanStartTime(String ezanStartTime) {
        this.ezanStartTime = ezanStartTime;
    }

    public String getEzanEndTime() {
        return ezanEndTime;
    }

    public void setEzanEndTime(String ezanEndTime) {
        this.ezanEndTime = ezanEndTime;
    }

    private String ezanName;
    private String ezanStartTime;
    private String ezanEndTime;
}
