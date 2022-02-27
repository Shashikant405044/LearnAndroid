package com.example.learnandroid;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.learnandroid.databinding.ActivityDataAndTimeBinding;

import java.util.Calendar;

public class DataAndTime extends BaseActivity{
  private ActivityDataAndTimeBinding binding;

  Calendar cal;
  TimePicker timePicker;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding =  ActivityDataAndTimeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        DataAndTime.this.setTitle("DataAndTime");
        cal = Calendar.getInstance();

         binding.datePiker.init(cal.get(Calendar.YEAR),
                 cal.get(Calendar.MONTH),
                 cal.get(Calendar.DAY_OF_MONTH), new DatePicker.OnDateChangedListener() {
                     @Override
                     public void onDateChanged(DatePicker datePicker, int i, int i1, int i2) {

//                         Toast.makeText(DataAndTime.this,"Date"
//                                 +datePicker.getDayOfMonth()+"\n"+"Month"
//                                 +(datePicker.getMonth()+1)+ "\n" +"Year"+datePicker.getYear(),
//                                 Toast.LENGTH_SHORT).show();


//                         int Date = cal.get(Calendar.DAY_OF_MONTH);
//                         int Month = cal.get(Calendar.MONTH);
//                         int Year = cal.get(Calendar.YEAR);

                         binding.dataDisplay.setText(""
                                 +datePicker.getDayOfMonth()+"|"+""
                                 +(datePicker.getMonth()+1)+ "|" +""+datePicker.getYear());

                     }
                 });



         binding.timePiker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
             @Override
             public void onTimeChanged(TimePicker timePicker, int i, int i1) {

                 Toast.makeText(DataAndTime.this, "Time"+i+":"+i1, Toast.LENGTH_SHORT).show();
             }
         });

    }
}