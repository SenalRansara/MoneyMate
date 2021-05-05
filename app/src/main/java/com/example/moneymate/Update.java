package com.example.moneymate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Update extends AppCompatActivity {

    TextView update_cat_name,update_account_name,update_amount;
    EditText exCategory,exAccount,exAmount;
    Button btnUpdate,btnDelete;

    Database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        update_cat_name = findViewById(R.id.update_cat_name);
        update_account_name = findViewById(R.id.update_account_name);
        update_amount = findViewById(R.id.update_amount);


        exCategory = findViewById(R.id.exCategory);
        exAccount = findViewById(R.id.exAccount);
        exAmount = findViewById(R.id.exAmount);

        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);

        String Id = getIntent().getStringExtra("exId");
        String Category = getIntent().getStringExtra("exCategory");
        String Account = getIntent().getStringExtra("exAccount");
        String Amount = getIntent().getStringExtra("exAmount");


        Log.d("came<<<<<<<<<", Id);
        Log.d("came<<<<<<<<<", Category);
        Log.d("came<<<<<<<<<", Account);
        Log.d("came<<<<<<<<<", Amount);

        db = new Database(getApplicationContext());
        Cursor cursor = db.searchExpenseRow(Id);

        if(cursor.moveToFirst()){

            update_cat_name.setText(cursor.getString(1));
            update_account_name.setText(cursor.getString(2));
            update_amount.setText(cursor.getString(4));

            exCategory.setText(cursor.getString(1));
            exAccount.setText(cursor.getString(2));
            exAmount.setText(cursor.getString(4));
        }

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Database db = new Database(Update.this);
                db.updateExpenses(
                        Id,
                        exCategory.getText().toString().trim(),
                        exAccount.getText().toString().trim(),
                        exAmount.getText().toString().trim()
                );

                Intent intent = new Intent(Update.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Database db = new Database(Update.this);
                db.deleteExpenseRow(Id);

                Intent intent = new Intent(Update.this, MainActivity.class);
                startActivity(intent);
                finish();

            }
        });
    }
}