package com.ertugrul.myjava.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.Map;

public class LocalEzanRootItem {

        @SerializedName("place")
        public Place place;

        @SerializedName("times")
        public Map<String, String[]> getTimes;

}
