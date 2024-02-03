package com.example.muzudo.screens;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.muzudo.MyDivider;
import com.example.muzudo.R;
import com.example.muzudo.Repository;
import com.example.muzudo.ZoomActivity;
import com.example.muzudo.model.Image;

import java.util.ArrayList;
import java.util.List;

public class TechDataFragment extends Fragment {
    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tech_data_fragment, container, false);
        recyclerView = view.findViewById(R.id.tech_images_list);

        ImageAdapter imageAdapter = new ImageAdapter(getActivity(), Repository.instructionsList);

        recyclerView.setAdapter(imageAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(imageAdapter);
        recyclerView.addItemDecoration(new MyDivider());
        return view;
    }
    public class ImageAdapter extends RecyclerView.Adapter<TechDataFragment.ImageAdapter.ViewHolder> {

        private final LayoutInflater inflater;
        private final List<Integer> images;

        public ImageAdapter(Context context, List<Integer> images) {
            this.images = images;
            this.inflater = LayoutInflater.from(context);
        }

        @NonNull
        @Override
        public TechDataFragment.ImageAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = inflater.inflate(R.layout.tech_item, parent, false);

            return new TechDataFragment.ImageAdapter.ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(TechDataFragment.ImageAdapter.ViewHolder holder, int position) {
            int image = images.get(position);
            holder.imageView.setImageResource(image);
            holder.pos = position;
        }

        @Override
        public int getItemCount() {
            return images.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder{
            ImageView imageView;
            int pos;
            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                imageView = itemView.findViewById(R.id.tech_image);
                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(getActivity(), ZoomActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("pos", pos); //Your id
                        bundle.putInt("type", 1); //Your id
                        intent.putExtras(bundle); //Put your id to your next Intent
                        startActivity(intent);
                    }
                });
            }
        }
    }
}
