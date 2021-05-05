package com.example.moneymate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class TransactionList extends AppCompatActivity {

    RecyclerView recyclerView;

    Database db;
    ArrayList<String> exId,exCategory,exAccount,exAmount;
    TransactionAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction_list);


        recyclerView = findViewById(R.id.transaction_recycler);

        db = new Database(TransactionList.this);
        exId = new ArrayList<>();
        exCategory = new ArrayList<>();
        exAccount = new ArrayList<>();
        exAmount = new ArrayList<>();

        storeTransactionDetails();

        customAdapter = new TransactionAdapter(TransactionList.this,exId,exCategory,exAccount,exAmount);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(TransactionList.this));
    }

    void storeTransactionDetails(){
        Cursor cursor = db.readAllTransaction();
        if(cursor.getCount() == 0){
            Toast.makeText(this,"no data found", Toast.LENGTH_SHORT).show();
        }else{
            while (cursor.moveToNext()){
                exId.add(cursor.getString(0));
                exCategory.add(cursor.getString(1));
                exAccount.add(cursor.getString(2));
                exAmount.add(cursor.getString(4));
            }
        }
    }
}