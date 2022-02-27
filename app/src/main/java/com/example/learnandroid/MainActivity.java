package com.example.learnandroid;



import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.CheckBox;

import androidx.appcompat.widget.Toolbar;

import com.example.learnandroid.bmiapp.BaseActivity;
import com.example.learnandroid.bmiapp.BmiApplication;
import com.example.learnandroid.contactlistApp.activity.ContactApplication;
import com.example.learnandroid.databinding.ActivityMainBinding;
import com.example.learnandroid.dbActivity.ProfileListActivity;
import com.example.learnandroid.fragments.fTofcommnication.FTFMainActivity;
import com.example.learnandroid.fragments.fragmentsimpletransication.FragmentParentActivity;
import com.example.learnandroid.fragments.ftoactivity.MainFragmentToActivity;


public class MainActivity extends BaseActivity implements View.OnClickListener {
    boolean doubleBackToExitPressedOnce = false;
  Toolbar toolbar;
    Context context;
    private ActivityMainBinding binding;
    String output ="";
    String course ="";
    CheckBox checkBox;
    //RadioButton radioButton;
    boolean isAllFieldChecked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        MainActivity.this.setTitle("Android Course");
        context = this;
        binding.BmiCal.setOnClickListener(this);
        binding.enqueryForm.setOnClickListener(this);
        binding.intentExample.setOnClickListener(this);
        binding.popUpMenu.setOnClickListener(this);
        binding.ShareIntent.setOnClickListener(this);
        binding.dateTime.setOnClickListener(this);
        binding.toastItem.setOnClickListener(this);
        binding.fragmentToActivity.setOnClickListener(this);
        binding.fragment.setOnClickListener(this);
        binding.ftofragment.setOnClickListener(this);
        binding.SqlLiteDB.setOnClickListener(this);
        binding.contactListApp.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.enquery_Form:

                Intent intent = new Intent(MainActivity.this, EnqueryForm.class);
                startActivity(intent);

                break;
            case R.id.Bmi_cal:
                     Intent bmical = new Intent(MainActivity.this, BmiApplication.class);
                      startActivity(bmical);

                    break;

            case  R.id.intentExample:
                Intent intentexample = new Intent(MainActivity.this, IntentActivity1.class);
                startActivity(intentexample);
                break;

            case  R.id.popUpMenu:
                Intent popup = new Intent(MainActivity.this, PopUpMenu.class);
                startActivity(popup);
                break;
            case  R.id.ShareIntent:
                Intent share = new Intent(MainActivity.this, EnqueryForm.class);
                 startActivity(share);
                break;


            case  R.id.date_time:
                Intent datetime = new Intent(MainActivity.this, DataAndTime.class);
                startActivity(datetime);
                break;

            case R.id.toast_item:


                Intent toastitem = new Intent(MainActivity.this,ToastItem.class);
                startActivity(toastitem);
                break;

            case R.id.fragmentToActivity:


                Intent FToActivity = new Intent(MainActivity.this, MainFragmentToActivity.class);
                startActivity(FToActivity);
                break;

            case R.id.fragment:


                Intent fragment = new Intent(MainActivity.this, FragmentParentActivity.class);
                startActivity(fragment);
                break;
            case R.id.ftofragment:


                Intent ftofment = new Intent(MainActivity.this, FTFMainActivity.class);
                startActivity(ftofment);
                break;

            case R.id.SqlLiteDB:


                Intent SqlLiteDB = new Intent(MainActivity.this, ProfileListActivity.class);
                startActivity(SqlLiteDB);
                break;


            case R.id.contactListApp:

                Intent contactListApp = new Intent(MainActivity.this, ContactApplication.class);
                startActivity(contactListApp);

        }
    }

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
         customeToast("Please click BACK again to exit");
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 500);
    }
}
