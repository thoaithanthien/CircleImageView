package com.example.circleimageview;

import java.io.Serializable;

public class User implements Serializable {
    private int imgID;
    private String name;

    public int getImgID() {
        return imgID;
    }

    public void setImgID(int imgID) {
        this.imgID = imgID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User(int imgID, String name) {
        this.imgID = imgID;
        this.name = name;
    }
}
