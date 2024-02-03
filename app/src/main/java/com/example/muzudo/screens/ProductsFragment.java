package com.example.muzudo.screens;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.muzudo.R;
import com.example.muzudo.model.Image;

import java.util.List;

public class ProductsFragment extends Fragment implements View.OnClickListener {

    FragmentManager fragmentManager;
    Fragment fragment;

    TextView txtBoilers;
    TextView txtGeysers;
    TextView txtCurrency;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.products_fragment, container, false);
      fragmentManager = getActivity().getSupportFragmentManager();
      fragment = new BoilersFragment();
      fragmentManager.beginTransaction()
              .add(R.id.prod_container, fragment)
              .commit();
        init(view);
        return view;
    }

    private void init(View view) {
        txtBoilers = view.findViewById(R.id.boilers);
        txtGeysers = view.findViewById(R.id.geysers);
        txtCurrency = view.findViewById(R.id.currency);

        txtCurrency.setOnClickListener(this);
        txtBoilers.setOnClickListener(this);
        txtGeysers.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        if(id == R.id.geysers){
            fragment = new GeysersFragment();
            fragmentManager.beginTransaction()
                    .replace(R.id.prod_container, fragment)
                    .commit();

        }
        else if(id == R.id.boilers){
            fragment = new BoilersFragment();
            fragmentManager.beginTransaction()
                    .replace(R.id.prod_container, fragment)
                    .commit();
        }
        else if(id == R.id.currency){
            fragment = new CurrencyFragment();
            fragmentManager.beginTransaction()
                    .replace(R.id.prod_container, fragment)
                    .commit();
        }

    }
}
