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

    @SerializedName("longitude")
    private String longitude;

    @SerializedName("latitude")
    private String latitude;

    @SerializedName("country_name")
    private String countryName;

    @SerializedName("postal")
    private String postCode;

    @SerializedName("org")
    private String orgInfo;

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

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getOrgInfo() {
        return orgInfo;
    }

    public void setOrgInfo(String orgInfo) {
        this.orgInfo = orgInfo;
    }
}
