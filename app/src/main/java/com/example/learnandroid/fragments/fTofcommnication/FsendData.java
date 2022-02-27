package com.example.learnandroid.fragments.fTofcommnication;

import static android.content.ContentValues.TAG;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.learnandroid.databinding.FragmentFsendDataBinding;
import com.example.learnandroid.interfaceclass.OnInputListener;

public class FsendData extends Fragment {

    FragmentFsendDataBinding binding;

    OnInputListener listener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFsendDataBinding.inflate(inflater,container,false);

        binding.sendF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (listener != null)
                {
                    listener.input(binding.etNameSend.getEditText().getText().toString());
                   // listener.input2(binding.etEducationSend.getEditText().getText().toString());

                }

                else
                {
                    Toast.makeText(getContext(), "Something Wrong ", Toast.LENGTH_SHORT).show();
                }

            }
        });
        return binding.getRoot();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Activity activity = (Activity) context;
        listener = (OnInputListener) activity;
    }
}