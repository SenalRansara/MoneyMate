package com.example.moneymate;

/** this Page created by Walpola S.R.
 * IT19965550
 * MoneyMate
 * Set Budget and add Savings
 * Team Androiders
 * */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DbController extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME ="Budget.db";
    private static final int DATABASE_VERSION = 1;


    private static final String TABLE_NAME = "savings";
    private static final String TABLE_FOOD = "food";
    private static final String TABLE_FASHION = "fashion";
    private static final String TABLE_TRANSPORT = "transport";
    private static final String TABLE_UTILITY = "utility";

    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_TITLE = "description";
    private static final String COLUMN_AMOUNT = "amount";

    //table create for savings
    public static final String query = "CREATE TABLE " + TABLE_NAME +
            " ("+ COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            COLUMN_TITLE + " TEXT," + COLUMN_AMOUNT + " TEXT);";

    //table create for food
    public static final String query_food = "CREATE TABLE " + TABLE_FOOD +
            " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_AMOUNT + " TEXT);";

    //table create for fashion
    public static final String query_fashion = "CREATE TABLE " + TABLE_FASHION +
            " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_AMOUNT + " TEXT);";

    //table create for transport
    public static final String query_trans = "CREATE TABLE " + TABLE_TRANSPORT +
            " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_AMOUNT + " TEXT);";

    //table create for utiliy
    public static final String query_uti = "CREATE TABLE " + TABLE_UTILITY +
            " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_AMOUNT + " TEXT);";


    DbController(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //executing the queries
    db.execSQL(query);
    db.execSQL(query_food);
    db.execSQL(query_fashion);
    db.execSQL(query_trans);
    db.execSQL(query_uti);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
    //creating data in savings table
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
    //read data from savings table
    Cursor retrieveData() {
        String query = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if (db != null) {
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }

    //update data in saving table
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

    //delete the data rows in savings table
    void deleteRow(String row_id){
        SQLiteDatabase db = this.getWritableDatabase();

        long result = db.delete(TABLE_NAME,"_id=?",new String[]{row_id});
        if(result == -1){
            Toast.makeText(context,"Deletion Failed", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context,"Deleted Successfully", Toast.LENGTH_SHORT).show();
        }
    }

    //add details to food table

    void addFoodBudget(String amount){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("_id", "1");
        cv.put("amount", amount);

        long result = db.insert(TABLE_FOOD,null,cv);
        if(result == -1){
            Toast.makeText(context, "data insertion failed", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "added successfully", Toast.LENGTH_SHORT).show();
            /*Intent intent = new Intent(context,AddMeal.class);
            intent.putExtra("retValue", result);
            context.sendBroadcast(intent);*/
        }

    }

    //add details to fashion table
    void addFashionBudget(String amount){

        Log.d("data came <<<<<<<<<<<<",amount);
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("_id", "1");
        cv.put("amount", amount);

        long result = db.insert(TABLE_FASHION,null,cv);
        if(result == -1){
            Toast.makeText(context, "data insertion failed", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "added successfully", Toast.LENGTH_SHORT).show();
            /*Intent intent = new Intent(context,AddMeal.class);
            intent.putExtra("retValue", result);
            context.sendBroadcast(intent);*/
        }

    }
    //add details to transport table
    void addTransportBudget(String amount){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("_id", "1");
        cv.put("amount", amount);

        long result = db.insert(TABLE_TRANSPORT,null,cv);
        if(result == -1){
            Toast.makeText(context, "data insertion failed", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "added successfully", Toast.LENGTH_SHORT).show();
            /*Intent intent = new Intent(context,AddMeal.class);
            intent.putExtra("retValue", result);
            context.sendBroadcast(intent);*/
        }
    }

    //add details to utility table
    void addUtilityBudget(String amount){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("_id", "1");
        cv.put("amount", amount);

        long result = db.insert(TABLE_UTILITY,null,cv);
        if(result == -1){
            Toast.makeText(context, "data insertion failed", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "added successfully", Toast.LENGTH_SHORT).show();
            /*Intent intent = new Intent(context,AddMeal.class);
            intent.putExtra("retValue", result);
            context.sendBroadcast(intent);*/
        }
    }

    //read data from food table
    Cursor readFoodBudget(){
        String query = "SELECT * FROM " + TABLE_FOOD;
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query,null);
        }
        return cursor;
    }

    //read data from fashion table
    Cursor readFashionBudget(){
        String query = "SELECT * FROM " + TABLE_FASHION;
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query,null);
        }
        return cursor;
    }

    //read data from transport table
    Cursor readTransBudget(){
        String query = "SELECT * FROM " + TABLE_TRANSPORT;
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query,null);
        }
        return cursor;
    }

    //read data from utility table
    Cursor readUtilityBudget(){
        String query = "SELECT * FROM " + TABLE_UTILITY;
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query,null);
        }
        return cursor;
    }

    //update table data in food table
    void editFoodAmount(String amount){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("_id", "1");
        cv.put("amount", amount);

        long result = db.update(TABLE_FOOD,cv,"_id=?", new String[]{"1"});
        if(result == -1){
            Toast.makeText(context, "data update failed", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "updated successfully", Toast.LENGTH_SHORT).show();
        }
    }

    //update table data in food table
    void editFashionAmount(String amount){
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues cv = new ContentValues();

            cv.put("_id", "1");
            cv.put("amount", amount);

            long result = db.update(TABLE_FASHION,cv,"_id=?", new String[]{"1"});
            if(result == -1){
                Toast.makeText(context, "data update failed", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(context, "updated successfully", Toast.LENGTH_SHORT).show();
            }
        }

    //update table data in transport table
    void editTransAmount(String amount){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("_id", "1");
        cv.put("amount", amount);

        long result = db.update(TABLE_TRANSPORT,cv,"_id=?", new String[]{"1"});
        if(result == -1){
            Toast.makeText(context, "data update failed", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "updated successfully", Toast.LENGTH_SHORT).show();
        }
    }

    //update table data in utility table
    void editUtilityAmount(String amount){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        //Log.d("<<<<<<< came",amount);

        cv.put("_id", "1");
        cv.put("amount", amount);

        long result = db.update(TABLE_UTILITY,cv,"_id=?", new String[]{"1"});
        if(result == -1){
            Toast.makeText(context, "data update failed", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "updated successfully", Toast.LENGTH_SHORT).show();
        }

    }

}


