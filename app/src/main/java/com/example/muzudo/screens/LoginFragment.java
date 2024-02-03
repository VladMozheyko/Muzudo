package com.example.muzudo.screens;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.muzudo.R;
import com.example.muzudo.Repository;
import com.example.muzudo.WorkActivity;

public class LoginFragment extends Fragment {

    private EditText edtEmail;
    private EditText edtPassword;
    private Button btnLogin;

    FragmentManager fragmentManager;
    Fragment fragment;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.login_fragment, container, false);
        init(view);
        return view;
    }

    private void init(View view) {
        edtEmail = view.findViewById(R.id.edt_email);
        edtPassword = view.findViewById(R.id.edt_password);
        btnLogin = view.findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String email = edtEmail.getText().toString().trim();
                    String password = edtPassword.getText().toString().trim();
                    if (email.equals(Repository.user.getEmail()) &&
                            password.equals(Repository.user.getPassword())) {
                        Intent intent = new Intent(getActivity(), WorkActivity.class);
                        startActivity(intent);

                    } else {
                        Toast.makeText(getActivity(), "Неправильный пароль или почта",
                                Toast.LENGTH_LONG).show();
                    }
                }catch (Exception ex){
                    Toast.makeText(getActivity(), "Неправильный пароль или почта",
                            Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
