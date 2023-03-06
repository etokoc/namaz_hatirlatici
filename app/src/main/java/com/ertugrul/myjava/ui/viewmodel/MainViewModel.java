package com.ertugrul.myjava.ui.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.ertugrul.myjava.data.api.ApiService;
import com.ertugrul.myjava.data.model.LocalEzanRootItem;
import com.ertugrul.myjava.data.repository.MainRepository;
import com.ertugrul.myjava.utils.NetworkResult;

import java.util.ArrayList;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@HiltViewModel
public class MainViewModel extends androidx.lifecycle.ViewModel {


    private MutableLiveData<NetworkResult<ArrayList<String>>> _getRegionsMutableLiveData = new MutableLiveData<>();
    private final LiveData<NetworkResult<ArrayList<String>>> getRegionsMutableLiveData = _getRegionsMutableLiveData;

    private MutableLiveData<NetworkResult<LocalEzanRootItem>> mutableLiveData_LocalEzanTime = new MutableLiveData<>();
    private final LiveData<NetworkResult<LocalEzanRootItem>> _liveData_LocalEzanTime = mutableLiveData_LocalEzanTime;
    MainRepository mainRepository;

    @Inject
    public MainViewModel() {
        mainRepository = new MainRepository();
    }

    @Inject
    ApiService apiService;

    public LiveData<NetworkResult<ArrayList<String>>> getRegions() {
        _getRegionsMutableLiveData.postValue(new NetworkResult.Loading<>());
        mainRepository.getRegions(apiService).enqueue(new Callback<ArrayList<String>>() {
            @Override
            public void onResponse(Call<ArrayList<String>> call, Response<ArrayList<String>> response) {
                _getRegionsMutableLiveData.postValue(new NetworkResult.Success<>(response.body()));
            }

            @Override
            public void onFailure(Call<ArrayList<String>> call, Throwable t) {
                _getRegionsMutableLiveData.postValue(new NetworkResult.Error<>(t.getLocalizedMessage()));
            }
        });
        return getRegionsMutableLiveData;
    }

    public LiveData<NetworkResult<LocalEzanRootItem>> getTimesFromCoordinates(String lat, String lng, String date, String days, String timezone) {
        mainRepository.getTimesFromCoordinates(lat, lng, date, days, timezone, apiService).enqueue(new Callback<LocalEzanRootItem>() {
            @Override
            public void onResponse(Call<LocalEzanRootItem> call, Response<LocalEzanRootItem> response) {
                mutableLiveData_LocalEzanTime.postValue(new NetworkResult.Success<>(response.body()));
            }

            @Override
            public void onFailure(Call<LocalEzanRootItem> call, Throwable t) {
                mutableLiveData_LocalEzanTime.postValue(new NetworkResult.Error<>(t.getLocalizedMessage()));
            }
        });
        return _liveData_LocalEzanTime;
    }


}
