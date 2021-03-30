package com.example.a2021_03_27.adapter.screen_slide_page_adapter;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.a2021_03_27.fragment.fragment.home.HomeFragment;
import com.example.a2021_03_27.fragment.fragment.MineFragment;
import com.example.a2021_03_27.fragment.fragment.read.ReadFragment;
import com.example.a2021_03_27.fragment.fragment.ReciteFragment;
import com.example.a2021_03_27.fragment.fragment.SearchFragment;

public class ScreenSlidePagerAdapter extends FragmentStateAdapter {
    private static final int NUM_PACES = 5;
    public ScreenSlidePagerAdapter(FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @Override
    public Fragment createFragment(int position) {
        switch(position){
            case 0:
                return new HomeFragment();
            case 1:
                return new ReadFragment();
            case 2:
                return new SearchFragment();
            case 3:
                return new ReciteFragment();
            case 4:
                return new MineFragment();
        }
        return new HomeFragment();
    }

    @Override
    public int getItemCount() {
        return NUM_PACES;
    }
}
