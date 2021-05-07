package com.example.moneymate;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DbController extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME ="Budget.db";
    private static final int DATABASE_VERSION = 1;


    private static final String TABLE_NAME = "savings";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_TITLE = "description";
    private static final String COLUMN_AMOUNT = "amount";


    DbController(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    String query = "CREATE TABLE " + TABLE_NAME +
            " ("+ COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                COLUMN_TITLE + " TEXT," +
                COLUMN_AMOUNT + " TEXT);";
    db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    void AddSavings(String description, String amount){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_TITLE,description);
        cv.put(COLUMN_AMOUNT,amount);


        long result = db.insert(TABLE_NAME,null,cv);
        if(result == -1){
        Toast.makeText(context,"Failed",Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(context,"Added Successfully!",Toast.LENGTH_SHORT).show();
        }
    }

    Cursor retrieveData() {
        String query = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if (db != null) {
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }

    void updateData(String row_id, String des, String amount){
         SQLiteDatabase db = this.getWritableDatabase();
         ContentValues cv = new ContentValues();

         cv.put(COLUMN_TITLE, des);
         cv.put(COLUMN_AMOUNT, amount);

         long result = db.update(TABLE_NAME, cv,"_id=?", new String[]{row_id});
         if(result == -1){
             Toast.makeText(context,"Failed to Update!", Toast.LENGTH_SHORT).show();
         }else{
             Toast.makeText(context,"Updated Successfully!", Toast.LENGTH_SHORT).show();
         }

    }
}