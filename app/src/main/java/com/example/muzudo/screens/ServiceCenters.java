package com.example.muzudo.screens;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.muzudo.R;

import java.nio.file.WatchEvent;

public class ServiceCenters extends Fragment {

    private WebView webView;

    @SuppressLint("SetJavaScriptEnabled")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.service_centers, container, false);
        webView = view.findViewById(R.id.service_centers);

        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("https://mizudo.com/where_buy/?TYPE_OF_SERVICE=SERVICE");
        return view;
    }
}
