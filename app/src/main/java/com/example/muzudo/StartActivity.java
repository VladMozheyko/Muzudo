package com.example.muzudo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;

import com.example.muzudo.screens.LoginFragment;
import com.example.muzudo.screens.OnboardingFragment;
import com.example.muzudo.screens.ProductsFragment;
import com.example.muzudo.screens.RegistrationFragment;

public class StartActivity extends AppCompatActivity {

    FragmentManager fragmentManager;
    Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //  setTheme(R.style.Base_Theme_Mizudo_Launcher);
        setContentView(R.layout.activity_start);
        fragmentManager = getSupportFragmentManager();

        if(fragment ==  null){
            fragment = new OnboardingFragment();
            fragmentManager.beginTransaction()
                    .add(R.id.fragment_container, fragment)
                    .commit();
        }
    }
    public void onClick(View view) {
        int id = view.getId();
        if(id == R.id.btn_registration){
            fragment = new RegistrationFragment();
            fragmentManager.beginTransaction()
                    .addToBackStack("Onboarding")
                    .replace(R.id.fragment_container, fragment)
                    .commit();
        }
        else if(id == R.id.txt_login){
            fragment = new LoginFragment();
            fragmentManager.beginTransaction()
                    .addToBackStack("Onboarding")
                    .replace(R.id.fragment_container, fragment)
                    .commit();
        }
        else if(id == R.id.txt_registration){
            fragment = new RegistrationFragment();
            fragmentManager.beginTransaction()
                    .addToBackStack("Onboarding")
                    .replace(R.id.fragment_container, fragment)
                    .commit();
        }


    }
}