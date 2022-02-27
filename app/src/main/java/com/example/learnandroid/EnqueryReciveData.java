package com.example.learnandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.learnandroid.databinding.ActivityEnqueryFormBinding;
import com.example.learnandroid.databinding.ActivityEnqueryReciveDataBinding;

public class EnqueryReciveData extends AppCompatActivity {

    private ActivityEnqueryReciveDataBinding binding;

    String item1 = "";
    String item2 = "";
    String item3 = "";
    String item4 = "";
    String item5 = "";
    String item6 = "";
    String item7 = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEnqueryReciveDataBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());
        EnqueryReciveData.this.setTitle("EnqueryReciveData");
        Intent intent = getIntent();

        String fname  = intent.getStringExtra("fname");
        String lname = intent.getStringExtra("lname");
        String email = intent.getStringExtra("email");
        String phone = intent.getStringExtra("phoneno");
        String gender = intent.getStringExtra("gender");
        item1 = intent.getStringExtra("item1");
        item2 = intent.getStringExtra("item2");
         item3 = intent.getStringExtra("item3");
        item4 = intent.getStringExtra("item4");
         item5 = intent.getStringExtra("item5");
         item6 = intent.getStringExtra("item6");
         item7 = intent.getStringExtra("item7");



        binding.FNameText.setText(fname);
        binding.LNameText.setText(lname);
        binding.EmailText.setText(email);
        binding.phoneText.setText(phone);
        binding.genderText.setText(gender);
        binding.CourseText.setText(item1+" , "+item2+" , "+item3+" , "+item4+" , "+item5+",  "+item6+" , "+item7);

    }
}