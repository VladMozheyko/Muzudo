package com.example.muzudo.screens;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.muzudo.GeyserDetailsActivity;
import com.example.muzudo.MyDivider;
import com.example.muzudo.R;
import com.example.muzudo.model.Image;

import java.util.ArrayList;
import java.util.List;

public class NewsFragment extends Fragment {

    RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.news_fragment, container, false);
        recyclerView = view.findViewById(R.id.news_list);

        List<Image> images = new ArrayList<>();
        images.add(new Image(R.drawable.geyser));
        images.add(new Image(R.drawable.geyser));
        images.add(new Image(R.drawable.geyser));
        images.add(new Image(R.drawable.geyser));
        images.add(new Image(R.drawable.geyser));
        images.add(new Image(R.drawable.geyser));
        images.add(new Image(R.drawable.geyser));
        images.add(new Image(R.drawable.geyser));
        images.add(new Image(R.drawable.geyser));
        images.add(new Image(R.drawable.geyser));
        images.add(new Image(R.drawable.geyser));
        images.add(new Image(R.drawable.geyser));
        images.add(new Image(R.drawable.geyser));
        images.add(new Image(R.drawable.geyser));
        images.add(new Image(R.drawable.geyser));
        images.add(new Image(R.drawable.geyser));
        NewsFragment.NewsAdapter newsAdapter = new NewsFragment.NewsAdapter(getContext(), images);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(newsAdapter);
        recyclerView.addItemDecoration(new MyDivider());
        return view;
    }

    private class NewsAdapter extends RecyclerView.Adapter<NewsFragment.NewsAdapter.ViewHolder> {

        private final LayoutInflater inflater;
        private final List<Image> images;

        public NewsAdapter(Context context, List<Image> images) {
            this.images = images;
            this.inflater = LayoutInflater.from(context);
        }


        @NonNull
        @Override
        public NewsFragment.NewsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = inflater.inflate(R.layout.news_item, parent, false);
            return new NewsFragment.NewsAdapter.ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull NewsFragment.NewsAdapter.ViewHolder holder, int position) {
            Image image = images.get(position);
          //  holder.imageView.setImageResource(image.res);
        }

        @Override
        public int getItemCount() {
            return images.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
            ImageView imageView;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                imageView = itemView.findViewById(R.id.boiler_id);
                itemView.setOnClickListener(this);
            }

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), GeyserDetailsActivity.class);
                startActivity(intent);
            }
        }
    }
}
