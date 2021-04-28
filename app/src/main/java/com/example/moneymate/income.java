package com.example.moneymate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class income extends AppCompatActivity {

    RecyclerView recyclerView;
    Button add_btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_income);

        recyclerView = findViewById(R.id.recyclerView);
        add_btn =findViewById(R.id.add_btn);
        add_btn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(income.this, new_Account.class);
                startActivity(intent);
            }
        });
    }
}