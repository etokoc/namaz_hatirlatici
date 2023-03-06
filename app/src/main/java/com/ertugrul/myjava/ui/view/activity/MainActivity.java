package com.ertugrul.myjava.ui.view.activity;

import static androidx.navigation.Navigation.findNavController;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.ui.NavigationUI;

import com.ertugrul.myjava.data.model.LocalEzanRootItem;
import com.ertugrul.myjava.databinding.ActivityMainBinding;
import com.ertugrul.myjava.ui.viewmodel.MainViewModel;
import com.ertugrul.myjava.utils.NetworkResult;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

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

        mainViewModel.getTimesFromCoordinates("39.91987", "32.85427", "2023-10-29", "3", "180").observe(this, new Observer<NetworkResult<LocalEzanRootItem>>() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onChanged(NetworkResult<LocalEzanRootItem> localEzanRootItemNetworkResult) {
                Toast.makeText(MainActivity.this, "in", Toast.LENGTH_SHORT).show();
                if (localEzanRootItemNetworkResult instanceof NetworkResult.Success<LocalEzanRootItem>) {
                    LocalEzanRootItem data = localEzanRootItemNetworkResult.get_data();
                    ArrayList<String> keys = new ArrayList<>(data.getTimes.keySet());
                    String result = Arrays.stream(Objects.requireNonNull(data.getTimes.get(keys.get(0)))).iterator().next();
                    Log.e("ETOLOG", "onChanged: " + result);
                } else if (localEzanRootItemNetworkResult instanceof NetworkResult.Error<LocalEzanRootItem>) {

                } else if (localEzanRootItemNetworkResult instanceof NetworkResult.Loading) {

                }
            }
        });
    }
}