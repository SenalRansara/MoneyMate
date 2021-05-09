package com.example.moneymate;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class Choose_category extends AppCompatActivity {

    Button food_select,travel_select,shopping_select,utility_select;

    String clickedBtn;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_category);

        String account = getIntent().getStringExtra("Account");

        food_select = findViewById(R.id.food_select);
        travel_select = findViewById(R.id.travel_select);
        shopping_select = findViewById(R.id.shopping_select);
        utility_select = findViewById(R.id.utility_select);

        food_select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                clickedBtn = String.valueOf(food_select.getText());
                Toast.makeText(getApplicationContext(),"Food Category Selected!",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(),add_new_expense.class);
                intent.putExtra("category",clickedBtn);
                intent.putExtra("account",account);
                startActivity(intent);

            }
        });

        travel_select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                clickedBtn = String.valueOf(travel_select.getText());
                Toast.makeText(getApplicationContext(),"Travel Category Selected!",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(),add_new_expense.class);
                intent.putExtra("category",clickedBtn);
                intent.putExtra("account",account);
                startActivity(intent);


            }
        });

        shopping_select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                clickedBtn = String.valueOf(shopping_select.getText());
                Toast.makeText(getApplicationContext(),"Shopping Category Selected!",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(),add_new_expense.class);
                intent.putExtra("category",clickedBtn);
                intent.putExtra("account",account);
                startActivity(intent);


            }
        });

        utility_select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                clickedBtn = String.valueOf(utility_select.getText());
                Toast.makeText(getApplicationContext(),"Utility Category Selected!",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(),add_new_expense.class);
                intent.putExtra("category",clickedBtn);
                intent.putExtra("account",account);
                startActivity(intent);


            }
        });
    }
}