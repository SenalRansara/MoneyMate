package com.example.moneymate;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
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


    public Database(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String query =
                "CREATE TABLE " + TABLE_NAME +
                        "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        COLUMN_CATEGORY + "STRING" + COLUMN_AMOUNT + " NUMERIC(5,2)); " ;
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int il) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }

    void addExpense (String amount) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

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
}
