package com.example.moneymate;
/* this Page created by Walpola S.R.
 * IT19965550
 * */

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Food extends AppCompatActivity {

    //creating variables
    EditText txtInFoodAmount;
    Button btnAdd,btnEdit;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        //get the values to variables
        txtInFoodAmount = findViewById(R.id.txtInFoodAmount);
        btnAdd = findViewById(R.id.btnFoodAdd);
        btnEdit = findViewById(R.id.btnFoodEdit);

        //set onclicklistner for save button
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DbController dbController = new DbController(Food.this);

                dbController.addFoodBudget(txtInFoodAmount.getText().toString().trim());
                Intent intent = new Intent(Food.this,Budget.class);
                startActivity(intent);
            }
        });

        //set onclicklistner for edit button
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String foodAmount = txtInFoodAmount.getText().toString();

                DbController dbController = new DbController(Food.this);

                dbController.editFoodAmount(foodAmount);
                Intent intent = new Intent(Food.this,Budget.class);
                startActivity(intent);
            }
        });
    }
}