package com.example.moneymate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Budget extends AppCompatActivity {

    //references for buttons in budget page
    Button buttonOne;
    Button buttonTwo;
    Button buttonThree;
    Button buttonFour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_budget);

        //linking the buttons
        buttonOne = findViewById(R.id.btn_1);
        buttonTwo = findViewById(R.id.btn_2);
        buttonThree = findViewById(R.id.btn_3);
        buttonFour = findViewById(R.id.btn_4);

        //implementing the intents for buttons
        buttonOne.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent_01 = new Intent(getApplicationContext(),Food.class);
                startActivity(intent_01);
            }
        });

        buttonTwo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent_02 = new Intent(getApplicationContext(),Fashion.class);
                startActivity(intent_02);
            }
        });

        buttonThree.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent_03 = new Intent(getApplicationContext(),Transport.class);
                startActivity(intent_03);
            }
        });

        buttonFour.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent_04 = new Intent(getApplicationContext(),Utility.class);
                startActivity(intent_04);
            }
        });


    }
}