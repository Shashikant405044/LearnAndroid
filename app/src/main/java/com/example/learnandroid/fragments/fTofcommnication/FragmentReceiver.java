package com.example.learnandroid.fragments.fTofcommnication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.learnandroid.R;
import com.example.learnandroid.databinding.FragmentRecieverBinding;

public class FragmentReceiver extends Fragment {

  private FragmentRecieverBinding binding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentRecieverBinding.inflate(inflater,container,false);
        Bundle bundle = getArguments();
        binding.name.setText(bundle.getString("input"));

      return   binding.getRoot();

    }

}