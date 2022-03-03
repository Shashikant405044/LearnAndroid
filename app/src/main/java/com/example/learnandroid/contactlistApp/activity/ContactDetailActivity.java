package com.example.learnandroid.contactlistApp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.example.learnandroid.BaseActivity;
import com.example.learnandroid.adapter.DataBaseAdapter;
import com.example.learnandroid.contactlistApp.adapter.MyContactRecyclerViewAdapter;
import com.example.learnandroid.contactlistApp.database.CDataBaseAdapter;
import com.example.learnandroid.contactlistApp.interfascpak.OnItemClickListner;
import com.example.learnandroid.contactlistApp.model.ContactList;

import com.example.learnandroid.databinding.ActivityContactDetailBinding;
import com.example.learnandroid.databinding.UpdateContactListItemBinding;
import com.example.learnandroid.databinding.UpdateRowDataBinding;
import com.example.learnandroid.dbActivity.ProfileListActivity;

import java.util.ArrayList;
import java.util.List;

public class ContactDetailActivity extends AppCompatActivity {
    ActivityContactDetailBinding binding;
    UpdateContactListItemBinding updateContactListItemBinding;
    ContactApplication contactApplication;
    CDataBaseAdapter adapter;

    Intent intent;
    Cursor cursor;
    int clickedPosition ;
    boolean isUpdate = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityContactDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ContactDetailActivity.this.setTitle("ContactDetails");
       // loadDataInListView();
        //contactApplication = new ContactApplication();
      //  contactApplication.getAllContactLit();

        adapter = new CDataBaseAdapter(this);
        adapter.openDataBase();
        Intent intent = getIntent();
        String fName= intent.getStringExtra("fname");
        String Last= intent.getStringExtra("lname");
        String phoneno= intent.getStringExtra("mobil");
        String email= intent.getStringExtra("email");
        String address= intent.getStringExtra("address");
       // String value2= intent.getStringExtra("EXTRA_KEY_2");
        binding.fNameDetails.setText(fName);
        binding.LNameDetails.setText(Last);
        binding.phoneNoDetails.setText(phoneno);
        binding.emailIdDetails.setText(email);
        binding.addressInputDetails.setText(address);


        updateContactListItem();



    }

    private void updateContactListItem() {
              getAllContactLit();

        binding.editCotactBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isUpdate = true;
                cursor.moveToPosition(clickedPosition);
                updateContactListItemBinding = UpdateContactListItemBinding.inflate(getLayoutInflater());
                Dialog dialog = new Dialog(ContactDetailActivity.this);
                dialog.setContentView(updateContactListItemBinding.getRoot());
                dialog.setCancelable(true);
                dialog.show();
                // full width show Layout
                Window window = dialog.getWindow();
                window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
                // updateContactListItemBinding.fName.setText(cursor.getString(1));
//               updateContactListItemBinding.LName.setText(cursor.getString(2));
//               updateContactListItemBinding.phoneNo.setText(cursor.getString(3));
//               updateContactListItemBinding.emailId.setText(cursor.getString(4));
//               updateContactListItemBinding.addressInput.setText(cursor.getString(5));
                //  contactApplication.loadDataInListView();


                Intent intent = getIntent();
                String fName= intent.getStringExtra("fname");
                String Last= intent.getStringExtra("lname");
                String phoneno= intent.getStringExtra("mobil");
                String email= intent.getStringExtra("email");
                String address= intent.getStringExtra("address");
                // String value2= intent.getStringExtra("EXTRA_KEY_2");
                updateContactListItemBinding.fName.setText(fName);
                updateContactListItemBinding.LName.setText(Last);
                updateContactListItemBinding.phoneNo.setText(phoneno);
                updateContactListItemBinding.emailId.setText(email);
                updateContactListItemBinding.addressInput.setText(address);
                updateContactListItemBinding.saveUpdateBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        adapter.updateRecord(ContactDetailActivity.this, updateContactListItemBinding.fName.getText().toString(),
                                updateContactListItemBinding.LName.getText().toString(),
                                updateContactListItemBinding.phoneNo.getText().toString(),
                                updateContactListItemBinding.emailId.getText().toString(),
                                updateContactListItemBinding.addressInput.getText().toString(),
                                cursor.getString(0));
                               dialog.dismiss();
//                               updateContactListItem();
//                               loadDataInListView();
                               intent();


                    }
                });


            }
        });


        binding.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                cursor.moveToPosition(clickedPosition);
                String rowId = cursor.getString(0);
                adapter.deleteSingleRecord(ContactDetailActivity.this,rowId);
                loadDataInListView();
                intent();
            }
        });
    }

    private void intent() {
        Intent ref = new Intent(ContactDetailActivity.this, ContactApplication.class);
        startActivity(ref);
    }

    private void loadDataInListView() {

        MyContactRecyclerViewAdapter adapter = new MyContactRecyclerViewAdapter(this, getAllContactLit(), new OnItemClickListner() {
            @Override
            public void onItemClick(List<ContactList> contactList, int position) {


            }
        });

        adapter.notifyDataSetChanged();
    }


    // cotact all data

    public List<ContactList> getAllContactLit() {
        List<ContactList> contactDataLists = new ArrayList<>();
        cursor = adapter.getAllData();
        if (cursor.getCount() > 0) {
            Log.d("DATA", "" + cursor);
            cursor.moveToFirst();
            do {
                ContactList contactList = new ContactList();
//            String rowId = cursor.getString(0);
//            String fName = cursor.getString(1);
//            String lName = cursor.getString(1);
//            String image = cursor.getString(3);
                contactList.setRowId(cursor.getString(0));
                contactList.setF_name(cursor.getString(1));
                contactList.setL_name(cursor.getString(2));
                contactList.setMobilNo(cursor.getString(3));
                contactList.setEmail(cursor.getString(4));
                contactList.setAddress_bar(cursor.getString(5));

                //studentData.setImage(cursor.getString(3));
                contactDataLists.add(contactList);
            } while (cursor.moveToNext());
        }
        return contactDataLists;
    }
}