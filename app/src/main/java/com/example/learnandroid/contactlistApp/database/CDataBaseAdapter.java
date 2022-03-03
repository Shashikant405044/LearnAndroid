package com.example.learnandroid.contactlistApp.database;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class CDataBaseAdapter {
    private final String Db_Name = "contact_list";
    private final String Table_Name = "data";
    private final int Db_Version = 1;


    //TODO: Table Amd Columns Name

    private final String ROW_ID = "rowId ";
    private final String F_NAME = "f_name";
    private final String L_NAME = "l_name";
    private final String MOBIL_NO = "mobilNo";
    private final String E_MAIL = "email";
    private final String ADDRESS_BAR = "address_bar";
   // private final String IMAGE_Data = " imageData";
    //  private final String Image = "image";


    private String sqlQuery = "CREATE TABLE " + Table_Name + " " +
            "(" + ROW_ID + " " + "INTEGER PRIMARY KEY AUTOINCREMENT" +
            ", " + F_NAME + " text" + ", " + L_NAME +
            " text" + "," + MOBIL_NO + " text" + " ," + E_MAIL + " text " +
            "," + ADDRESS_BAR + " text" + ")";

    CDataBaseAdapter.MyDbHelper myDbHelper;
    SQLiteDatabase sqLiteDatabase;


    public CDataBaseAdapter(Context context) {
        myDbHelper = new CDataBaseAdapter.MyDbHelper(context);
      //  myDbHelper = new DataBaseAdapter.MyDbHelper(context);

    }

    public CDataBaseAdapter openDataBase() {
        sqLiteDatabase = myDbHelper.getWritableDatabase();
        return this;

    }


    public void insertData(Context context, String f_name, String l_name, String mobilNo, String email
            ,String address_bar ) {

        ContentValues contentValues = new ContentValues();

        contentValues.put(F_NAME, f_name);
        contentValues.put(L_NAME, l_name);
        contentValues.put(MOBIL_NO, mobilNo);
        contentValues.put(E_MAIL, email);
        contentValues.put(ADDRESS_BAR, address_bar);
        //  contentValues.put(Image,image);

        long insertedRow = sqLiteDatabase.insert(Table_Name, null, contentValues);
        if (insertedRow > 0) {
            Toast.makeText(context, insertedRow + "Data is SuccessFully Insert", Toast.LENGTH_SHORT).show();
        } else {

            Toast.makeText(context, "Something Went Wrong", Toast.LENGTH_SHORT).show();
        }

    }

    // Feating data

    public Cursor getAllData() {
        String[] colList = new String[]{ROW_ID, F_NAME, L_NAME, MOBIL_NO,E_MAIL,ADDRESS_BAR};
        return sqLiteDatabase.query(Table_Name, colList, null, null, null, null, null);

    }

    public void deleteSingleRecord(Context context, String rowId){
        // DELETE * FROM STUDENT Where RowDI = 101;
        int deletedItems = sqLiteDatabase.delete(Table_Name
                , ROW_ID+" = "+rowId, null);
        if (deletedItems > 0 ){

            Toast.makeText(context, deletedItems+" Record deleted", Toast.LENGTH_SHORT).show();
        }else {

            Toast.makeText(context, "Try Again !!!", Toast.LENGTH_SHORT).show();
        }
    }



    public void updateRecord(Context context, String f_name, String l_name, String mobilNo, String email
            ,String address_bar,String rowId) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(F_NAME, f_name);
        contentValues.put(L_NAME, l_name);
        contentValues.put(MOBIL_NO, mobilNo);
        contentValues.put(E_MAIL, email);
        contentValues.put(ADDRESS_BAR, address_bar);
        int updatedRow = sqLiteDatabase.update(Table_Name, contentValues, ROW_ID + " = " + rowId, null);
        if (updatedRow > 0) {
            Toast.makeText(context, updatedRow + " data is successfully updated", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, updatedRow + " Something Wrong", Toast.LENGTH_SHORT).show();

        }
    }







    class MyDbHelper extends SQLiteOpenHelper {


        public MyDbHelper(Context context) {
            super(context, Db_Name, null, Db_Version);

        }


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
