package com.example.learnandroid.adapter;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import com.example.learnandroid.dbActivity.ProfileListActivity;

public class DataBaseAdapter {
    ProfileListActivity profileListActivity = new ProfileListActivity();
    //TODO: Database Name And Table With Version
    private final String Db_Name = "android";
    private final String Table_Name = "student";
    private final int Db_Version = 1;

    //TODO: Table Amd Columns Name

    private final String Row_Id = "rowId ";
    private final String Title = "title";
    private final String TitleDescription = "Description";
    private final String DateAndTime = "dataAndTime";
    //  private final String Image = "image";
    // TODO: create table student
    private String sqlQuery = "CREATE TABLE " + Table_Name + " (" + Row_Id + " " + "INTEGER PRIMARY KEY AUTOINCREMENT" + ", " + Title + " text" + ", " + TitleDescription + " text" + "," + DateAndTime + " text" + ")";

    MyDbHelper myDbHelper;
    SQLiteDatabase sqLiteDatabase;


    // TODO: Constructor Created  My Class And Instance Created Here inner class MyDb Helper

    public DataBaseAdapter(Context context) {
        myDbHelper = new MyDbHelper(context);

    }

    public DataBaseAdapter openDataBase() {
        sqLiteDatabase = myDbHelper.getWritableDatabase();
        return this;
    }

    public void insertData(Context context, String title, String titleDescription, String dateAndTime) {

        ContentValues contentValues = new ContentValues();

        contentValues.put(Title, title);
        contentValues.put(TitleDescription, titleDescription);
        contentValues.put(DateAndTime, dateAndTime);
        //  contentValues.put(Image,image);

        long insertedRow = sqLiteDatabase.insert(Table_Name, null, contentValues);
        if (insertedRow > 0) {
            Toast.makeText(context, insertedRow + "Data is SuccessFully Insert", Toast.LENGTH_SHORT).show();
        } else {

            Toast.makeText(context, "Something Went Wrong", Toast.LENGTH_SHORT).show();
        }

    }

    public Cursor getAllData() {
        String[] colList = new String[]{Row_Id, Title, TitleDescription, DateAndTime};
        return sqLiteDatabase.query(Table_Name, colList, null, null, null, null, null);

    }

    public void deleteSingleRecord(Context context, String rowId){
        // DELETE * FROM STUDENT Where RowDI = 101;
        int deletedItems = sqLiteDatabase.delete(Table_Name
                , Row_Id+" = "+rowId, null);
        if (deletedItems > 0 ){

            Toast.makeText(context, deletedItems+" Record deleted", Toast.LENGTH_SHORT).show();
        }else {

            Toast.makeText(context, "Try Again !!!", Toast.LENGTH_SHORT).show();
        }
    }

    public void updateRecord(Context context, String title, String titleDescription, String dateAndTime, String rowId){
        ContentValues contentValues = new ContentValues();
        contentValues.put(Title, title);
        contentValues.put(TitleDescription, titleDescription);
        contentValues.put(DateAndTime, dateAndTime);
        int updatedRow = sqLiteDatabase.update(Table_Name, contentValues, Row_Id+" = "+rowId, null);
        if (updatedRow > 0){
            Toast.makeText(context, updatedRow+" data is successfully updated", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, updatedRow+" Something  Went Wrong", Toast.LENGTH_SHORT).show();

        }
    }





    class MyDbHelper extends SQLiteOpenHelper {

        public MyDbHelper(Context context) {
            super(context, Db_Name, null, Db_Version);        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {

            //TODO: First Time It will Be Used For Create Table data
            sqLiteDatabase.execSQL(sqlQuery);


        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        }
    }
}