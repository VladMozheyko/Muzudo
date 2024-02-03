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
import com.example.muzudo.GeyserDetailsActivity;
import com.example.muzudo.MyDivider;
import com.example.muzudo.R;
import com.example.muzudo.Repository;
import com.example.muzudo.model.Geyser;
import com.example.muzudo.model.Image;

import java.util.ArrayList;
import java.util.List;

public class GeysersFragment extends Fragment {

    private RecyclerView recyclerView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.boilers_fragment, container, false);
        recyclerView = view.findViewById(R.id.boilers_list);
//        List<Image> images = new ArrayList<>();
//        images.add(new Image(R.drawable.geyser));
//        images.add(new Image(R.drawable.geyser));
//        images.add(new Image(R.drawable.geyser));
//        images.add(new Image(R.drawable.geyser));
//        images.add(new Image(R.drawable.geyser));
//        images.add(new Image(R.drawable.geyser));
//        images.add(new Image(R.drawable.geyser));
//        images.add(new Image(R.drawable.geyser));
//        images.add(new Image(R.drawable.geyser));
//        images.add(new Image(R.drawable.geyser));
//        images.add(new Image(R.drawable.geyser));
//        images.add(new Image(R.drawable.geyser));
//        images.add(new Image(R.drawable.geyser));
//        images.add(new Image(R.drawable.geyser));
//        images.add(new Image(R.drawable.geyser));
//        images.add(new Image(R.drawable.geyser));
        GeysersFragment.GeyserAdapter geyserAdapter = new GeyserAdapter(getContext(), Repository.geysers);

        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3,
                LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(geyserAdapter);
        recyclerView.addItemDecoration(new MyDivider());
        return view;
    }

    private class GeyserAdapter extends RecyclerView.Adapter<GeysersFragment.GeyserAdapter.ViewHolder> {

        private final LayoutInflater inflater;
        private final List<Geyser> images;

        public GeyserAdapter(Context context, List<Geyser> images) {
            this.images = images;
            this.inflater = LayoutInflater.from(context);
        }


        @NonNull
        @Override
        public GeysersFragment.GeyserAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = inflater.inflate(R.layout.geyser_item, parent, false);
            return new GeysersFragment.GeyserAdapter.ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull GeysersFragment.GeyserAdapter.ViewHolder holder, int position) {
            Geyser geyser = images.get(position);
            holder.imageView.setImageResource(geyser.getImg());
            holder.textView.setText(geyser.getTitle());
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
                textView = itemView.findViewById(R.id.geyser_title);
                imageView = itemView.findViewById(R.id.geyser_id);
                itemView.setOnClickListener(this);
            }

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), GeyserDetailsActivity.class);
                intent.putExtra("pos", count);
                startActivity(intent);
            }
        }
    }
}
