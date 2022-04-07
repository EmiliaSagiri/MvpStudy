package com.example.mvploginsystem.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mvploginsystem.DBManager;
import com.example.mvploginsystem.MainActivity;
import com.example.mvploginsystem.R;
import com.example.mvploginsystem.User;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity implements LoginView {
    private LoginPresenter loginPresenter;
    private LoginView loginView;
    private loginModel model;
    private DBManager dbManager;
    private List<User> userList =new ArrayList<>();
    private EditText editText_name;
    private EditText editText_password;
    private Button button_login;
    private String User_name;
    private String User_password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        dbManager = DBManager.getInstance(this);
        button_login.setOnClickListener(v -> validateCredentials());
        loginPresenter = new LoginPresenter( new loginModel(),this);
    }

    private void initView(){
        editText_name = findViewById(R.id.User_name);
        editText_password = findViewById(R.id.User_password);
        button_login = findViewById(R.id.login);
    }
    private boolean ExistName(String username,String password){
        userList = dbManager.queryUserList();
        for(User x : userList){
            if(x.getUsername().equals(username)){
                if(x.getPassword().equals(password)){
                    return true;
                }
            }
        }
        return false;
    }


    @Override
    public void setNameError() {
        Toast.makeText(this,"名字为空",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setPasswordError() {
        Toast.makeText(this,"密码为空",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setOnSuccess(String username,String password) {
        if(ExistName(username,password)){
            Toast.makeText(this,"登录成功",Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this,"用户不存在，请注册",Toast.LENGTH_SHORT).show();
        }
    }

    private void validateCredentials() {
        User_name = editText_name.getText().toString();
        User_password = editText_password.getText().toString();
        loginPresenter.validateCredentials(User_name, User_password);
    }

    public void onDestroy() {
        loginPresenter.onDestroy();
        super.onDestroy();
    }
}