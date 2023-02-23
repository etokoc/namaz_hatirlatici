package com.ertugrul.myjava.data.repository;

import androidx.lifecycle.MutableLiveData;

import com.ertugrul.myjava.data.api.ApiService;
import com.ertugrul.myjava.data.model.LocalEzanRootItem;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainRepository {
    /**
     * Select Region with CountryName
     *
     * @param apiService
     * @param mutableLiveData
     */
    public void getRegions(ApiService apiService, MutableLiveData<ArrayList<String>> mutableLiveData) {
        Call<ArrayList<String>> observable = apiService.getCountryCitys();
        observable.enqueue(new Callback<ArrayList<String>>() {
            @Override
            public void onResponse(Call<ArrayList<String>> call, Response<ArrayList<String>> response) {
                mutableLiveData.postValue(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<String>> call, Throwable t) {

            }
        });
    }

    public void getTimesFromCoordinates(String lat, String lng, String date, String days, String timezone, ApiService apiService, MutableLiveData<LocalEzanRootItem> mutableLiveData) {
        Call<LocalEzanRootItem> call = apiService.getTimesFromCoordinates(lat, lng, date, days, timezone);
        call.enqueue(new Callback<LocalEzanRootItem>() {
            @Override
            public void onResponse(Call<LocalEzanRootItem> call, Response<LocalEzanRootItem> response) {
                mutableLiveData.postValue(response.body());
            }

            @Override
            public void onFailure(Call<LocalEzanRootItem> call, Throwable t) {

            }
        });
    }
}
