package com.example.mvploginsystem.register;

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
import com.example.mvploginsystem.login.LoginPresenter;
import com.example.mvploginsystem.login.LoginView;
import com.example.mvploginsystem.login.loginModel;

import java.util.ArrayList;
import java.util.List;

public class RegisterActivity extends AppCompatActivity implements RegisterView{

    private RegisterPresenter registerPresenter;
    private DBManager dbManager;
    private List<User> userList =new ArrayList<>();
    private EditText editText_name;
    private EditText editText_password;
    private Button button_register;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();
        dbManager = DBManager.getInstance(this);
        button_register.setOnClickListener(v -> lvalidateCredentials());
        registerPresenter = new RegisterPresenter(new RegisterModel(),this);
    }

    private void initView(){
        editText_name = findViewById(R.id.User_name2);
        editText_password = findViewById(R.id.User_password2);
        button_register = findViewById(R.id.User_register);
    }

    private boolean UserExist(String username){
        userList = dbManager.queryUserList();
        for(User x: userList){
            if(x.getUsername().equals(username)){
                Toast.makeText(this,"该用户已注册",Toast.LENGTH_SHORT).show();
                return true;
            }
        }
        return false;
    }

    @Override
    public void set_NameError() {
        Toast.makeText(this,"名字为空",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void set_PasswordError() {
        Toast.makeText(this,"密码为空",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void set_OnSuccess(String username,String password) {
        if(!UserExist(username)){
            User user = new User();
            user.setUsername(editText_name.getText().toString());
            user.setPassword(editText_password.getText().toString());
            dbManager.insertUser(user);
            Toast.makeText(this,"注册成功",Toast.LENGTH_SHORT).show();
        }
    }

    private void lvalidateCredentials() {
        registerPresenter.validateCredentials(editText_name.getText().toString(),editText_password.getText().toString());
    }

    public void onDestroy() {
        registerPresenter.onDestroy();
        super.onDestroy();
    }
}