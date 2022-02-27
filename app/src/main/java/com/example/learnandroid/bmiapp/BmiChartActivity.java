package com.example.learnandroid.bmiapp;


import android.os.Bundle;

import com.example.learnandroid.databinding.ActivityBmiChartBinding;

public class BmiChartActivity extends BaseActivity {

private ActivityBmiChartBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBmiChartBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        BmiChartActivity.this.setTitle("BmiChartActivity");


    }


}
