package com.example.a2021_03_27.count;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.a2021_03_27.R;
import com.example.a2021_03_27.data.mysql.LoginCnn;
import com.example.a2021_03_27.view_page.IndexActivity;

public class LoginActivity extends AppCompatActivity  {

    EditText usr,pas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usr = findViewById(R.id.username);
        pas = findViewById(R.id.password);
    }

    public void loginBtn(View view){
        String user = usr.getText().toString();
        String pass = pas.getText().toString();

        if(user.equals("")){
            Toast.makeText(LoginActivity.this,"请输入用户名",Toast.LENGTH_SHORT).show();
            return;
        }else if(pass.equals("")){
            Toast.makeText(LoginActivity.this, "请输入密码", Toast.LENGTH_SHORT).show();
            return;
        }else {
            LoginCnn login = new LoginCnn(this);
            login.setConnStr(getResources().getString(R.string.loginConnStr));
            login.execute(user,pass);
        }
    }

    public void registerBtn(View view) {
        startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
    }
}