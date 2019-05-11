package com.example.myipinfo.retrofit.detailedinfo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Alexandr Mikhalev on 12.05.2019.
 *
 * @author Alexandr Mikhalev
 */
public class MessageDetailed {

    @SerializedName("city")
    private String city;

    @SerializedName("country")
    private String country;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
