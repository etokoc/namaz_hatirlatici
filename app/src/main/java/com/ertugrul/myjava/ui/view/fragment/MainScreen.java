package com.ertugrul.myjava.ui.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.ertugrul.myjava.R;
import com.ertugrul.myjava.databinding.FragmentMainScreenBinding;
import com.ertugrul.myjava.ui.viewmodel.MainScreenViewModel;

public class MainScreen extends Fragment {

    private MainScreenViewModel mViewModel;
    private FragmentMainScreenBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentMainScreenBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(MainScreenViewModel.class);
    }

    @Override
    public void onResume() {
        super.onResume();
        initListener();
        initUI();
    }

    private void initUI() {
        //Günün adını doldurma
        String todayName = String.format(getResources().getString(R.string.today_header), mViewModel.getTodayName());
        binding.txtTodayTitle.setText(todayName);

        String date = String.format(getResources().getString(R.string.today_date), mViewModel.getDate(), mViewModel.getHijraDate());
        binding.txtDate.setText(date);
    }

    private void initListener() {
    }
}