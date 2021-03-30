package com.example.a2021_03_27.view_page;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;

import com.example.a2021_03_27.R;
import com.example.a2021_03_27.fragment.fragment.MineFragment;
import com.example.a2021_03_27.fragment.fragment.ReciteFragment;
import com.example.a2021_03_27.fragment.fragment.SearchFragment;
import com.example.a2021_03_27.fragment.fragment.home.HomeFragment;
import com.example.a2021_03_27.fragment.fragment.read.ReadFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class IndexActivity extends AppCompatActivity {


    private ArrayList<Fragment> fragmentList = new ArrayList<Fragment>();
    private HomeFragment homeFragment;
    private ReadFragment readFragment;
    private SearchFragment searchFragment;
    private ReciteFragment reciteFragment;
    private MineFragment mineFragment;
    private ViewPager2 mainViewPager;
    private BottomNavigationView bottomNavView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        setContentView(R.layout.activity_index);
        initView();
    }

    public void initView(){

        mainViewPager = (ViewPager2)findViewById(R.id.mainViewpager);
        bottomNavView = (BottomNavigationView)findViewById(R.id.bottomNavView);

        homeFragment = HomeFragment.newInstance();
        readFragment = ReadFragment.newInstance();
        searchFragment = SearchFragment.newInstance();
        reciteFragment = ReciteFragment.newInstance();
        mineFragment = MineFragment.newInstance();

        fragmentList.add(homeFragment);
        fragmentList.add(readFragment);
        fragmentList.add(searchFragment);
        fragmentList.add(reciteFragment);
        fragmentList.add(mineFragment);
        initViewPager();
        bottomNavView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch(item.getItemId()){
                    case R.id.home_b:
                        switchFragment(0);
                        break;
                    case R.id.read_b:
                        switchFragment(1);
                        break;
                    case R.id.search_b:
                        switchFragment(2);
                        break;
                    case R.id.recite_b:
                        switchFragment(3);
                        break;
                    case R.id.mine_b:
                        switchFragment(4);
                        break;
                };
                return true;
            }
        });


    }


    public void switchFragment(int index) {
        mainViewPager.setCurrentItem(index,true);

    }

    private void initViewPager(){
        mainViewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                //设置滑动fragment对应底部菜单按钮选中
                bottomNavView.setSelectedItemId(bottomNavView.getMenu().getItem(position).getItemId());

                //设置不处理滑动
                mainViewPager.setUserInputEnabled(mainViewPager.getCurrentItem() < -1);
            }
        });
        mainViewPager.setOffscreenPageLimit(2);
        mainViewPager.setAdapter(new FragmentStateAdapter(this) {
            @Override
            public Fragment createFragment(int position) {
                return fragmentList.get(position);
            }

            @Override
            public int getItemCount() {
                return fragmentList.size();
            }
        });
    }


    public ViewPager2 getMainViewPager() {
        return mainViewPager;
    }
}