package com.example.learnandroid.bmiapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;

import com.example.learnandroid.R;
import com.example.learnandroid.databinding.ActivityBmiApplicationBinding;


public class BmiApplication extends BaseActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {
    private ActivityBmiApplicationBinding binding;
    Spinner spinnerCity;
    String option [] = {"Option1","Option2"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBmiApplicationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        BmiApplication.this.setTitle("BmiApplication");

        binding.resBtn.setOnClickListener(this);
        binding.clear.setOnClickListener(this);
        binding.spinnercity.setOnItemSelectedListener(this);

        ArrayAdapter adapterspinner =  new ArrayAdapter(this, android.R.layout.simple_spinner_item,option);
        adapterspinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.spinnercity.setAdapter(adapterspinner);



    }
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {



        Toast.makeText(getApplicationContext(), option[0], Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }



    @Override
    public void onClick(View view) {
        switch (view.getId()){

            case R.id.res_Btn:

                String strweight = binding.etWeight.getText().toString();
                String strheight = binding.etHieght.getText().toString();

//                String strweight = binding.etWeight.getEditText().toString();
//                String strheight = binding.etHieght.getEditText().toString();

                if (strheight != null && !"".equals(strheight)
                        && strweight != null && !"".equals(strweight)) {
                    float heightValue = Float.parseFloat(strheight) / 100;
                    float weightValue = Float.parseFloat(strweight);

                    float bmi = weightValue / (heightValue * heightValue);

                    displayBMI(bmi);
                }
                break;

            case R.id.clear:

                binding.etHieght.setText("");
              binding.etWeight.setText("");

//                binding.etHieght.getEditText().setText("");
//                binding.etWeight.getEditText().setText("");
                binding.myBmiOutput.setText("");
                binding.clear.setVisibility(View.GONE);
                binding.resBtn.setVisibility(View.VISIBLE);
                break;
        }
    }

    private void displayBMI(float bmi) {
        String bmiLabel = "";

        if (Float.compare(bmi, 15f) <= 0) {
            bmiLabel = getString(R.string.very_severely_underweight);
        } else if (Float.compare(bmi, 15f) > 0  &&  Float.compare(bmi, 16f) <= 0) {
            bmiLabel = getString(R.string.severely_underweight);
        } else if (Float.compare(bmi, 16f) > 0  &&  Float.compare(bmi, 18.5f) <= 0) {
            bmiLabel = getString(R.string.underweight);
        } else if (Float.compare(bmi, 18.5f) > 0  &&  Float.compare(bmi, 25f) <= 0) {
            bmiLabel = getString(R.string.normal);
        } else if (Float.compare(bmi, 25f) > 0  &&  Float.compare(bmi, 30f) <= 0) {
            bmiLabel = getString(R.string.overweight);
        } else if (Float.compare(bmi, 30f) > 0  &&  Float.compare(bmi, 35f) <= 0) {
            bmiLabel = getString(R.string.obese_class_i);
        } else if (Float.compare(bmi, 35f) > 0  &&  Float.compare(bmi, 40f) <= 0) {
            bmiLabel = getString(R.string.obese_class_ii);
        } else {
            bmiLabel = getString(R.string.obese_class_iii);
        }

        bmiLabel = bmi + "\n\n" + bmiLabel;
        binding.myBmiOutput.setText(bmiLabel);

        binding.resBtn.setVisibility(View.GONE);
        binding.clear.setVisibility(View.VISIBLE);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.about_us:
                Intent about = new Intent(BmiApplication.this, AboutUs.class);
                startActivity(about);
                break;
            case R.id.bmi_chart:
                customeToast("Clciked Bmi Chart");
                Intent intent1 = new Intent(BmiApplication.this, BmiChartActivity.class);
                startActivity(intent1);
                //Toast.makeText(MainActivity.this, "bmi Chart ", Toast.LENGTH_SHORT).show();

                break;
            case R.id.developer:
                customeToast(" About Developer");
                Intent intent = new Intent(BmiApplication.this, AboutDeveloper.class);
                startActivity(intent);
                // Toast.makeText(MainActivity.this, "item ", Toast.LENGTH_SHORT).show();

                break;
            case R.id.exit:
                AlertDialog.Builder aleratdiaolog = new AlertDialog.Builder(BmiApplication.this);
                  aleratdiaolog.setTitle("Confirm Exit!!");
                  aleratdiaolog.setIcon(R.drawable.bmichart);
                  aleratdiaolog.setMessage("Are you sure , You want close app");
                  aleratdiaolog.setCancelable(false);
                  aleratdiaolog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                      @Override
                      public void onClick(DialogInterface dialogInterface, int i) {

                          finish();
                      }
                  });


                  aleratdiaolog.setNegativeButton("No ", new DialogInterface.OnClickListener() {
                      @Override
                      public void onClick(DialogInterface dialogInterface, int i) {
                          customeToast("You Click On No");
                      }
                  });


                  aleratdiaolog.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                      @Override
                      public void onClick(DialogInterface dialogInterface, int i) {

                          customeToast("You Click On Cancel");
                      }
                  });

                  AlertDialog alertDialog = aleratdiaolog.create();
                  alertDialog.show();
                // Toast.makeText(MainActivity.this, "item ", Toast.LENGTH_SHORT).show();

                break;

            case R.id.contact_us:

                Intent contactus = new Intent(BmiApplication.this, ContactUs.class);
                startActivity(contactus);
                break;

        }
        return super.onOptionsItemSelected(item);
    }



}