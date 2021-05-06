package com.example.moneymate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {

    private EditText loginUsername , loginPassword;
    private Button loginButton;
    private DataBaseHandler myDb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button btn2 = (Button)findViewById(R.id.ToSignUp);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(login.this, signup.class));
            }

        });



        loginUsername = findViewById(R.id.loginusername);
        loginPassword = findViewById(R.id.loginpassword);
        loginButton = findViewById(R.id.loginbutton);

        myDb = new DataBaseHandler(this);

        loginUser();
    }
    private void loginUser(){
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean var = myDb.checkUser(loginUsername.getText().toString(), loginPassword.getText().toString());
                if (var){
                    Toast.makeText(login.this,"Login Successfully !!" , Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(login.this , Home.class));
                    finish();
                }else{
                    Toast.makeText(login.this,"Login failed !!" , Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}