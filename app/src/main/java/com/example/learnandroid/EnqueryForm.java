package com.example.learnandroid;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Toast;


import com.example.learnandroid.databinding.ActivityEnqueryFormBinding;

import java.util.regex.Pattern;


public class EnqueryForm extends BaseActivity implements View.OnClickListener {

    Intent intent;
    private static final Pattern EMAIL_PATTERN = Pattern.compile("[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
            "\\@" +
            "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
            "(" +
            "\\." +
            "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
            ")+");
    private ActivityEnqueryFormBinding binding;
    private RadioButton radioButton;
    boolean isAllFieldChecked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEnqueryFormBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        EnqueryForm.this.setTitle("EnqueryForm");
        binding.submit.setOnClickListener(this);
        binding.clear.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {

        isAllFieldChecked = validation();

        switch (view.getId()) {

            case R.id.submit:
                if (isAllFieldChecked) {
                    binding.submit.setVisibility(View.GONE);
                }
                if (isAllFieldChecked) {
                    binding.clear.setVisibility(View.VISIBLE);

                }
                if (isAllFieldChecked) {
                    etDataOrRadio();
                }

                if (isAllFieldChecked) {
                    intent = new Intent(EnqueryForm.this, EnqueryReciveData.class);

                    intent.putExtra("fname", binding.fName.getText().toString());
                    intent.putExtra("lname", binding.LName.getText().toString());
                    intent.putExtra("email", binding.emailId.getText().toString());
                    intent.putExtra("phoneno", binding.phoneNo.getText().toString());
                    intent.putExtra("course", binding.item1.getText().toString());
                    intent.putExtra("gender", binding.gender.getText().toString());

                    intent.putExtra("item1",binding.item1.getText().toString());
                    intent.putExtra("item2", binding.item2.getText().toString());
                    intent.putExtra("item3", binding.item3.getText().toString());
                    intent.putExtra("item4", binding.item4.getText().toString());
                    intent.putExtra("item5", binding.item5.getText().toString());
                    intent.putExtra("item6", binding.item6.getText().toString());
                    intent.putExtra("item7", binding.item7.getText().toString());

                    startActivity(intent);

                }

                break;
            case R.id.clear:
                binding.fName.setText("");
                binding.LName.setText("");
                binding.emailId.setText("");
                binding.phoneNo.setText("");
                binding.phoneNo.setText("");

        }

    }


    @SuppressLint("ResourceType")
    private void etDataOrRadio() {

        int selectedId = binding.rgGroup.getCheckedRadioButtonId();
        radioButton = (RadioButton) findViewById(selectedId);
        binding.gender.setVisibility(View.GONE);
        binding.gender.setText(radioButton.getText());

    }

    private boolean validation() {


        if (binding.fName.getText().toString().length() == 0) {
            binding.fName.setError("Please Enter First Name");
            return false;
        }
        if (binding.LName.getText().toString().length() == 0) {
            binding.LName.setError("Enter Last Name");
            return false;

        }
        if (binding.emailId.getText().toString().equalsIgnoreCase("")
                || !EMAIL_PATTERN.matcher(binding.emailId.getText().toString().trim()).matches()) {
            binding.emailId.requestFocus();
            binding.emailId.setError("Enter Your Correct Email Address");
            return false;
        }


        if (binding.phoneNo.getText().toString().length() == 0) {
            binding.phoneNo.setError(" Enter Phone Number Correct");
            return false;

        }


        if (binding.rgGroup.getCheckedRadioButtonId() == -1) {

            Toast.makeText(this, "Please Select the Gender", Toast.LENGTH_SHORT).show();


            return false;
        } else if (binding.item1.getText().toString().length() == -1) {
            Toast.makeText(this, "Please Select CheckBox", Toast.LENGTH_SHORT).show();

            return false;
        }

        return true;
    }
}
