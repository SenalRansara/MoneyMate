package com.example.moneymate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class Select_Account extends AppCompatActivity {

    RecyclerView recyclerView;

    Database db;
    ArrayList<String> accId, accName;
    SelectAccountAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select__account);

        recyclerView = findViewById(R.id.account_recycler);

        db = new Database(Select_Account.this);
        accId = new ArrayList<>();
        accName = new ArrayList<>();

        storeAccDetails();

        customAdapter = new SelectAccountAdapter(Select_Account.this,accId,accName);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(Select_Account.this));
    }

    void storeAccDetails(){
        Cursor cursor = db.readAccountTable();
        if(cursor.getCount() == 0){
            Toast.makeText(this,"no data found", Toast.LENGTH_SHORT).show();
        }else{
            while (cursor.moveToNext()){
                accId.add(cursor.getString(0));
                accName.add(cursor.getString(1));
            }
        }
    }
}