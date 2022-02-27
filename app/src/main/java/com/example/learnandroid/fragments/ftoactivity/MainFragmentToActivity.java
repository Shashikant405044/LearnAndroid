package com.example.learnandroid.fragments.ftoactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.learnandroid.R;
import com.example.learnandroid.databinding.ActivityMainFragmentToBinding;
import com.example.learnandroid.interfaceclass.OnInputListener;

public class MainFragmentToActivity extends AppCompatActivity implements OnInputListener  {

 private  ActivityMainFragmentToBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainFragmentToBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.layoutcontainer, new FragmentSender());
        ft.commit();


    }

    @Override
    public void input(String inputString) {

        binding.name.setText(inputString);


    }

    @Override
    public void input2(String two) {
      binding.profile.setText(two);


    }



    @Override
    public void input3(String three) {
    binding.education.setText(three);



    }




}