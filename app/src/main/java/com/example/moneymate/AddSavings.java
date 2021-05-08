package com.example.moneymate;
/* this Page created by Walpola S.R.
* IT19965550
* */


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddSavings extends AppCompatActivity {

    //creating variables
    EditText description,amount;
    Button add_btn;

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
    }
}