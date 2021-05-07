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

public class Utility extends AppCompatActivity {

    //creating variables
    EditText txtInUtilityAmount;
    Button btnAdd,btnEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_utility);

        //get the values to variables
        txtInUtilityAmount = findViewById(R.id.txtInUtilityAmount);
        btnAdd = findViewById(R.id.btnUtilityAdd);
        btnEdit = findViewById(R.id.btnUtilityEdit);

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
    }
}