package com.example.moneymate;

/** this Page created by Walpola S.R.
 * IT19965550
 * MoneyMate
 * Set Budget and add Savings
 * Team Androiders
 * */

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class Budget extends AppCompatActivity {

    //creating variables for implement navigation intents
    ImageButton img_btn_budget,img_btn_savings,incomeMenu,expenseMenu,calculateMenu,budgetMenu,savingMenu;

    TextView txtFood,txtFashion,txtTransport,txtUtility;

    //references for buttons in budget page
    Button buttonOne;
    Button buttonTwo;
    Button buttonThree;
    Button buttonFour;

    DbController dbController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_budget);

        //get the values to the variables
        txtFood = findViewById(R.id.txtViewFood);
        txtFashion = findViewById(R.id.txtViewFashion);
        txtTransport = findViewById(R.id.txtViewTrans);
        txtUtility = findViewById(R.id.txtViewUtility);


        dbController = new DbController(getApplicationContext());
        Cursor cursor1 = dbController.readFoodBudget();
        Cursor cursor2 = dbController.readFashionBudget();
        Cursor cursor3 = dbController.readTransBudget();
        Cursor cursor4 = dbController.readUtilityBudget();

        if(cursor1.moveToFirst()){
            txtFood.setText(cursor1.getString(1));
        }

        if(cursor2.moveToFirst()){
            txtFashion.setText(cursor2.getString(1));
        }

        if(cursor3.moveToFirst()){
            txtTransport.setText(cursor3.getString(1));
        }

        if(cursor4.moveToFirst()){
            txtUtility.setText(cursor4.getString(1));
        }


        //linking the buttons for navigate between pages
        incomeMenu = findViewById(R.id.budgetMenu1);
        expenseMenu = findViewById(R.id.budgetMenu2);
        calculateMenu = findViewById(R.id.budgetMenu3);
        budgetMenu = findViewById(R.id.budgetMenu4);
        savingMenu = findViewById(R.id.budgetMenu5);

        img_btn_budget = findViewById(R.id.budgetMenu4);
        img_btn_savings = findViewById(R.id.budgetMenu5);


        incomeMenu = findViewById(R.id.budgetMenu1);

        //TOOLBAR BUTTON SET
        incomeMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Budget.this, MainActivity.class);
                startActivity(intent);
            }
        });


        expenseMenu = findViewById(R.id.budgetMenu2);

        //TOOLBAR BUTTON SET
        expenseMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Budget.this, MainActivity.class);
                startActivity(intent);
            }
        });

        calculateMenu = findViewById(R.id.budgetMenu3);

        //TOOLBAR BUTTON SET
        calculateMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Budget.this, CurrencyConverter.class);
                startActivity(intent);
            }
        });

        budgetMenu = findViewById(R.id.budgetMenu4);

        //TOOLBAR BUTTON SET
        budgetMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Budget.this, Budget.class);
                startActivity(intent);
            }
        });

        savingMenu = findViewById(R.id.budgetMenu5);

        //TOOLBAR BUTTON SET
        savingMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Budget.this, Savings.class);
                startActivity(intent);
            }
        });

        //implementing the intents for Food Button
        buttonOne.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent_01 = new Intent(Budget.this,Food.class);
                startActivity(intent_01);
            }
        });

        //implementing the intents for Fashion Button
        buttonTwo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent_02 = new Intent(Budget.this,Fashion.class);
                startActivity(intent_02);
            }
        });

        //implementing the intents for Transport Button
        buttonThree.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent_03 = new Intent(Budget.this,Transport.class);
                startActivity(intent_03);
            }
        });

        //implementing the intents for Utility Button
        buttonFour.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent_04 = new Intent(Budget.this,Utility.class);
                startActivity(intent_04);
            }
        });

        //creating intents for navigate in between pages by bottom navigation bar
        img_btn_budget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_budget = new Intent(Budget.this,Budget.class);
                startActivity(intent_budget);
            }
        });

        img_btn_savings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_savings = new Intent(Budget.this, Savings.class);
                startActivity(intent_savings);
            }
        });


    }
}