package com.example.muzudo.screens;

import android.os.AsyncTask;
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
import com.example.muzudo.model.User;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class RegistrationFragment extends Fragment {
    private EditText edtName;
    private EditText edtLocation;
    private EditText edtPhoneNumber;
    private EditText edtEmail;
    private EditText edtPassword;
    private EditText edtRepeatPassword;
    private Button btnRegistration;

    FragmentManager fragmentManager;
    Fragment fragment;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.registration_fragment, container, false);
        init(view);

        return view;
    }

    private void init(View view) {
        edtName = view.findViewById(R.id.edt_name);
        edtLocation = view.findViewById(R.id.edt_location);
        edtPhoneNumber = view.findViewById(R.id.edt_phone_number);
        edtEmail = view.findViewById(R.id.edt_email);
        edtPassword = view.findViewById(R.id.edt_password);
        edtRepeatPassword = view.findViewById(R.id.edt_repeat_password);
        btnRegistration = view.findViewById(R.id.btn_registration);
        btnRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String name = edtName.getText().toString().trim();
                    String location = edtLocation.getText().toString().trim();
                    String phoneNumber = edtPhoneNumber.getText().toString().trim();
                    String email = edtEmail.getText().toString().trim();
                    String password = edtPassword.getText().toString().trim();
                    Repository.user = new User(name, location, phoneNumber, email, password);
                    fragmentManager = getActivity().getSupportFragmentManager();
                    Map<String, String> params = new HashMap<>();
                    params.put("username", name);
                    params.put("password", password);
                    params.put("email", email);
                    GetRequestTask postRequestTask = new GetRequestTask("http://192.168.1.40:8080/registration", params);

                    postRequestTask.execute();
                    fragment = new LoginFragment();
                    fragmentManager.beginTransaction()
                            .replace(R.id.fragment_container, fragment)
                            .commit();
                } catch (Exception ex) {
                    Toast.makeText(getActivity(), R.string.fill_all_fields, Toast.LENGTH_LONG).show();
                }
            }
        });
    }


    public class GetRequestTask extends AsyncTask<Void, Void, String> {

        private final String url;
        private final Map<String, String> params;

        public GetRequestTask(String url, Map<String, String> params) {
            this.url = buildUrlWithParams(url, params);
            this.params = params;
        }

        private String buildUrlWithParams(String url, Map<String, String> params) {
            if (params != null && !params.isEmpty()) {
                StringBuilder paramString = new StringBuilder();
                paramString.append("?");
                for (Map.Entry<String, String> entry : params.entrySet()) {
                    paramString.append(entry.getKey())
                            .append("=")
                            .append(entry.getValue())
                            .append("&");
                }
                // Удаляем последний "&"
                paramString.deleteCharAt(paramString.length() - 1);
                return url + paramString.toString();
            }
            return url;
        }



        @Override
        protected String doInBackground(Void... voids) {
            try {
                URL urlObject = new URL(url);
                HttpURLConnection connection = (HttpURLConnection) urlObject.openConnection();

                // Устанавливаем метод запроса
                connection.setRequestMethod("GET");

                // Получаем ответ от сервера
                int responseCode = connection.getResponseCode();

                if (responseCode == HttpURLConnection.HTTP_OK) {
                    // Обрабатываем успешный ответ
                    InputStream in = connection.getInputStream();
                    Scanner scanner = new Scanner(in);
                    scanner.useDelimiter("\\A");
                    return scanner.hasNext() ? scanner.next() : "";
                } else {
                    // Обрабатываем ошибочный ответ
                    return "Error: " + responseCode;
                }

            } catch (IOException e) {
                return "Exception: " + e.getMessage();
            }
        }
    }
}



