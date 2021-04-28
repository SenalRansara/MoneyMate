package com.example.moneymate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class new_Account extends AppCompatActivity {

    EditText inputAccName, inputAccType, inputAccBalance;
    Button SaveNewBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new__account);
        
        inputAccName = findViewById(R.id.inputAccName);
        inputAccType = findViewById(R.id.inputAccType);
        inputAccBalance = findViewById(R.id.inputAccBalance);
        SaveNewBtn = findViewById(R.id.SaveNewBtn);

        SaveNewBtn.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View view) {
                DataBaseHelper myDB = new DataBaseHelper(new_Account.this);
                myDB.addAccount(inputAccName.getText() .toString() .trim() ,
                        inputAccType .getText() .toString() .trim() ,
                        Integer.valueOf(inputAccBalance .getText() .toString() .trim()));

            }
        });
    }
}