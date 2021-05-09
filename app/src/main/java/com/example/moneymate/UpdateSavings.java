package com.example.moneymate;

/** this Page created by Walpola S.R.
 * IT19965550
 * MoneyMate
 * Set Budget and add Savings
 * Team Androiders
 * */

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class UpdateSavings extends AppCompatActivity {

    //creating variables
    EditText des,amount;
    Button update_button, delete_button;

    //creating variables for implement navigation intents
    ImageButton img_btn_budget,img_btn_savings;

    String aid,description,amnt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_savings);

        //get the values to variables
        des = findViewById(R.id.editText4);
        amount = findViewById(R.id.editText3);
        update_button = findViewById(R.id.update_btn);
        delete_button = findViewById(R.id.delete_btn);

        img_btn_budget = findViewById(R.id.budgetMenu4);
        img_btn_savings = findViewById(R.id.budgetMenu5);

        //calling the get intent data method
        getIntentData();

        update_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DbController Db = new DbController(UpdateSavings.this);
                description = des.getText().toString().trim();
                amnt = amount.getText().toString().trim();
                Db.updateData(aid, description, amnt);

            }
        });
        //set onclicklistner for delete button
        delete_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirmText();

            }
        });

        //creating intents for navigate in between pages by bottom navigation bar
        img_btn_budget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_budget = new Intent(UpdateSavings.this,Budget.class);
                startActivity(intent_budget);
            }
        });

        img_btn_savings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_savings = new Intent(UpdateSavings.this, Savings.class);
                startActivity(intent_savings);
            }
        });


    }
    //create a method for get intent data
    void getIntentData(){
        if(getIntent().hasExtra("aid") && getIntent().hasExtra("description") && getIntent().hasExtra("amnt")){

            //getting data from intent
            aid = getIntent().getStringExtra("aid");
            description = getIntent().getStringExtra("description");
            amnt = getIntent().getStringExtra("amnt");

            //setting Intent data
            des.setText(description);
            amount.setText(amnt);

        }else{
            Toast.makeText(this,"No data",Toast.LENGTH_SHORT).show();
        }
    }

    //create a method for popup dialogue box
    void confirmText(){
    AlertDialog.Builder builder = new AlertDialog.Builder(this);
    builder.setTitle("Delete " + description + " ?");
    builder.setMessage("Are you sure want to delete " + description + " ?");
    builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            DbController Db = new DbController(UpdateSavings.this);
            Db.deleteRow(aid);
            finish();
        }
    });

    builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {

        }
    });

    builder.create().show();
    }
}