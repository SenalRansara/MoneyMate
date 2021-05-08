package com.example.moneymate;

/** this Page created by Walpola S.R.
 * IT19965550
 * MoneyMate
 * Set Budget and add Savings
 * Team Androiders
 * */


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class AddSavings extends AppCompatActivity {

    //creating variables
    EditText description,amount;
    Button add_btn;

    //creating variables for implement navigation intents
    ImageButton img_btn_budget,img_btn_savings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_savings);

        //get the values to variables

        description = findViewById(R.id.editText2);
        amount = findViewById(R.id.editText1);
        add_btn = findViewById(R.id.btn_6);

        //implementing the add button
        add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              DbController db = new DbController(AddSavings.this);
              db.AddSavings(description.getText().toString().trim(),
                      amount.getText().toString().trim());
            }
        });

        img_btn_budget = findViewById(R.id.budget);
        img_btn_savings = findViewById(R.id.savings);

        //creating intents for navigate in between pages by bottom navigation bar
        img_btn_budget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_budget = new Intent(AddSavings.this,Budget.class);
                startActivity(intent_budget);
            }
        });

        img_btn_savings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_savings = new Intent(AddSavings.this, Savings.class);
                startActivity(intent_savings);
            }
        });

    }
}