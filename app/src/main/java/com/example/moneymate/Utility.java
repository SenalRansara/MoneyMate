package com.example.moneymate;

/* this Page created by Walpola S.R.
 * IT19965550
 * */

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class Utility extends AppCompatActivity {

    //creating variables
    EditText txtInUtilityAmount;
    Button btnAdd,btnEdit;

    //creating variables for implement navigation intents
    ImageButton img_btn_budget,img_btn_savings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_utility);

        //get the values to variables
        txtInUtilityAmount = findViewById(R.id.txtInUtilityAmount);
        btnAdd = findViewById(R.id.btnUtilityAdd);
        btnEdit = findViewById(R.id.btnUtilityEdit);

        img_btn_budget = findViewById(R.id.budget);
        img_btn_savings = findViewById(R.id.savings);

        //set onclicklistner for save button
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DbController dbController = new DbController(Utility.this);

                dbController.addUtilityBudget(txtInUtilityAmount.getText().toString().trim());
                Intent intent = new Intent(Utility.this,Budget.class);
                startActivity(intent);
            }
        });

        //set onclicklistner for edit button
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Amount = txtInUtilityAmount.getText().toString();
                //Log.d("<<<<<<<",Amount);
                DbController dbController = new DbController(Utility.this);

                dbController.editUtilityAmount(Amount);
                Intent intent = new Intent(Utility.this,Budget.class);
                startActivity(intent);
            }
        });

        //creating intents for navigate in between pages by bottom navigation bar
        img_btn_budget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_budget = new Intent(Utility.this,Budget.class);
                startActivity(intent_budget);
            }
        });

        img_btn_savings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_savings = new Intent(Utility.this, Savings.class);
                startActivity(intent_savings);
            }
        });

    }
}