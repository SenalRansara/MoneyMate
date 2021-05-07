package com.example.moneymate;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateSavings extends AppCompatActivity {

    EditText des,amount;
    Button update_button, delete_button;

    String aid,description,amnt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_savings);

        des = findViewById(R.id.editText4);
        amount = findViewById(R.id.editText3);
        update_button = findViewById(R.id.update_btn);
        delete_button = findViewById(R.id.delete_btn);

        getIntentData();

        update_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DbController Db = new DbController(UpdateSavings.this);
                description = des.getText().toString().trim();
                amnt = amount.getText().toString().trim();
                Db.updateData(aid, description, amnt);

            }
        });
        delete_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirmText();

            }
        });


    }

    void getIntentData(){
        if(getIntent().hasExtra("aid") && getIntent().hasExtra("description") && getIntent().hasExtra("amnt")){

            //getting data from intent
            aid = getIntent().getStringExtra("aid");
            description = getIntent().getStringExtra("description");
            amnt = getIntent().getStringExtra("amnt");

            //setting Intent data
            des.setText(description);
            amount.setText(amnt);

        }else{
            Toast.makeText(this,"No data",Toast.LENGTH_SHORT).show();
        }
    }

    void confirmText(){
    AlertDialog.Builder builder = new AlertDialog.Builder(this);
    builder.setTitle("Delete " + description + " ?");
    builder.setMessage("Are you sure want to delete " + description + " ?");
    builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            DbController Db = new DbController(UpdateSavings.this);
            Db.deleteRow(aid);
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