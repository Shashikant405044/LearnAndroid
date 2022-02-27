package com.example.learnandroid.bmiapp;
import android.Manifest;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.learnandroid.R;
import com.example.learnandroid.databinding.ActivityContactUsBinding;
import com.example.learnandroid.databinding.DiologCustomeBinding;

import java.util.ArrayList;

public class ContactUs extends BaseActivity implements View.OnClickListener {
    private ActivityContactUsBinding binding;
    ArrayAdapter<String> adapter;
    public static ArrayList<String> data = new ArrayList<>();
    private String[] AllowPermission = new String[]{Manifest.permission.CALL_PHONE, Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityContactUsBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());
         ContactUs.this.setTitle("ContactUs");
        binding.Dial.setOnClickListener(this);
        binding.Call.setOnClickListener(this);
        binding.Email.setOnClickListener(this);
        binding.suggestion.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId())
        {
            case R.id.Dial:

                Intent dialIntent = new Intent(Intent.ACTION_DIAL);
                dialIntent.setData(Uri.parse("tel:989056620"));
                startActivity(dialIntent);

                break;


            case R.id.suggestion:

                DiologCustomeBinding diologCustomeBinding = DiologCustomeBinding.inflate(getLayoutInflater());
                Dialog dialog = new Dialog(ContactUs.this);
                dialog.setContentView(diologCustomeBinding.getRoot());

                adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, new ArrayList<String>());
                  diologCustomeBinding.listview.setAdapter(adapter);
                dialog.setCancelable(false);
                dialog.show();

                Window window = dialog.getWindow();
                window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);



                diologCustomeBinding.btnSubmit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                        if(diologCustomeBinding.etFname.getText().toString().length() ==0) {
                            diologCustomeBinding.etFname.setError(" Enter text Field");

                            // isVailidSelphoneNumber();

                        }
                        else
                        {
                            Toast.makeText(ContactUs.this, "" +diologCustomeBinding.etFname.getText().toString(), Toast.LENGTH_SHORT).show();

                            adapter.add(diologCustomeBinding.etFname.getText().toString());
                            adapter.notifyDataSetChanged();
                            // Clear the input
                            diologCustomeBinding.etFname.setText("");

                        }



                    }
                });
                diologCustomeBinding.btnCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        data.add(diologCustomeBinding.etFname.getText().toString()); {
                            ArrayAdapter<String> adapter = new ArrayAdapter<String>(ContactUs.this, android.R.layout.simple_list_item_1, data);
                            diologCustomeBinding.listview.setAdapter(adapter);
                            diologCustomeBinding.etFname.setText("");
                            dialog.dismiss();
                        }
                    }
                });
                break;

            case R.id.Call:
                if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE) ==
                        PackageManager.PERMISSION_GRANTED)

                    doCall();
                else {
                    ActivityCompat.requestPermissions(ContactUs.this, AllowPermission, 1);
                }
                    break;


            case R.id.Email:

                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/html");
                intent.putExtra(Intent.EXTRA_EMAIL, "sk405044@gmail.com");
                intent.putExtra(Intent.EXTRA_SUBJECT, "Subject");
                intent.putExtra(Intent.EXTRA_TEXT, "I'm email body.");
                startActivity(Intent.createChooser(intent, "Send Email"));
                break;

        }
    }

    private void doCall() {
        Intent call = new Intent(Intent.ACTION_CALL, Uri.parse("tel:9839056620"));
        startActivity(call);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == 1)
        {

            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
            {
                doCall();
            }
            else {
                customeToast("Permission Denied !!!!!");

            }

        }
    }
}
