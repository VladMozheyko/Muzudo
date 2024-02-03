package com.example.muzudo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.muzudo.screens.LoginFragment;
import com.example.muzudo.screens.MainFragment;
import com.example.muzudo.screens.NewsFragment;
import com.example.muzudo.screens.OnboardingFragment;
import com.example.muzudo.screens.ProductsFragment;
import com.example.muzudo.screens.ProfileFragment;
import com.example.muzudo.screens.RegistrationFragment;
import com.example.muzudo.screens.ServiceFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class WorkActivity extends AppCompatActivity {

    FragmentManager fragmentManager;
    Fragment fragment;

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work);
        fragmentManager = getSupportFragmentManager();
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setItemIconSize(140);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id = item.getItemId();

                if(id == R.id.profile_nav){
                    fragment = new MainFragment();
                    fragmentManager.beginTransaction()
                            .replace(R.id.work_container, fragment)
                            .commit();
                }
                else if(id == R.id.service_nav){
                    fragment = new ServiceFragment();
                    fragmentManager.beginTransaction()
                            .replace(R.id.work_container, fragment)
                            .commit();
                }
                else if(id == R.id.errors_nav){
                   Intent intent = new Intent(WorkActivity.this, ErrorsActivity.class);
                   startActivity(intent);
                }
                else if(id == R.id.production_nav){
                    fragment = new ProductsFragment();
                    fragmentManager.beginTransaction()
                            .replace(R.id.work_container, fragment)
                            .commit();
                }
                return true;
            }
        });

        if(fragment ==  null){
            fragment = new MainFragment();
            fragmentManager.beginTransaction()
                    .add(R.id.work_container, fragment)
                    .commit();
        }
    }
    public void onClickWork(View view) {
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
        else if(id == R.id.main_profile){
            fragment = new MainFragment();
            fragmentManager.beginTransaction()
                    .addToBackStack("Onboarding")
                    .replace(R.id.fragment_container, fragment)
                    .commit();
        }
        else if(id == R.id.news){
            fragment = new NewsFragment();
            fragmentManager.beginTransaction()
                    .addToBackStack("Onboarding")
                    .replace(R.id.fragment_container, fragment)
                    .commit();
        }
        else if(id == R.id.mizudo_com){
            goToUrl("https://mizudo.com/");
        }
        else if(id == R.id.mizudo_ru){
            goToUrl("https://www.mizudo.ru/");
        }
        else if(id == R.id.telegram){
            goToUrl("https://t.me/mizudo_boilers");
        }


    }

    private void goToUrl (String url) {
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }
}