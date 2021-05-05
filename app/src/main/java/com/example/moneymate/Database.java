package com.example.moneymate;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;


class Database extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "MoneyMate.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "expenses";
    private static final String COLUMN_ID = "Id";
    private static final String COLUMN_DATE = "Date";
    private static final String COLUMN_CATEGORY = "Category";
    private static final String COLUMN_ACCOUNT = "Account";
    private static final String COLUMN_AMOUNT = "Amount";

    public static final String newQuery = "CREATE TABLE " + "Income " + " (" + "Account_id" + " INTEGER PRIMARY KEY AUTOINCREMENT," +
    "Account_Name" + " TEXT," +
    "Account_Type" + " TEXT," +
    "Account_Amount" + " TEXT);";


    public Database(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String query =
                "CREATE TABLE " + TABLE_NAME +
                        "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                        COLUMN_CATEGORY + " TEXT," + COLUMN_ACCOUNT + " TEXT," + COLUMN_DATE + " DATE, " + COLUMN_AMOUNT + " NUMERIC(5,2));" ;
        db.execSQL(query);
        db.execSQL(newQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int il) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }

    void addExpense (String category,String account, String date, String amount) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_CATEGORY, category);
        cv.put(COLUMN_ACCOUNT,account);
        cv.put(COLUMN_DATE,date);
        cv.put(COLUMN_AMOUNT, amount);

        long result = db.insert (TABLE_NAME, null, cv);
        if(result == -1) {
            Toast.makeText(context, "Insertion Failed",Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Expense Added!",Toast.LENGTH_SHORT).show();
        }

    }
    Cursor readAllTransaction () {
        String query = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;
        if(db != null) {
            cursor = db.rawQuery(query, null);
        }
        return  cursor;
    }

    Cursor readAccountTable(){
        String query = "SELECT * FROM Income";
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query,null);
        }
        return cursor;
   }

   Cursor searchExpenseRow(String exId){

       String query = "SELECT * FROM " + TABLE_NAME + " WHERE Id LIKE " + "'" + exId + "'";
       SQLiteDatabase db = this.getWritableDatabase();

       Cursor cursor = null;
       if(db != null){
           cursor = db.rawQuery(query,null);
       }if (cursor.getCount() == 0){
           Toast.makeText(context,"Sorry no data found!",Toast.LENGTH_SHORT).show();
       }
       return cursor;
   }

   void updateExpenses(String exId, String exCategory,String exAccount,String exAmount){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("Category",exCategory);
        cv.put("Account",exAccount);
        cv.put("Amount",exAmount);

       long result = db.update(TABLE_NAME,cv,"Id=?", new String[]{exId});
       if(result == -1){
           Toast.makeText(context, "data update failed", Toast.LENGTH_SHORT).show();
       }else{
           Toast.makeText(context, "data updated successfully", Toast.LENGTH_SHORT).show();
       }
   }

    void deleteExpenseRow(String exId){


        Log.d("data came",exId);

        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete(TABLE_NAME,"Id=?",new String[]{exId});

        if(result == -1){
            Toast.makeText(context, "data deletion failed", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "data deleted successfully", Toast.LENGTH_SHORT).show();
        }
    }


    public float foodTotal(){

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c1 = db.rawQuery("SELECT SUM (Amount) FROM " + TABLE_NAME + " WHERE Category LIKE 'Food'",null);
        c1.moveToFirst();
        Float Food = c1.getFloat(0);
        c1.close();

        return Food;
    }

    public float travelTotal(){

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c1 = db.rawQuery("SELECT SUM (Amount) FROM " + TABLE_NAME + " WHERE Category LIKE 'Travel'",null);
        c1.moveToFirst();
        Float Travel = c1.getFloat(0);
        c1.close();

        return Travel;
    }

    public float shoppingTotal(){

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c1 = db.rawQuery("SELECT SUM (Amount) FROM " + TABLE_NAME + " WHERE Category LIKE 'Shopping'",null);
        c1.moveToFirst();
        Float Shopping = c1.getFloat(0);
        c1.close();

        return Shopping;
    }

    public float utilityTotal(){

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c1 = db.rawQuery("SELECT SUM (Amount) FROM " + TABLE_NAME + " WHERE Category LIKE 'Utility'",null);
        c1.moveToFirst();
        Float Utility = c1.getFloat(0);
        c1.close();

        return Utility;
    }

}
