package com.example.a2021_03_27.view_page;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.a2021_03_27.R;
import com.example.a2021_03_27.view_page.searchview.ICallBack;
import com.example.a2021_03_27.view_page.searchview.SearchView;
import com.example.a2021_03_27.view_page.searchview.bCallBack;

public class SearchActivity extends AppCompatActivity  {

    // 1. 初始化搜索框变量
    private SearchView searchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 2. 绑定视图
        setContentView(R.layout.activity_search);

        // 3. 绑定组件
        searchView = (SearchView) findViewById(R.id.search_view);

        // 4. 设置点击搜索按键后的操作（通过回调接口）
        // 参数 = 搜索框输入的内容
        searchView.setOnClickSearch(new ICallBack() {
            @Override
            public void SearchAction(String string) {
                System.out.println("我收到了" + string);
            }
        });

        // 5. 设置点击返回按键后的操作（通过回调接口）
        searchView.setOnClickBack(new bCallBack() {
            @Override
            public void BackAction() {
                finish();
            }
        });



    }
}