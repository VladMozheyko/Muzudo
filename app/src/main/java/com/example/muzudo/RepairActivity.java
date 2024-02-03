package com.example.muzudo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.muzudo.adapters.InstructionAdapter;
import com.example.muzudo.model.Image;

import java.util.ArrayList;
import java.util.List;

public class RepairActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repair);
        recyclerView = findViewById(R.id.repair_list);
//        List<Image> images = new ArrayList<>();
//
//        InstructionAdapter adapter = new InstructionAdapter(this, images);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
   //     recyclerView.setAdapter(adapter);
    }
}