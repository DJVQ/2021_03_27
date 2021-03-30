package com.example.a2021_03_27.count;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.a2021_03_27.R;
import com.example.a2021_03_27.data.mysql.RegisterCnn;

public class RegisterActivity extends AppCompatActivity {


    private EditText editTextTextEmailAddress,editTextTextPassword,editTextTextPassword2;
    private String userName,password1,password2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        init();
    }

    private void init(){
        editTextTextEmailAddress=findViewById(R.id.editTextTextEmailAddress);
        editTextTextPassword=findViewById(R.id.editTextTextPassword);
        editTextTextPassword2=findViewById(R.id.editTextTextPassword2);
    }

    public void registerBtn(View view) {
        userName=editTextTextEmailAddress.getText().toString().trim();
        password1=editTextTextPassword.getText().toString().trim();
        password2=editTextTextPassword2.getText().toString().trim();
        //判断输入框内容
        if(userName.equals("")){
            Toast.makeText(RegisterActivity.this,"请输入用户名",Toast.LENGTH_SHORT).show();
            return;
        }else if(password1.equals("")){
            Toast.makeText(RegisterActivity.this, "请输入密码", Toast.LENGTH_SHORT).show();
            return;
        }else if(password2.equals("")){
            Toast.makeText(RegisterActivity.this, "请再次输入密码", Toast.LENGTH_SHORT).show();
            return;
        }else if (!(password1.equals(password2))){
            Toast.makeText(RegisterActivity.this, "两次密码不一致，请重新输入", Toast.LENGTH_SHORT).show();
            return;
        }else{
            //RegisterBackground register = new RegisterBackground(this);
            //register.execute(userName,password1);
            RegisterCnn register = new RegisterCnn(this);
            register.setConnStr(getResources().getString(R.string.registerConnStr));
            register.execute(userName,password1);
        }
    }

}