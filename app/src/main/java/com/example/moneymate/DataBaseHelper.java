package com.example.moneymate;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DataBaseHelper extends SQLiteOpenHelper {


    private Context context;
    private static final String DATABASE_NAME= "MoneyMate.db";
    private static final int  DATABASE_VERSION = 1;

    //database table name
    private static final String TABLE_NAME="Income";

    //database column names
    private static final String COLUMN_ID ="Account_id";
    private static final String COLUMN_TITLE="Account_Name";
    private static final String COLUMN_TYPE ="Account_Type";
    private static final String COLUMN_AMOUNT ="Amount";


    //constructor
     DataBaseHelper(@Nullable Context context) {
         //declare database name and the version
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context=context;
    }

    //on create method
    //create table-sql statement
    //column id auto incrementing
    @Override
    public void onCreate(SQLiteDatabase db) {

        String query = "CREATE TABLE " +TABLE_NAME+ " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_TITLE + " TEXT, " +
                COLUMN_TYPE + " TEXT, " +
                COLUMN_AMOUNT + " TEXT);";

        db.execSQL(query);

    }

    //on upgrade method
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    //adding new account
    void addAccount(String Account_Name, String Account_Type, String Amount){

         //creating sqlite Database object
         SQLiteDatabase db =this.getWritableDatabase();
         //creating content values object
        ContentValues cv = new ContentValues();

        //key & value
        cv.put(COLUMN_TITLE,Account_Name);
        cv.put(COLUMN_TYPE,Account_Type);
        cv.put(COLUMN_AMOUNT,Amount);

        //inserting by giving table name and content values
        long result =db.insert(TABLE_NAME, null, cv);

        //if it is fail to insert values
        if(result == -1){
            Toast.makeText(context, "Failed",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Added Successfully",Toast.LENGTH_LONG).show();
        }
    }


    //read all data from database
    Cursor readAllData(){
        String query = "SELECT * FROM " + TABLE_NAME;
        //create sqlite database object
        //access getReadableDatabase method
        SQLiteDatabase db= this.getReadableDatabase();

        //create cursor object
        Cursor cursor = null;

        //checking there is any data in database
        if(db != null){

            //insert raw query data in cursor object
           cursor =  db.rawQuery(query, null);

        }

        return cursor;

    }

    void UpdateData(String row_id, String Account_Name, String  Account_Type, String Amount){
         SQLiteDatabase db = this.getWritableDatabase();
         ContentValues  cv =new ContentValues();
         cv.put(COLUMN_TITLE, Account_Name);
        cv.put(COLUMN_TYPE, Account_Type);
        cv.put(COLUMN_AMOUNT, Amount);

        long result = db.update(TABLE_NAME, cv, "Account_id=?", new String[]{row_id});

        if(result == -1){
            Toast.makeText(context, "Update failed ", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Updated Successfully.  ", Toast.LENGTH_SHORT).show();
        }
    }



    void deleteOneRow(String row_id){
         SQLiteDatabase db = this.getWritableDatabase();
         long result = db.delete(TABLE_NAME, "Account_id=?", new String[]{row_id});
        //db.execSQL("DELETE FROM SQLITE_SEQUENCE WHERE NAME = '" + TABLE_NAME + "'");
         if(result == -1){
             Toast.makeText(context,"Fail to delete !", Toast.LENGTH_SHORT).show();
         }else{
             Toast.makeText(context,"Delete Successfully !", Toast.LENGTH_SHORT).show();
         }
    }



    void deleteAllData(){
         SQLiteDatabase db = this.getWritableDatabase();
         db.execSQL("DELETE FROM "+ TABLE_NAME);
         db.execSQL("DELETE FROM SQLITE_SEQUENCE WHERE NAME = '" + TABLE_NAME + "'");
    }

   public float sumTotalIncome(){

        SQLiteDatabase db = this.getWritableDatabase();
        //return(db.execSQL("SELECT SUM ("+ COLUMN_AMOUNT +") FROM " + TABLE_NAME));

       Cursor c = db.rawQuery("SELECT SUM ("+ COLUMN_AMOUNT +") FROM " + TABLE_NAME,null);
       c.moveToFirst();
       float i = c.getFloat(0);
       c.close();
       return i;

    }

    public float remBalance(String accName){

        SQLiteDatabase db = this.getWritableDatabase();
         Cursor c1 = db.rawQuery("SELECT SUM (Amount) FROM expenses WHERE Account LIKE " + "'" + accName + "'",null);
        c1.moveToFirst();
        Float income = c1.getFloat(0);
        c1.close();

        return income;
    }


}
