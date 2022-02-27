package com.example.learnandroid.dbActivity;
import android.app.Dialog;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import androidx.annotation.NonNull;
import com.example.learnandroid.BaseActivity;
import com.example.learnandroid.R;
import com.example.learnandroid.adapter.CustomListAdapter;
import com.example.learnandroid.adapter.DataBaseAdapter;
import com.example.learnandroid.databinding.ActivityProfileListBinding;
import com.example.learnandroid.databinding.ProfileDialogBinding;
import com.example.learnandroid.databinding.UpdateRowDataBinding;
import com.example.learnandroid.model.StudentData;
import java.util.ArrayList;
import java.util.List;
public class ProfileListActivity extends BaseActivity implements AdapterView.OnItemLongClickListener {
    private DataBaseAdapter adapter;
    ActivityProfileListBinding binding;
    ProfileDialogBinding profileDialogBinding;

    UpdateRowDataBinding updateRowDataBinding;
    int clickedPosition ;
    boolean isUpdate = false;
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProfileListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        adapter = new DataBaseAdapter(this);
        adapter.openDataBase();
        binding.listView.setOnItemLongClickListener(this);
        registerForContextMenu(binding.listView);
        loadDataInListView();
    }



    public void loadDataInListView() {
        CustomListAdapter adapter = new CustomListAdapter(getAllStudentList(), this);
        binding.listView.setAdapter(adapter);
    }


//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.profile_list_menu_item, menu);
//        return super.onCreateOptionsMenu(menu);
//    }

//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//
////        switch (item.getItemId()) {
////            case R.id.create_profile:
////                profileDialogBinding = ProfileDialogBinding.inflate(getLayoutInflater());
////                Dialog dialog = new Dialog(ProfileListActivity.this);
////                dialog.setContentView(profileDialogBinding.getRoot());
////                dialog.setCancelable(true);
////                dialog.show();
////                // full width show Layout
////                Window window = dialog.getWindow();
////                window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
//////                profileDialogBinding.profileImage.setOnClickListener(new View.OnClickListener() {
//////                    @Override
//////                    public void onClick(View view) {
//////
//////                        if (ContextCompat.checkSelfPermission(ProfileListActivity.this, Manifest.permission.CAMERA) ==
//////                                PackageManager.PERMISSION_GRANTED) {
//////
//////                            callCamera();
//////                        }
//////
//////                        else {
//////                            ActivityCompat.requestPermissions(ProfileListActivity.this, new String []{Manifest.permission.CAMERA}, 1);
//////                        }
//////
//////
//////
//////                    }
//////                });
//////                // insert data here profile create btn
////                profileDialogBinding.profileCreate.setOnClickListener(new View.OnClickListener() {
////                    @Override
////                    public void onClick(View view) {
////
//////                        adapter.insertData(ProfileListActivity.this,
//////                                profileDialogBinding.firstNameInput.getText().toString(),
//////                                profileDialogBinding.lastNameInput.getText().toString(),
//////                                imageInBase64);
////
////                        dialog.dismiss();
////
////                    }
////                });
////
////                break;
////
////            case R.id.deleate_all_profile:
////
////                AlertDialog.Builder aleratdiaolog = new AlertDialog.Builder(ProfileListActivity.this);
////                aleratdiaolog.setTitle("Profile List!!");
////                aleratdiaolog.setIcon(R.drawable.androidimg);
////                aleratdiaolog.setMessage("Do you Want To Deleate All Profile");
////                aleratdiaolog.setCancelable(false);
////                aleratdiaolog.setPositiveButton("Deleate", new DialogInterface.OnClickListener() {
////                    @Override
////                    public void onClick(DialogInterface dialogInterface, int i) {
////
////                    }
////                });
////
////
////                aleratdiaolog.setNegativeButton("Cancel ", new DialogInterface.OnClickListener() {
////                    @Override
////                    public void onClick(DialogInterface dialogInterface, int i) {
////                        customeToast("You Click On No");
////                    }
////                });
////
////
//////                aleratdiaolog.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
//////                    @Override
//////                    public void onClick(DialogInterface dialogInterface, int i) {
//////
//////                        customeToast("You Click On Cancel");
//////                    }
//////                });
////
////                AlertDialog alertDialog = aleratdiaolog.create();
////                alertDialog.show();
////
////                break;
////
////        }
//
//        return super.onOptionsItemSelected(item);
//    }

//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//
//        if (requestCode == 1) {
//            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                // TODO: DO UR JOB
//                callCamera();
//            } else {
//                customeToast("Permission Denied!");
//            }
//        }
    //   }

//    private void callCamera() {
//        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//        startActivityForResult(intent, 101);
//    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//
//
//        if (requestCode == 101 && resultCode == RESULT_OK)
//        {
//            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
//            imageInBase64 = BaseActivity.convertBitmaptoBase64(bitmap);
//           // profileDialogBinding.profileImage.setImageBitmap(bitmap);
//        }
//        else
//        {
//
//        }
//        super.onActivityResult(requestCode, resultCode, data);
//    }

    public void flating_btn(View view) {
        profileDialogBinding = ProfileDialogBinding.inflate(getLayoutInflater());
        Dialog dialog = new Dialog(ProfileListActivity.this);
        dialog.setContentView(profileDialogBinding.getRoot());
        dialog.setCancelable(true);
        dialog.show();
        // full width show Layout
        Window window = dialog.getWindow();
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
//        profileDialogBinding.profileImage.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                if (ContextCompat.checkSelfPermission(ProfileListActivity.this, Manifest.permission.CAMERA) ==
//                        PackageManager.PERMISSION_GRANTED) {
//
//                    callCamera();
//                }
//
//                else {
//                    ActivityCompat.requestPermissions(ProfileListActivity.this, new String []{Manifest.permission.CAMERA}, 1);
//                }
//


        //        }
        //     });
        profileDialogBinding.profileCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter.insertData(ProfileListActivity.this, profileDialogBinding.firstNameInput.getText().toString(),
                        profileDialogBinding.lastNameInput.getText().toString(),
                        BaseActivity.getDateTime());
                    dialog.dismiss();
                   loadDataInListView();


            }
        });

    }

    private List<StudentData> getAllStudentList() {
        List<StudentData> studentDataList = new ArrayList<>();
        cursor = adapter.getAllData();
        if (cursor.getCount() > 0) {
            Log.d("DATA", "" + cursor);
            cursor.moveToFirst();
            do {
                StudentData studentData = new StudentData();
//            String rowId = cursor.getString(0);
//            String fName = cursor.getString(1);
//            String lName = cursor.getString(1);
//            String image = cursor.getString(3);
                studentData.setRowId(cursor.getString(0));
                studentData.setTitle(cursor.getString(1));
                studentData.setDescricption(cursor.getString(2));
                studentData.setDataAndTime(cursor.getString(3));
               //studentData.setImage(cursor.getString(3));
                studentDataList.add(studentData);
            } while (cursor.moveToNext());
        }
        return studentDataList;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context_item,menu);
    }
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){

            case R.id.deleate:
                cursor.moveToPosition(clickedPosition);
                String rowId = cursor.getString(0);
                adapter.deleteSingleRecord(ProfileListActivity.this,rowId);
                loadDataInListView();
                break;


            case R.id.update:
                isUpdate = true;
                cursor.moveToPosition(clickedPosition);

                updateRowDataBinding = UpdateRowDataBinding.inflate(getLayoutInflater());
                Dialog dialog = new Dialog(ProfileListActivity.this);
                dialog.setContentView(updateRowDataBinding.getRoot());
                dialog.setCancelable(true);
                dialog.show();
                // full width show Layout
                Window window = dialog.getWindow();
                window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
                updateRowDataBinding.titleUpdate.setText(cursor.getString(1));
                updateRowDataBinding.desriptionUpdte.setText(cursor.getString(2));
//        profileDialogBinding.profileImage.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                if (ContextCompat.checkSelfPermission(ProfileListActivity.this, Manifest.permission.CAMERA) ==
//                        PackageManager.PERMISSION_GRANTED) {
//
//                    callCamera();
//                }
//
//                else {
//                    ActivityCompat.requestPermissions(ProfileListActivity.this, new String []{Manifest.permission.CAMERA}, 1);
//                }
//


                //        }
                //     });
                updateRowDataBinding.UpdateNoteBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        adapter.updateRecord(ProfileListActivity.this, updateRowDataBinding.titleUpdate.getText().toString(),
                                updateRowDataBinding.desriptionUpdte.getText().toString(),
                                BaseActivity.getDateTime(), cursor.getString(0));
                        dialog.dismiss();
                        loadDataInListView();
                    }
                });

                break;
        }


        return super.onContextItemSelected(item);

    }


    @Override
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

        clickedPosition = i;

        return false;
    }
}