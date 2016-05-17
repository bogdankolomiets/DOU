package com.example.bogdan.dou.model.data;

import android.graphics.drawable.Drawable;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 29.04.2016
 */
public class Company {
    private String mName;
    private String mUrl;
    private int mImageId;

    public Company(String name, String url, int imageId) {
        mName = name;
        mUrl = url;
        mImageId = imageId;
    }

    public String getName() {
        return mName;
    }

    public String getUrl() {
        return mUrl;
    }

    public int getmImageId() {
        return mImageId;
    }
}
