
package com.example.moneymate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class signup extends AppCompatActivity {

    private EditText emailSignUp , usernameSignUp , passwordSignUp;
    private Button signUpButton ;
    private DataBaseHandler myDB;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


        Button btn2 = (Button)findViewById(R.id.BackToSignin);


        btn2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(signup.this, login.class));
            }
        });



        emailSignUp = findViewById(R.id.signupemail);
        usernameSignUp = findViewById(R.id.signupusername);
        passwordSignUp = findViewById(R.id.signuppassword);

        signUpButton = findViewById(R.id.signupbutton);
        myDB = new DataBaseHandler(this);
        insertUser();

    }

    private  void  insertUser(){
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean var = myDB.registerUser(usernameSignUp.getText().toString(), emailSignUp.getText().toString(),passwordSignUp.getText().toString());
                if (var){
                    Toast.makeText(signup.this,"User Registered Successfully !!", Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(signup.this,"Registration Error !!" , Toast.LENGTH_SHORT).show();

            }
        });

    }
}