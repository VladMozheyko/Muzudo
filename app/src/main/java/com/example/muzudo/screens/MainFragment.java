package com.example.muzudo.screens;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.muzudo.R;

public class MainFragment extends Fragment implements View.OnClickListener {

    FragmentManager fragmentManager;
    Fragment fragment;

    TextView txtProfile;
    TextView txtNews;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_fragment, container, false);
        txtProfile = view.findViewById(R.id.main_profile);
        txtNews = view.findViewById(R.id.news);
        txtProfile.setOnClickListener(this);
        txtNews.setOnClickListener(this);
        fragmentManager = getActivity().getSupportFragmentManager();
        fragment = new ProfileFragment();
        fragmentManager.beginTransaction()
                .add(R.id.main_container, fragment)
                .commit();
        return view;
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if(id == R.id.main_profile){
            fragment = new ProfileFragment();
            fragmentManager.beginTransaction()
                    .replace(R.id.main_container, fragment)
                    .commit();
        }
        else if(id == R.id.news){
            fragment = new NewsFragment();
            fragmentManager.beginTransaction()
                    .replace(R.id.main_container, fragment)
                    .commit();
        }
    }
}
