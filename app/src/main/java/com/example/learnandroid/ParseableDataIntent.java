package com.example.learnandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.learnandroid.databinding.ActivityParseableDataIntentBinding;

public class ParseableDataIntent extends AppCompatActivity {

    ActivityParseableDataIntentBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityParseableDataIntentBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());
    }
}