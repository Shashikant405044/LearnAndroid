package com.example.learnandroid.fragments.fTofcommnication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.learnandroid.R;
import com.example.learnandroid.databinding.ActivityFtfmainBinding;
import com.example.learnandroid.fragments.ftoactivity.FragmentSender;
import com.example.learnandroid.interfaceclass.OnInputListener;

public class FTFMainActivity extends AppCompatActivity implements OnInputListener {

    FragmentManager fragmentManager;
    private  ActivityFtfmainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityFtfmainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.ftfContainer, new FsendData());
        ft.commit();
    }

    @Override
    public void input(String inputString) {

        FragmentReceiver fragment = new  FragmentReceiver();

        Bundle bundle = new Bundle();
        bundle.putString("input", inputString);
        fragment.setArguments(bundle);
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.ftfContainer, fragment);
        fragmentTransaction.commit();


    }

    private void replacedata() {
//        FragmentReceiver fragment = new  FragmentReceiver();
//
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        fragmentTransaction.replace(R.id.ftfContainer, fragment);
//        fragmentTransaction.commit();
    }

    @Override
    public void input2(String two) {
//        FragmentReceiver fragment = new  FragmentReceiver();
//
//        replacedata();
//        Bundle bundle = new Bundle();
//        bundle.putString("edu", two);
//        fragment.setArguments(bundle);
//        replacedata();
    }

    @Override
    public void input3(String three) {


    }
}