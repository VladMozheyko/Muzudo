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
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.muzudo.BoilerDetailsActivity;
import com.example.muzudo.MyDivider;
import com.example.muzudo.R;
import com.example.muzudo.Repository;
import com.example.muzudo.model.Boiler;
import com.example.muzudo.model.Image;

import java.util.ArrayList;
import java.util.List;

public class BoilersFragment extends Fragment {

    private RecyclerView recyclerView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.boilers_fragment, container, false);
        recyclerView = view.findViewById(R.id.boilers_list);

        BoilerAdapter boilerAdapter = new BoilerAdapter(getContext(), Repository.boilers);

        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3,
                LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(boilerAdapter);
        recyclerView.addItemDecoration(new MyDivider());
        return view;
    }

    private class BoilerAdapter extends RecyclerView.Adapter<BoilerAdapter.ViewHolder> {

        private final LayoutInflater inflater;
        private final List<Boiler> images;

        public BoilerAdapter(Context context, List<Boiler> images) {
            this.images = images;
            this.inflater = LayoutInflater.from(context);
        }


        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = inflater.inflate(R.layout.boiler_item, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            Boiler boiler = images.get(position);
            holder.imageView.setImageResource(boiler.getImg());
            holder.textView.setText(boiler.getTitle());
            holder.count = position;


        }

        @Override
        public int getItemCount() {
            return images.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
            ImageView imageView;
            TextView textView;
            int count;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                imageView = itemView.findViewById(R.id.boiler_id);
                textView = itemView.findViewById(R.id.boiler_title);
                itemView.setOnClickListener(this);
            }

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), BoilerDetailsActivity.class);
                intent.putExtra("pos", count);
                startActivity(intent);
            }
        }
    }
}
