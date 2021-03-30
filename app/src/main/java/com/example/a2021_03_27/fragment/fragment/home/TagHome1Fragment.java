package com.example.a2021_03_27.fragment.fragment.home;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.renderscript.Allocation;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a2021_03_27.R;

import java.util.List;


public class TagHome1Fragment extends Fragment {


    public static TagHome1Fragment newInstance() {
        
        Bundle args = new Bundle();
        
        TagHome1Fragment fragment = new TagHome1Fragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_tag_home1, container, false);
    }
}