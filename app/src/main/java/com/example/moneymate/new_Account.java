package com.example.moneymate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class new_Account extends AppCompatActivity {

    //creating objects for UI elements
    EditText inputAccName, inputAccType, inputAccBalance;
    Button SaveNewBtn;

    /*String price;
    Float num = Float.valueOf(price);
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new__account);

        //find id of add account form UI elements
        inputAccName = findViewById(R.id.inputAccName);
        inputAccType = findViewById(R.id.inputAccType);
        inputAccBalance = findViewById(R.id.inputAccBalance);
        SaveNewBtn = findViewById(R.id.SaveNewBtn);

        SaveNewBtn.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View view) {

                //creating objects of Database helper class
                DataBaseHelper myDB = new DataBaseHelper(new_Account.this);

                //getting data from three edit text and convert to string and pass to datbase
                myDB.addAccount(inputAccName.getText().toString().trim() ,
                        inputAccType.getText().toString().trim() ,
                        inputAccBalance.getText().toString().trim());

                /*inputAccName.setText("");
                inputAccType.setText("");
                inputAccBalance.setText("");*/

                Intent intent = new Intent(new_Account.this, income.class);
                startActivity(intent);
                finish();

            }
        });


    }
}