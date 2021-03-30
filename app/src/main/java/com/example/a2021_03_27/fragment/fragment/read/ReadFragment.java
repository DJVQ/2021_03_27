package com.example.a2021_03_27.fragment.fragment.read;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.example.a2021_03_27.R;
import com.example.a2021_03_27.fragment.fragment.home.TagHome1Fragment;
import com.example.a2021_03_27.fragment.fragment.home.TagHome2Fragment;
import com.example.a2021_03_27.fragment.fragment.home.TagHome3Fragment;
import com.example.a2021_03_27.view_page.IndexActivity;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReadFragment extends Fragment {

    private ViewPager2 viewPager;
    private TabLayout tabLayout;
    private List<String> tabTitleList;
    private View viewContent;
    private ArrayList<Fragment> tabFragmentList = new ArrayList<Fragment>();
    private TabEReadFragment eReadFragment;
    private TabIReadFragment iReadFragment;
    private TabLocalFragment localFragment;
    private IndexActivity indexActivity = new IndexActivity();
    private ViewPager2 mainViewPager;


    public static ReadFragment newInstance() {
        
        Bundle args = new Bundle();
        
        ReadFragment fragment = new ReadFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private void initValues(View v){
        viewPager = v.findViewById(R.id.viewPager);
        tabLayout = v.findViewById(R.id.tabLayout);
        tabTitleList = Arrays.asList(getResources().getStringArray(R.array.tab_read_name));
        eReadFragment = TabEReadFragment.newInstance();
        iReadFragment = TabIReadFragment.newInstance();
        localFragment = TabLocalFragment.newInstance();
        tabFragmentList.add(eReadFragment);
        tabFragmentList.add(iReadFragment);
        tabFragmentList.add(localFragment);
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