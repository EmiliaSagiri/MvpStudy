package com.example.mvploginsystem.mvp.v1.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mvploginsystem.DBManager;
import com.example.mvploginsystem.R;
import com.example.mvploginsystem.User;
import com.example.mvploginsystem.mvp.v1.RegisterContract;
import com.example.mvploginsystem.mvp.v1.presenter.MainPresenter;
import com.example.mvploginsystem.mvp.v1.presenter.RegisterPresenter;

import java.util.ArrayList;
import java.util.List;

public class RegisterActivity extends AppCompatActivity implements RegisterContract.RegisterView {
    private RegisterPresenter registerPresenter;
    private EditText editText_name;
    private EditText editText_password;
    private Button button_register;
    private List<User> userList =new ArrayList<>();
    private DBManager dbManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2);
        initView();
        dbManager =DBManager.getInstance(this);
        registerPresenter = new RegisterPresenter(this);
        button_register.setOnClickListener(v -> onStartRegister());
    }

    private void initView(){
        editText_name = findViewById(R.id.User_Register_name2);
        editText_password = findViewById(R.id.User_Register_password2);
        button_register = findViewById(R.id.User_register);
    }

    private boolean ExistName(String username){
        userList = dbManager.queryUserList();
        for(User x : userList){
            if(x.getUsername().equals(username)){
                    return true;
                }
            }

        return false;
    }

    @Override
    public void setNameError() {
        Toast.makeText(this,"账号为空",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setPasswordError() {
        Toast.makeText(this,"密码为空",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setOnSuccess(String username, String password) {
        if (ExistName(username)){
            Toast.makeText(this,"用户已存在",Toast.LENGTH_SHORT).show();
        }
        else {
            User user =new User();
            user.setUsername(editText_name.getText().toString());
            user.setPassword(editText_password.getText().toString());
            dbManager.insertUser(user);
            Toast.makeText(this,"注册成功",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onStartRegister() {
        registerPresenter.handlerData(editText_name.getText().toString(),editText_password.getText().toString());
    }

    public void onDestroy(){
        registerPresenter.onDestroy();
        super.onDestroy();
    }
}