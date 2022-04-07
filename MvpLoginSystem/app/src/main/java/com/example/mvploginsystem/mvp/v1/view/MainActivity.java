package com.example.mvploginsystem.mvp.v1.view;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mvploginsystem.DBManager;
import com.example.mvploginsystem.R;
import com.example.mvploginsystem.User;
import com.example.mvploginsystem.login.LoginPresenter;
import com.example.mvploginsystem.mvp.v1.MainContract;
import com.example.mvploginsystem.mvp.v1.presenter.MainPresenter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainContract.IMainView {
    private MainPresenter mainPresenter;
    private EditText editText_name;
    private EditText editText_password;
    private Button button_login;
    private List<User> userList =new ArrayList<>();
    private DBManager dbManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
        dbManager =DBManager.getInstance(this);
        mainPresenter = new MainPresenter(this);
        button_login.setOnClickListener(v -> onStartLogin());

    }
    private void initView(){
        editText_name = findViewById(R.id.User_v1_name);
        editText_password = findViewById(R.id.User_v1_password);
        button_login = findViewById(R.id.User_v1_login);
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
        Toast.makeText(this,"账号为空",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setPasswordError() {
        Toast.makeText(this,"密码为空",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setOnSuccess(String username, String password) {
        if (ExistName(username,password)){
            Toast.makeText(this,"登陆成功",Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this,"登陆失败",Toast.LENGTH_SHORT).show();
        }
    }
    public void onStartLogin(){
        mainPresenter.handlerData(editText_name.getText().toString(),editText_password.getText().toString());
    }

    public void onDestroy() {
        mainPresenter.onDestroy();
        super.onDestroy();
    }

}