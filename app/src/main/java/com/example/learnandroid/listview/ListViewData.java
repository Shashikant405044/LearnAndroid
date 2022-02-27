package com.example.learnandroid.listview;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

import androidx.appcompat.app.AppCompatActivity;

import com.example.learnandroid.databinding.ActivityListViewBinding;

import java.util.ArrayList;

public class ListViewData extends AppCompatActivity {

    ArrayAdapter<String> adapter;
      private ActivityListViewBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityListViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, new ArrayList<String>());
        binding.list.setAdapter(adapter);
    }


    public void addToList(View view) {


        adapter.add(binding.input.getText().toString());
        adapter.notifyDataSetChanged();
        // Clear the input
        binding.input.setText("");


    }
}