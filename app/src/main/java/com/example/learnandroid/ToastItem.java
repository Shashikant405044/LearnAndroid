package com.example.learnandroid;


import android.os.Bundle;
import android.view.View;

import com.example.learnandroid.databinding.ActivityToastBinding;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
public class ToastItem extends BaseActivity implements View.OnClickListener {
    private ActivityToastBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityToastBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ToastItem.this.setTitle("ToastItem");

        binding.normalDiolog.setOnClickListener(this);
        binding.customeToast.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {


        switch (view.getId())
        {


            case   R.id.custome_toast:
                customeToast("You Click On No");

                break;
        }
    }
}