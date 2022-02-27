 package com.example.learnandroid.fragments.fragmentsimpletransication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.example.learnandroid.databinding.ActivityWelcomeHomeBinding;
public class WelcomeHome extends AppCompatActivity {

    public static void start(Context context)
    {
        Intent intent = new Intent(context, WelcomeHome.class);

        context.startActivity(intent);
    }

    ActivityWelcomeHomeBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityWelcomeHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        SharedPreferences sharedPreferences = getSharedPreferences("USER_CREDENTIALS",MODE_PRIVATE);
       String display = sharedPreferences.getString("userid","");
       String display1 = sharedPreferences.getString("password","");

           binding.displayuserId.setText(display);
           binding.displayPassword.setText(display1);
       }





    }
