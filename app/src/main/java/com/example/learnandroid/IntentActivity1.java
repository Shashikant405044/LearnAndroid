package com.example.learnandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.learnandroid.databinding.ActivityIntent1Binding;


public class IntentActivity1 extends AppCompatActivity {

    private ActivityIntent1Binding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityIntent1Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        IntentActivity1.this.setTitle("IntentActivity1");
        binding.firstActicityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(IntentActivity1.this,IntentActivity2.class);
                startActivity(intent);
            }
        });
    }
}