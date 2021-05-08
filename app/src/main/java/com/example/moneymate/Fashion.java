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

public class Fashion extends AppCompatActivity {

    //creating variables
    EditText txtInFashionAmount;
    Button btnAdd,btnEdit;

    //creating variables for implement navigation intents
    ImageButton img_btn_budget,img_btn_savings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fashion);

        //get the values to variables
        txtInFashionAmount = findViewById(R.id.txtInFashionAmount);
        btnAdd = findViewById(R.id.btnFashionAdd);
        btnEdit = findViewById(R.id.btnFashionEdit);

        img_btn_budget = findViewById(R.id.budget);
        img_btn_savings = findViewById(R.id.savings);

        //set onclicklistner for save button
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Log.d("data<<<<<<<<",(txtInFashionAmount.getText().toString()));

                DbController dbController = new DbController(Fashion.this);

                dbController.addFashionBudget(txtInFashionAmount.getText().toString().trim());
                Intent intent = new Intent(Fashion.this,Budget.class);
                startActivity(intent);
            }
        });

        //set onclicklistner for edit button
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Amount = txtInFashionAmount.getText().toString();

                DbController dbController = new DbController(Fashion.this);

                dbController.editFashionAmount(Amount);
                Intent intent = new Intent(Fashion.this,Budget.class);
                startActivity(intent);
            }
        });

        //creating intents for navigate in between pages by bottom navigation bar
        img_btn_budget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_budget = new Intent(Fashion.this,Budget.class);
                startActivity(intent_budget);
            }
        });

        img_btn_savings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_savings = new Intent(Fashion.this, Savings.class);
                startActivity(intent_savings);
            }
        });

    }
}