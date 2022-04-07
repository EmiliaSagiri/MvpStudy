package com.example.mvploginsystem.mvp.v1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mvploginsystem.R;
import com.example.mvploginsystem.mvp.v1.view.MainActivity;
import com.example.mvploginsystem.mvp.v1.view.RegisterActivity;

public class ShowActivity extends AppCompatActivity implements View.OnClickListener{
private Button btn_login;
private Button btn_register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        btn_login =findViewById(R.id.v1_login);
        btn_register = findViewById(R.id.v1_register);
        btn_login.setOnClickListener(this);
        btn_register.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.v1_login:
                startActivity(new Intent(this, MainActivity.class));
                finish();
                break;
            case R.id.v1_register:
                startActivity(new Intent(this, RegisterActivity.class));
                finish();
                break;
            default:
                break;
        }
    }
}