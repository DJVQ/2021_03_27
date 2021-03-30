package com.example.a2021_03_27.fragment.fragment.read;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.a2021_03_27.R;


public class TabEReadFragment extends Fragment {

    private View viewContent;


    public static TabEReadFragment newInstance() {
        
        Bundle args = new Bundle();
        
        TabEReadFragment fragment = new TabEReadFragment();
        fragment.setArguments(args);
        return fragment;
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        viewContent = inflater.inflate(R.layout.fragment_tag_e_read,container,false);

        return viewContent;
    }
}