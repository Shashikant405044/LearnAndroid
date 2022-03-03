package com.example.learnandroid.contactlistApp.activity;
import android.app.Dialog;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.example.learnandroid.BaseActivity;
import com.example.learnandroid.contactlistApp.database.CDataBaseAdapter;
import com.example.learnandroid.contactlistApp.adapter.MyContactRecyclerViewAdapter;
import com.example.learnandroid.contactlistApp.interfascpak.OnItemClickListner;
import com.example.learnandroid.contactlistApp.model.ContactList;
import com.example.learnandroid.databinding.ActivityContactApplicationBinding;
import com.example.learnandroid.databinding.ContactaddLayoutBinding;
import java.util.ArrayList;
import java.util.List;

public class ContactApplication extends BaseActivity  {
    private CDataBaseAdapter adapter;
    private Cursor cursor;
    int clickedPosition;
    ActivityContactApplicationBinding binding;
    ContactaddLayoutBinding contactaddLayoutBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityContactApplicationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ContactApplication.this.setTitle("ContactListApp");
        adapter = new CDataBaseAdapter(this);
        adapter.openDataBase();
        loadDataInListView();
    }

    public void loadDataInListView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        binding.recyclerView.setLayoutManager(linearLayoutManager);
        // MyRecyclerView Class
        MyContactRecyclerViewAdapter adapter = new MyContactRecyclerViewAdapter(this, getAllContactLit(), new OnItemClickListner() {
            @Override
            public void onItemClick(List<ContactList> contactList, int position) {
            }
        });

        binding.recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    public void floating_btn(View view) {
        contactaddLayoutBinding = ContactaddLayoutBinding.inflate(getLayoutInflater());
        Dialog dialog = new Dialog(ContactApplication.this);
        dialog.setContentView(contactaddLayoutBinding.getRoot());
        dialog.setCancelable(true);
        dialog.show();
        Window window = dialog.getWindow();
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);

        contactaddLayoutBinding.saveCotactBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String F = contactaddLayoutBinding.fName.getText().toString();
                String L = contactaddLayoutBinding.LName.getText().toString();
                String M = contactaddLayoutBinding.phoneNo.getText().toString();


                if (F.equals(""))
                {
                    contactaddLayoutBinding.fName.setError("Enter F-Name");
                    contactaddLayoutBinding.fName.requestFocus();
                    return;
                }

                if (L.equals(""))
                {
                    contactaddLayoutBinding.LName.setError("Enter L-Name");
                    contactaddLayoutBinding.LName.requestFocus();
                    return;
                }

                if (M.equals(""))
                {
                    contactaddLayoutBinding.phoneNo.setError("Enter Phone No");
                    contactaddLayoutBinding.phoneNo.requestFocus();
                    return;
                }

                adapter.insertData(ContactApplication.this,
                        contactaddLayoutBinding.fName.getText().toString(),
                        contactaddLayoutBinding.LName.getText().toString(),
                        contactaddLayoutBinding.phoneNo.getText().toString(),
                        contactaddLayoutBinding.emailId.getText().toString(),
                        contactaddLayoutBinding.addressInput.getText().toString());

                loadDataInListView();
                dialog.dismiss();

            }
        });

    }

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