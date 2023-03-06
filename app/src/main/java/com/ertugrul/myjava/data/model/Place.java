package com.ertugrul.myjava.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.Map;

public class Place {

    @SerializedName("countryCode")
    public String countryCode;
    @SerializedName("country")
    public String country;
    @SerializedName("region")
    public String region;
    @SerializedName("city")
    public String city;
    @SerializedName("latitude")
    public double latitude;
    @SerializedName("longitude")
    public double longitude;



}
