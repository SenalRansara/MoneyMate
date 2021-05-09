package com.example.moneymate;

import android.accounts.Account;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


public class DataBaseHandler extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "MoneyMate.db"; //USER_RECORD
    private static final String TABLE_NAME = "USER_DATA";
    private static final String COL_1 = "ID";
    private static final String COL_2 = "USERNAME";
    private static final String COL_3 = "EMAIL";
    private static final String COL_4 = "PASSWORD";

    public static final String queryExpense = "CREATE TABLE " + "expenses" +
            "(" + "Id" + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            "Category" + " TEXT," + "Account" + " TEXT," + "Date" + " DATE, " + "Amount" + " NUMERIC(5,2));" ;

    public static final String queryIncome = "CREATE TABLE " + "Income " + " (" + "Account_id" + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            "Account_Name" + " TEXT," +
            "Account_Type" + " TEXT," +
            "Account_Amount" + " TEXT);";

    public DataBaseHandler(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT , USERNAME TEXT UNIQUE, EMAIL TEXT, PASSWORD TEXT)");
        db.execSQL(queryExpense);
        db.execSQL(queryIncome);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME);
            onCreate(db);
    }

    public boolean registerUser(String username , String email , String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_2 , username);
        values.put(COL_3 , email);
        values.put(COL_4 , password);

        long result = db.insert(TABLE_NAME , null , values);
        return result != -1;

    }

    public boolean updatepassword(String username , String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_4, password);

        long result = db.update(TABLE_NAME ,values , "USERNAME =?", new String[] {username} );
        return result != -1;

    }



    public boolean checkUser(String username , String password){
        SQLiteDatabase db = this.getWritableDatabase();
        String [] columns = { COL_1 };
        String selection = COL_2 + "=?" + " and " + COL_4 + "=?";
        String [] selectionargs = { username , password};
        Cursor cursor = db.query(TABLE_NAME , columns , selection , selectionargs , null ,null , null);
        int count = cursor.getCount();
        db.close();
        cursor.close();
        return count > 0;

    }


    public Boolean checkusername(String username) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        String [] columns = { COL_1 };
        String selection = COL_2 + "=?";
        String [] selectionargs = {username};
        Cursor cursor = MyDB.query(TABLE_NAME , columns , selection , selectionargs , null,null,null);
        int count = cursor.getCount();
        cursor.close();
        return cursor.getCount() > 0;

    }



    //Cursor SearchUser(String username){
    //    String query = "SELECT * FROM " + TABLE_NAME + " WHERE USERNAME LIKE " + "'" + username + "'";
    //    SQLiteDatabase db = this.getWritableDatabase();
    //    Cursor cursor = null;
    //    if(db != null){
    //        cursor = db.rawQuery(query,null);
    //    }if (cursor.getCount() == 0){
    //        Toast.makeText(context,"Sorry no data found!",Toast.LENGTH_SHORT).show();
    //    }
    //    return cursor;
    //}

}