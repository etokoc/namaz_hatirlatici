package com.ertugrul.myjava.ui.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.ertugrul.myjava.data.api.ApiService;
import com.ertugrul.myjava.data.model.LocalEzanRootItem;
import com.ertugrul.myjava.data.repository.MainRepository;
import com.ertugrul.myjava.utils.Extentions;

import java.util.ArrayList;
import java.util.Date;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class MainViewModel extends androidx.lifecycle.ViewModel {


    private MutableLiveData<ArrayList<String>> mutableLiveData = new MutableLiveData<>();
    private final LiveData<ArrayList<String>> _liveData = mutableLiveData;

    private MutableLiveData<LocalEzanRootItem> mutableLiveData_LocalEzanTime = new MutableLiveData<>();
    private final LiveData<LocalEzanRootItem> _liveData_LocalEzanTime = mutableLiveData_LocalEzanTime;
    MainRepository mainRepository;

    @Inject
    public MainViewModel() {
        mainRepository = new MainRepository();
    }

    @Inject
    ApiService apiService;

    public void getRegions() {
        mainRepository.getRegions(apiService, mutableLiveData);
    }

    public LiveData<ArrayList<String>> getRegionsLiveData() {
        return _liveData;
    }

    public LiveData<LocalEzanRootItem> getTimesFromCoordinates(String lat, String lng, String date, String days, String timezone) {
        mainRepository.getTimesFromCoordinates(lat, lng, date, days, timezone, apiService, mutableLiveData_LocalEzanTime);
        return _liveData_LocalEzanTime;
    }



}
