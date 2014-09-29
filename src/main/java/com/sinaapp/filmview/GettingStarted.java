package com.sinaapp.filmview;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Author: fanshen.fs
 * version:1.0  14-9-22
 */
public class GettingStarted extends ActionSupport {

    private String myName;
    private String baby;

    public String getMyName() {
        return myName;
    }

    public void setMyName(String myName) {
        this.myName = myName;
    }

    public String hello() {
        baby = "T";
        return "success";
    }

    public String execute() {
        return SUCCESS;
    }
}
