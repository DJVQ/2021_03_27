package com.example.a2021_03_27.fragment.fragment.home;


import android.os.Bundle;


import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a2021_03_27.view_page.IndexActivity;

import com.example.a2021_03_27.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class HomeFragment extends Fragment {
    private ViewPager2 viewPager;
    private TabLayout tabLayout;
    private List<String> tabTitleList;
    private View viewContent;
    private ArrayList<Fragment> tabFragmentList = new ArrayList<Fragment>();
    private TagHome1Fragment home1Fragment;
    private TagHome2Fragment home2Fragment;
    private TagHome3Fragment home3Fragment;
    private IndexActivity indexActivity = new IndexActivity();
    private ViewPager2 mainViewPager;

    //实例化方法
    public static HomeFragment newInstance() {
        Bundle args = new Bundle();
        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onViewCreated( View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    private void initValues(View v){
        viewPager = v.findViewById(R.id.viewPager);
        tabLayout = v.findViewById(R.id.tabLayout);
        tabTitleList = Arrays.asList(getResources().getStringArray(R.array.tab_home_name));
        home1Fragment = TagHome1Fragment.newInstance();
        home2Fragment = TagHome2Fragment.newInstance();
        home3Fragment = TagHome3Fragment.newInstance();
        tabFragmentList.add(home1Fragment);
        tabFragmentList.add(home2Fragment);
        tabFragmentList.add(home3Fragment);
        mainViewPager = indexActivity.getMainViewPager();
    }

    private void initViewPager(View v){
        initValues(v);
        viewPager.setOffscreenPageLimit(1);
        viewPager.setAdapter(new FragmentStateAdapter(this) {
            @Override
            public Fragment createFragment(int position) {
                return tabFragmentList.get(position);
            }

            @Override
            public int getItemCount() {
                return tabFragmentList.size();
            }
        });

        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(tabLayout,
                viewPager,
                (tab,position) -> tab.setText(tabTitleList.get(position)));
        tabLayoutMediator.attach();

        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
            }
        });


    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        viewContent = inflater.inflate(R.layout.fragment_botton_home, container, false);
        initViewPager(viewContent);
        return viewContent;
    }

}