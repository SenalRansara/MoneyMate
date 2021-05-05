package com.example.moneymate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class add_new_expense extends AppCompatActivity {

    EditText  category_input, account_input, amount;
    Button confirm_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_expense);

//        date_input = findViewById((R.id.date_input);
//        category_input = findViewById((R.id.category_input);
//        account_input = findViewById((R.id.account_input);
        amount = findViewById(R.id.amount);
        confirm_button = findViewById(R.id.confirm_button);
        confirm_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Database myDB = new Database(add_new_expense.this);
                myDB.addExpense(amount.getText().toString().trim());


            }
        });

        String date_n = new SimpleDateFormat("MMM dd, yyyy", Locale.getDefault()).format(new Date());

        TextView tv_date  = (TextView) findViewById(R.id.dateShow);
        tv_date.setText(date_n);
    }
}