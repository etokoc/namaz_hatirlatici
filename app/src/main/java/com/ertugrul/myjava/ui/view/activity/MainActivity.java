package com.ertugrul.myjava.ui.view.activity;

import static androidx.navigation.Navigation.findNavController;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.ui.NavigationUI;

import com.ertugrul.myjava.databinding.ActivityMainBinding;
import com.ertugrul.myjava.ui.viewmodel.MainViewModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this));
        setContentView(binding.getRoot());
    }

    @Override
    protected void onResume() {
        super.onResume();
        initBottomNavigation();
        initViewModel();
        initListeners();
    }

    private void initBottomNavigation() {
        View container = binding.container;
        BottomNavigationView bottomNavigationView = binding.bottomNav;
        NavController navController = findNavController(container);
        NavigationUI.setupWithNavController(bottomNavigationView, navController);
    }


    private void initViewModel() {
        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);
    }

    private void initListeners() {
        //        mainViewModel.getRegions();
//        mainViewModel.getRegionsLiveData().observe(this, strings -> binding.textview.setText(strings.get(0)));
//        mainViewModel.getTimesFromCoordinates("39.91987", "32.85427", "2023-10-29", "3", "180")
//                .observe(this, items -> Toast.makeText(this, items.times.time1.get(0), Toast.LENGTH_SHORT).show());
    }
}