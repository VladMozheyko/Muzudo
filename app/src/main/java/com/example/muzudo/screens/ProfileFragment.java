package com.example.muzudo.screens;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.muzudo.R;
import com.example.muzudo.Repository;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ProfileFragment extends Fragment{

    private EditText edtName;
    private EditText edtLocation;
    private EditText edtPhoneNumber;
    private EditText edtEmail;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.profile_fragment, container, false);
        init(view);
        return view;
    }

    private void init(View view) {
        edtName = view.findViewById(R.id.edt_name_surname);
        edtLocation = view.findViewById(R.id.location);
        edtPhoneNumber = view.findViewById(R.id.phone_number);
        edtEmail = view.findViewById(R.id.profile_email);

        edtName.setText(Repository.user.getName());
        edtLocation.setText(Repository.user.getLocation());
        edtPhoneNumber.setText(Repository.user.getPhoneNumber());
        edtEmail.setText(Repository.user.getEmail());


    }

}
