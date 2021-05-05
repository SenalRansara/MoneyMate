package com.example.moneymate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    TextView total_food,total_travel,total_shopping,total_utility;

    RecyclerView recyclerView;
    FloatingActionButton add_new_expense,transaction_history;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        total_food = findViewById(R.id.total_food);
        total_travel = findViewById(R.id.total_travel);
        total_shopping = findViewById(R.id.total_shopping);
        total_utility = findViewById(R.id.total_utility);

        recyclerView = findViewById(R.id.recyclerView);
        add_new_expense = findViewById(R.id.add_new_expense);
        transaction_history = findViewById(R.id.transaction_history);

        Database db = new Database(MainActivity.this);

        Float totFood = db.foodTotal();
        Float totTravel = db.travelTotal();
        Float totShopping = db.shoppingTotal();
        Float totUtility = db.utilityTotal();

        total_food.setText(String.valueOf(totFood));
        total_travel.setText(String.valueOf(totTravel));
        total_shopping.setText(String.valueOf(totShopping));
        total_utility.setText(String.valueOf(totUtility));

        add_new_expense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent  = new Intent(MainActivity.this, Select_Account.class);
                startActivity(intent);
            }
        });

        transaction_history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent  = new Intent(MainActivity.this, TransactionList.class);
                startActivity(intent);
            }
        });
    }
}