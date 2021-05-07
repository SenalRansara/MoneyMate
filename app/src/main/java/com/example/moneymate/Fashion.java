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

public class Fashion extends AppCompatActivity {

    //creating variables
    EditText txtInFashionAmount;
    Button btnAdd,btnEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fashion);

        //get the values to variables
        txtInFashionAmount = findViewById(R.id.txtInFashionAmount);
        btnAdd = findViewById(R.id.btnFashionAdd);
        btnEdit = findViewById(R.id.btnFashionEdit);

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
    }
}