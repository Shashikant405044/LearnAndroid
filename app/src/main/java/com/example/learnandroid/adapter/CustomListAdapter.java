package com.example.learnandroid.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.learnandroid.R;
import com.example.learnandroid.dbActivity.ProfileListActivity;
import com.example.learnandroid.model.StudentData;

import java.util.List;

public class CustomListAdapter extends BaseAdapter {

    private List<StudentData> studentData ;
    private  Context context;

    public CustomListAdapter(List<StudentData> list, Context context) {

        this.studentData = list;
        this.context = context;
    }

    public CustomListAdapter(ProfileListActivity profileListActivity, int custome_profile_item, List<String> list) {

    }


    @Override
    public int getCount() {
        return studentData.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        view = LayoutInflater.from(context).inflate(R.layout.custome_profile_item,viewGroup,false);

       // ImageView imageView = view.findViewById(R.id.item_image_view);

        TextView title = view.findViewById(R.id.title_name_ui);
        TextView desciption = view.findViewById(R.id.description_ui);
        TextView datetime = view.findViewById(R.id.timeAndDate);
        StudentData  data = studentData.get(position);

        title.setText(data.getTitle());
        desciption.setText(data.getDescricption());
        datetime.setText(data.getDataAndTime());
        return view;

    }
}
