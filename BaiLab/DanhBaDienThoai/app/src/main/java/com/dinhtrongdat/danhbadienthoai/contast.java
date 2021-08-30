package com.dinhtrongdat.danhbadienthoai;

import java.util.PrimitiveIterator;

public class contast {
    private String mName;
    private String mNumPhone;
    private String mAvatar;

    public contast(String mName, String mNumPhone, String mAvatar) {
        this.mName = mName;
        this.mNumPhone = mNumPhone;
        this.mAvatar = mAvatar;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmNumPhone() {
        return mNumPhone;
    }

    public void setmNumPhone(String mNumPhone) {
        this.mNumPhone = mNumPhone;
    }

    public String getmAvatar() {
        return mAvatar;
    }

    public void setmAvatar(String mAvatar) {
        this.mAvatar = mAvatar;
    }
}
