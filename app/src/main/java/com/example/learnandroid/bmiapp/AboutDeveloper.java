package com.example.learnandroid.bmiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.learnandroid.MainActivity;
import com.example.learnandroid.R;

public class AboutDeveloper extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_developer);
        AboutDeveloper.this.setTitle(" AboutDeveloper ");

    }


}