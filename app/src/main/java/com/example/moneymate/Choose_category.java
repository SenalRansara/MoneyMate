package com.example.moneymate;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Choose_category extends AppCompatActivity {

    EditText food_select,travel_select,shopping_select,utility_select;
    Button category_next;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_category);

        food_select = findViewById(R.id.food_select);
        travel_select = findViewById(R.id.travel_select);
        shopping_select = findViewById(R.id.shopping_select);
        utility_select = findViewById(R.id.utility_select);

        category_next = findViewById(R.id.category_next);
        category_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Database myDB = new Database(Choose_category.this);
                myDB.addExpense(food_select.getText().toString().trim());


            }
        });
    }
}