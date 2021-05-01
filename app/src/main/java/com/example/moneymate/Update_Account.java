package com.example.moneymate;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Update_Account extends AppCompatActivity {


    EditText inputAccName, inputAccType, inputAccBalance;
    Button UpdateBtn,DeleteBtn;

    String Account_id, Account_Name, Account_Type, Amount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update__account);

        inputAccName = findViewById(R.id.inputAccName2);
        inputAccType =  findViewById(R.id.inputAccType2);
        inputAccBalance =  findViewById(R.id.inputAccBalance2);
        UpdateBtn =  findViewById(R.id.UpdateBtn);
        DeleteBtn =findViewById(R.id.DeleteBtn);

        getAndSetIntentData();

        ActionBar ab =getSupportActionBar();
        if (ab != null) {
            ab.setTitle(Account_Name);
        }

        UpdateBtn.setOnClickListener(view -> {
            DataBaseHelper db = new DataBaseHelper(Update_Account.this);
            Account_Name = inputAccName.getText().toString().trim();
            Account_Type = inputAccType.getText().toString().trim();
            Amount =  inputAccBalance.getText().toString().trim();
            db.UpdateData(Account_id, Account_Name, Account_Type, Amount);
        });


        DeleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ConfirmDelete();
            }
        });






    }

    void getAndSetIntentData(){
        if (getIntent().hasExtra("Account_id") && getIntent().hasExtra("Account_Name") &&
                getIntent().hasExtra("Account_Type") && getIntent().hasExtra("Amount")){

            //get data  from intent
            Account_id = getIntent().getStringExtra("Account_id");
            Account_Name = getIntent().getStringExtra("Account_Name");
            Account_Type = getIntent().getStringExtra("Account_Type");
            Amount = getIntent().getStringExtra("Amount");

            //set intent data

            inputAccName.setText(Account_Name);
            inputAccType.setText(Account_Type);
            inputAccBalance.setText(Amount);


        }else{
            Toast.makeText(this, "No data . ", Toast.LENGTH_SHORT).show();
        }
    }


    void ConfirmDelete(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete " + Account_Name + "?");
        builder.setMessage("Are you sure you want to delete "+Account_Name+" Account ?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                DataBaseHelper myDB = new DataBaseHelper(Update_Account.this);
                myDB.deleteOneRow(Account_id);
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
}