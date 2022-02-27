package com.example.learnandroid.fragments.ftoactivity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.learnandroid.R;
import com.example.learnandroid.databinding.FirstFragmentBinding;
import com.example.learnandroid.interfaceclass.OnInputListener;


public class FragmentSender extends Fragment {

    private FirstFragmentBinding binding;
    OnInputListener listener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FirstFragmentBinding.inflate(inflater, container, false);
        binding.send.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               listener.input(binding.etName.getEditText().getText().toString());
               listener.input2(binding.etProfile.getEditText().getText().toString());
               listener.input3(binding.etEducation.getEditText().getText().toString());



           }
       });
        return  binding.getRoot();

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        Activity activity = (Activity) context;
        listener = (OnInputListener) activity;
    }

}