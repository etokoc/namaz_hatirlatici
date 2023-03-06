package com.ertugrul.myjava.data.repository;

import com.ertugrul.myjava.data.api.ApiService;
import com.ertugrul.myjava.data.model.LocalEzanRootItem;

import java.util.ArrayList;

import retrofit2.Call;


public class MainRepository {
    /**
     * Select Region with CountryName
     *
     * @param apiService
     */
    public Call<ArrayList<String>> getRegions(ApiService apiService) {
        Call<ArrayList<String>> observable = apiService.getCountryCitys();
        return observable;
    }

    public Call<LocalEzanRootItem> getTimesFromCoordinates(String lat, String lng, String date, String days, String timezone, ApiService apiService) {
        Call<LocalEzanRootItem> call = apiService.getTimesFromCoordinates(lat, lng, date, days, timezone);
        return call;
    }
}
