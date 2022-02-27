package com.example.learnandroid.fragments.fragmentsimpletransication;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.learnandroid.R;
import com.example.learnandroid.databinding.FragmentMainPageBinding;

public class MainPage extends Fragment {

    FragmentMainPageBinding binding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
          binding = FragmentMainPageBinding.inflate(inflater,container,false);

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("USER_CREDENTIALS",Context.MODE_PRIVATE);
        String display = sharedPreferences.getString("userid","");
        String display1 = sharedPreferences.getString("password","");

        binding.userName.setText(display);
      //  binding.displayPassword.setText(display1);

        return binding.getRoot();

    }













    public static void start(Context context)
    {
        Intent intent = new Intent(context, MainPage.class);

        context.startActivity(intent);

    }

}