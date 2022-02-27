package com.example.learnandroid.fragments.fragmentsimpletransication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.learnandroid.R;
import com.example.learnandroid.databinding.FragmentSignUpFramentBinding;

public class SignUpFrament extends Fragment {

   FragmentSignUpFramentBinding binding;
    SharedPreferences.Editor editor;
    SharedPreferences sharedPreferences;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSignUpFramentBinding.inflate(inflater,container, false);

        sharedPreferences  = getActivity().getSharedPreferences("MyPreference", Context.MODE_PRIVATE);


        binding.registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate();

            }
        });

//        binding.back.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                Intent intent1 = new Intent(getContext(),LoginFragment.class);
//                getActivity().startActivity(intent1);
//            }
//        });
        return binding.getRoot();
    }




    private void validate() {

        String UserId = binding.userid.getText().toString();
        String password = binding.passwordInput.getText().toString();
        String confirmPassword = binding.passwordConfirm.getText().toString();

        if (!TextUtils.isEmpty(UserId) && !TextUtils.isEmpty(password) && !TextUtils.isEmpty(confirmPassword))
        {
            if (UserId.contains(""))
            {
                if (password.equals(confirmPassword))
                {
                    startRagistration(UserId,password,confirmPassword);
                }
                else 
                {
                    Toast.makeText(getActivity(),getString(R.string.mish_match), Toast.LENGTH_SHORT).show();
                }
            }
        }



    }


    private void startRagistration(String userId, String password, String confirmPassword) {

        sharedPreferences = this.getActivity().getSharedPreferences
                ("USER_CREDENTIALS",Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.putString("userid",userId);
        editor.putString("password",password);
        editor.putBoolean("ISLOGGEDIN",true);
        editor.apply();

        //startHomeActivity();
        Toast.makeText(getContext(), "Account Created Successful", Toast.LENGTH_SHORT).show();



    }
//    private void startHomeActivity() {
//        WelcomeHome.start(getActivity());
//        getActivity().finish();
//    }
}