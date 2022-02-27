package com.example.learnandroid.fragments.fragmentsimpletransication;

import static android.view.View.GONE;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.learnandroid.R;
public class FragmentParentActivity extends AppCompatActivity implements View.OnClickListener {
    TextView loginbtn;
     LoginFragment loginFragment;
    LinearLayout layout;
    FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_activty);
        loginbtn = findViewById(R.id.loginbtn);
         layout =findViewById(R.id.liniarLayout);
        frameLayout = findViewById(R.id.framLayout);


        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.framLayout, new LoginFragment());
        ft.commit();
        loginbtn.setOnClickListener(this);




    }





    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.loginbtn:


                if(loginbtn.isClickable())
                {
                    layout.setVisibility(GONE);

                }
                else
                    layout.setVisibility(View.VISIBLE);
                    FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.framLayout, new SignUpFrament());
                   ft.addToBackStack(null);
                   ft.commit();

                    break;



        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        checkForLogin();
    }

    private void checkForLogin() {
        final SharedPreferences sharedPreferences = getSharedPreferences("",MODE_PRIVATE);
        final Boolean isloggedin = sharedPreferences.getBoolean("",false);
        if (isloggedin)
        {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.framLayout, new MainPage());
            ft.addToBackStack(null);
            ft.commit();

            layout.setVisibility(GONE);
            }


        }
    }

