package com.example.a2021_03_27.fragment.fragment.read;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a2021_03_27.R;


public class TabIReadFragment extends Fragment {

    public static TabIReadFragment newInstance() {

        Bundle args = new Bundle();

        TabIReadFragment fragment = new TabIReadFragment();
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
        return inflater.inflate(R.layout.fragment_tag_i_read, container, false);
    }
}