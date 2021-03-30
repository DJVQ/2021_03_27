package com.example.a2021_03_27.adapter.screen_slide_page_adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.a2021_03_27.fragment.fragment.read.TabEReadFragment;

import java.util.List;

public class ReadFragmentAdapter extends FragmentStatePagerAdapter {


    public ReadFragmentAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return null;
    }

    @Override
    public int getCount() {
        return 0;
    }
}
