package com.example.moneymate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import com.example.moneymate.R;

public class Home extends AppCompatActivity {

    TextView HomeName;
    private static int time = 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        HomeName = findViewById(R.id.homename);

        HomeName.setText(getIntent().getStringExtra("name"));
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Home.this, PasswordActivity.class);
                startActivity(intent);
                finish();
            }
        },time);
    }
}