package com.example.a2021_03_27.data.mysql;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.example.a2021_03_27.view_page.IndexActivity;

public class LoginCnn extends Cnn{


    public LoginCnn(Context context) {
        super(context);
    }

    @Override
    public void setConnStr(String connStr) {
        super.setConnStr(connStr);
    }

    @Override
    protected void onPostExecute(String s) {
        if(s.equals("success")){
            Toast.makeText(context, "登录成功", Toast.LENGTH_SHORT).show();
            context.startActivity(new Intent(context, IndexActivity.class));
        }else if(s.equals("passError")){
            Toast.makeText(context, "密码错误,请重新输入", Toast.LENGTH_SHORT).show();
        }else if(s.equals("noUser")){
            Toast.makeText(context, "用户不存在", Toast.LENGTH_SHORT).show();
        }else if(s.equals("connErr")){
            Toast.makeText(context, "数据库连接失败", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "未知错误", Toast.LENGTH_SHORT).show();
        }
    }
}
