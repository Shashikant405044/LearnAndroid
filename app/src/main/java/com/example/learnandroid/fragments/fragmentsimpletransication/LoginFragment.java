package com.example.learnandroid.fragments.fragmentsimpletransication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.learnandroid.R;
import com.example.learnandroid.databinding.FragmentLoginBinding;


public class LoginFragment extends Fragment {

    FragmentLoginBinding binding;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentLoginBinding.inflate(inflater,container,false);


        sharedPreferences = this.getActivity().getSharedPreferences("USER_CREDENTIALS",Context.MODE_PRIVATE);
        final boolean isLoggedin = sharedPreferences.getBoolean("ISLOGGEDIN",false);

        final  String userName = sharedPreferences.getString("userid", "");
        final  String password = sharedPreferences.getString("password","");

        binding.loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                validation(userName,password);

               // startHomeActivity();
            }
        });





//        binding.loginButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String user = binding.checkUserId.getText().toString();
//                String pass = binding.checkPassword.getText().toString();
//
//                sharedPreferences = getActivity().getSharedPreferences("MyPreference", Context.MODE_PRIVATE);
//                String userDetails = sharedPreferences.getString(user+"userid", "");
//                String password = sharedPreferences.getString(pass+"password", "");
//                if (userDetails != null && password != null )
//                {
//                    editor.putString("userName",userDetails);
//                    editor.putString("passName",password);
//                    Log.d("fffffffff: ",userDetails);
//                    Intent intent = new Intent(getContext(), WelcomeHome.class);
//                    getActivity().startActivity(intent);
//                }
//                else {
//                    Toast.makeText(getContext(), "Invalid Account", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });

        return  binding.getRoot();

    }


    private void validation(String userName, String password) {
        String user_in = binding.checkUserId.getText().toString();
        String pass_word =binding.checkPassword.getText().toString();

        if (!TextUtils.isEmpty(user_in) && !TextUtils.isEmpty(pass_word)) {

            if (user_in.contains("")) {

                isUserLogin(user_in,pass_word,userName,password);
            } else {

            }

        } else {

            Toast.makeText(getActivity(), "Please Check Youer user id ", Toast.LENGTH_SHORT).show();
            }
        }

    private void isUserLogin(String user_in, String pass_word, String userName, String password) {

        if (user_in.equals(userName) && pass_word.equals(password))
        {
            sharedPreferences.edit().putBoolean("ISLOGGEDIN",false).apply();
             startHomeActivity();

        }
        else {
            Toast.makeText(getActivity(), "UserIs Address  Password Incorrect", Toast.LENGTH_SHORT).show();
        }
    }

    private void startHomeActivity() {

        Fragment fr = new MainPage();
        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.framLayout, fr);
        fragmentTransaction.commit();

    }


}
