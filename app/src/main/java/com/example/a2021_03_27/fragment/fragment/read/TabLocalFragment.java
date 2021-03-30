package com.example.a2021_03_27.fragment.fragment.read;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a2021_03_27.R;


public class TabLocalFragment extends Fragment {

    public static TabLocalFragment newInstance() {
        
        Bundle args = new Bundle();
        
        TabLocalFragment fragment = new TabLocalFragment();
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
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tag_local_read, container, false);
    }
}