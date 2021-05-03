package com.example.moneymate;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class income extends AppCompatActivity {

    //total income
//    private TextView totalIncomeResults;


    RecyclerView recyclerView;
    Button add_btn;

    DataBaseHelper myDB;
    ArrayList<String> Account_id, Account_Name, Account_Type, Amount;
    CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_income);

//        totalIncomeResults = findViewById(R.id.totIncome);

        recyclerView = findViewById(R.id.recyclerView);
        add_btn = findViewById(R.id.add_btn);
        add_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(income.this, new_Account.class);
                startActivity(intent);
            }
        });

        myDB = new DataBaseHelper(income.this);
        Account_id = new ArrayList<>();
        Account_Name = new ArrayList<>();
        Account_Type = new ArrayList<>();
        Amount = new ArrayList<>();

        displayData();
        customAdapter =new CustomAdapter(income.this, this, Account_id, Account_Name, Account_Type, Amount);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(income.this));




    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode ==1){
            recreate();
        }
    }

    void displayData(){

        Cursor cursor =myDB.readAllData();
        if(cursor.getCount() == 0){
            Toast.makeText(this, "No data.", Toast.LENGTH_SHORT ).show();
        }else{
           while (cursor.moveToNext()) {
                Account_id.add(cursor.getString(0));
               Account_Name.add(cursor.getString(1));
               Account_Type.add(cursor.getString(2));
               Amount.add(cursor.getString(3));
            }
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater =getMenuInflater();
        inflater.inflate(R.menu.my_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId() == R.id.delete_all){
            ConfirmDeleteAll();
        }
        return super.onOptionsItemSelected(item);
    }




    void ConfirmDeleteAll(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete all Accounts ?");
        builder.setMessage("Are you sure you want to delete all Accounts ?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                DataBaseHelper myDB = new DataBaseHelper(income.this);
                myDB.deleteAllData();
                // refresh activity
                Intent intent =new Intent(income.this, income.class);
                startActivity(intent);
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

//    void SumIncome(){
//        float cursor =myDB.sumTotalIncome();
//
//
//
//    }
}