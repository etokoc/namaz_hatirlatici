package com.ertugrul.myjava.ui.view.fragment;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ertugrul.myjava.R;
import com.ertugrul.myjava.ui.viewmodel.KabaaViewModel;

public class KabaaFragment extends Fragment {

    private KabaaViewModel mViewModel;

    public static KabaaFragment newInstance() {
        return new KabaaFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_kabaa, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(KabaaViewModel.class);
        // TODO: Use the ViewModel
    }

}