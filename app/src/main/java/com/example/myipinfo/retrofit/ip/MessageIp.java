package com.example.myipinfo.retrofit.ip;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Alexandr Mikhalev on 11.05.2019.
 *
 * @author Alexandr Mikhalev
 */
public class MessageIp {
    @SerializedName("ip")
    private String mCode;

    public String getCode() {
        return mCode;
    }

    public void setCode(String code) {
        mCode = code;
    }
}
