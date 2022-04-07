package com.example.mvploginsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.mvploginsystem.login.LoginActivity;
import com.example.mvploginsystem.register.RegisterActivity;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button button1;
    private Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = findViewById(R.id.text_login);
        button2 = findViewById(R.id.test_register);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.text_login:
                startActivity(new Intent(this, LoginActivity.class));
                break;

            case R.id.test_register:
                startActivity(new Intent(this, RegisterActivity.class));
                break;
            default:
                break;
        }
    }
}

