package com.ertugrul.myjava.data.api;

import com.ertugrul.myjava.data.model.LocalEzanRootItem;
import com.ertugrul.myjava.utils.Constants;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET(Constants.GET_REGION + "Germany")
    Call<ArrayList<String>> getCountryCitys();

    @GET("timesFromCoordinates")
    Call<LocalEzanRootItem> getTimesFromCoordinates(@Query("lat") String lat, @Query("lng") String lng, @Query("date") String date, @Query("days") String days, @Query("timezoneOffset") String timeZone);
}
