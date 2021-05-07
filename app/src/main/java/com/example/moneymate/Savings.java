package com.example.moneymate;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class Savings extends AppCompatActivity {

    RecyclerView recyclerView;
    FloatingActionButton add_btn;

    DbController db;
    ArrayList<String> id,des,amount;
    BudgetAdapter budgetAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_savings);

        recyclerView = findViewById(R.id.recycler);
        add_btn = findViewById(R.id.add_button);
        add_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent_05 = new Intent(Savings.this, AddSavings.class);
                startActivity(intent_05);
            }
        });

        db = new DbController(Savings.this);
        id = new ArrayList<>();
        des = new ArrayList<>();
        amount = new ArrayList<>();

        getData();

        budgetAdapter = new BudgetAdapter(Savings.this,this,id,des,amount);
        recyclerView.setAdapter(budgetAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(Savings.this));

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1){
            recreate();
        }

    }

    void getData(){
        Cursor cursor = db.retrieveData();
        if(cursor.getCount() == 0){
            Toast.makeText(this,"No Data",Toast.LENGTH_SHORT).show();
        }else{
            while(cursor.moveToNext()){
                id.add(cursor.getString(0));
                des.add(cursor.getString(1));
                amount.add(cursor.getString(2));
            }
        }
    }

}