package com.example.muzudo.screens;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.muzudo.R;
import com.example.muzudo.RepairActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ServiceFragment extends Fragment implements View.OnClickListener {
    FragmentManager fragmentManager;
    Fragment fragment;
    private TextView txt_tech_data;
    private TextView txt_repair;
    private TextView txt_service;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.service_fragment, container, false);
        fragmentManager = getActivity().getSupportFragmentManager();
        fragment = new TechDataFragment();
        fragmentManager.beginTransaction()
                .add(R.id.service_container, fragment)
                .commit();
        init(view);
        return view;
    }

    private void init(View view) {
        txt_tech_data = view.findViewById(R.id.tech_data);
        txt_repair = view.findViewById(R.id.repair);
        txt_service = view.findViewById(R.id.service_centers);

        txt_service.setOnClickListener(this);
        txt_repair.setOnClickListener(this);
        txt_tech_data.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if(id == R.id.repair){
            fragment = new RepairFragment();
            fragmentManager.beginTransaction()
                    .replace(R.id.service_container, fragment)
                    .commit();
        }
        else if(id == R.id.service_centers){
            fragment = new ServiceCenters();
            fragmentManager.beginTransaction()
                    .replace(R.id.service_container, fragment)
                    .commit();
        }
        else if(id == R.id.tech_data){
            fragment = new TechDataFragment();
            fragmentManager.beginTransaction()
                    .replace(R.id.service_container, fragment)
                    .commit();
        }
    }
}
