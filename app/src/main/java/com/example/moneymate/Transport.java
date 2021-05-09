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

public class Transport extends AppCompatActivity {

    //creating variables
    EditText txtInTransAmount;
    Button btnAdd,btnEdit;

    //creating variables for implement navigation intents
    ImageButton img_btn_budget,img_btn_savings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transport);

        //get the values to variables
        txtInTransAmount = findViewById(R.id.txtInTransportAmount);
        btnAdd = findViewById(R.id.btnTransportAdd);
        btnEdit = findViewById(R.id.btnTransportEdit);

        img_btn_budget = findViewById(R.id.budgetMenu4);
        img_btn_savings = findViewById(R.id.budgetMenu5);

        //set onclicklistner for save button
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DbController dbController = new DbController(Transport.this);

                dbController.addTransportBudget(txtInTransAmount.getText().toString().trim());
                Intent intent = new Intent(Transport.this,Budget.class);
                startActivity(intent);
            }
        });
        //set onclicklistner for edit button
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Amount = txtInTransAmount.getText().toString();

                DbController dbController = new DbController(Transport.this);

                dbController.editTransAmount(Amount);
                Intent intent = new Intent(Transport.this,Budget.class);
                startActivity(intent);
            }
        });

        //creating intents for navigate in between pages by bottom navigation bar
        img_btn_budget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_budget = new Intent(Transport.this,Budget.class);
                startActivity(intent_budget);
            }
        });

        img_btn_savings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_savings = new Intent(Transport.this, Savings.class);
                startActivity(intent_savings);
            }
        });


    }
}