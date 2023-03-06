package com.ertugrul.myjava.ui.viewmodel;

import androidx.lifecycle.ViewModel;

import com.ertugrul.myjava.utils.Extentions;

import java.util.Date;

public class MainScreenViewModel extends ViewModel {
    public String getTodayName() {
        return Extentions.getDateWithIndex();
    }

    public String getDate() {
        return Extentions.getDate();


    }

    public String getHijraDate() {
        return Extentions.getHijraDate();
    }

    public String getHour() {
        return Extentions.getHour();
    }
}

