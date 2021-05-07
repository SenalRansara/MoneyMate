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

public class Transport extends AppCompatActivity {

    //creating variables
    EditText txtInTransAmount;
    Button btnAdd,btnEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transport);

        //get the values to variables
        txtInTransAmount = findViewById(R.id.txtInTransportAmount);
        btnAdd = findViewById(R.id.btnTransportAdd);
        btnEdit = findViewById(R.id.btnTransportEdit);

        //set onclicklistner for save button
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DbController dbController = new DbController(Transport.this);

                dbController.addTransportBudget(txtInTransAmount.getText().toString().trim());
                Intent intent = new Intent(Transport.this,Budget.class);
                startActivity(intent);
            }
        });
        //set onclicklistner for edit button
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Amount = txtInTransAmount.getText().toString();

                DbController dbController = new DbController(Transport.this);

                dbController.editTransAmount(Amount);
                Intent intent = new Intent(Transport.this,Budget.class);
                startActivity(intent);
            }
        });
    }
}