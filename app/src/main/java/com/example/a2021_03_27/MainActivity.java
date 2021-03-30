package com.example.a2021_03_27;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.a2021_03_27.count.LoginActivity;
import com.example.a2021_03_27.data.sdcard.InitLocalDir;
import com.example.a2021_03_27.data.sdcard.SdcardUtil;
import com.example.a2021_03_27.view_page.IndexActivity;

public class MainActivity extends AppCompatActivity {
    private Button btnMainIn,btnMainLogin;
    public static MainActivity instance;
    Context context = this;
    InitLocalDir initLocalDir = new InitLocalDir();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instance = this;
        initView();

    }

    public void initFile(){

    }

    public void initView(){
        btnMainIn = findViewById(R.id.btnMainIn);
        btnMainLogin = findViewById(R.id.btnMainLogin);
        btnMainIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, IndexActivity.class));
                initLocalDir.initProjectDir(context);
            }
        });
        btnMainLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
            }
        });

    }
}