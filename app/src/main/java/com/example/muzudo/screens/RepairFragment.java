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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.muzudo.MyDivider;
import com.example.muzudo.R;
import com.example.muzudo.Repository;
import com.example.muzudo.ZoomActivity;
import com.example.muzudo.adapters.InstructionAdapter;

import java.util.List;
import java.util.ResourceBundle;

public class RepairFragment extends Fragment {

    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tech_data_fragment, container, false);
        recyclerView = view.findViewById(R.id.tech_images_list);

        InstructionAdapter adapter = new InstructionAdapter(getActivity(), Repository.repairList);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
        return view;
    }

    public class InstructionAdapter  extends RecyclerView.Adapter<InstructionAdapter.ViewHolder> {

        private final LayoutInflater inflater;
        private final List<Integer> images;

        public InstructionAdapter(Context context, List<Integer> images) {
            this.images = images;
            this.inflater = LayoutInflater.from(context);
        }


        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = inflater.inflate(R.layout.instruction_item, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            int pos = images.get(position);
            holder.imageView.setImageResource(pos);
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
                imageView = itemView.findViewById(R.id.instruction_image);
                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(getActivity(), ZoomActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("pos", pos); //Your id
                        bundle.putInt("type", 2); //Your id
                        intent.putExtras(bundle); //Put your id to your next Intent
                        startActivity(intent);
                    }
                });


            }
        }
    }

//    public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHolder> {
//
//        private final LayoutInflater inflater;
//        private final List<Integer> images;
//
//        public ImageAdapter(Context context, List<Integer> images) {
//            this.images = images;
//            this.inflater = LayoutInflater.from(context);
//        }
//
//
//        @NonNull
//        @Override
//        public ImageAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//            View view = inflater.inflate(R.layout.tech_item, parent, false);
//
//            return new RepairFragment.ImageAdapter.ViewHolder(view);
//        }
//
//
//        @Override
//        public void onBindViewHolder(ViewHolder holder, int position) {
//            int image = images.get(position);
//            holder.imageView.setImageResource(image);
//            holder.pos = position;
//        }
//
//        @Override
//        public int getItemCount() {
//            return images.size();
//        }
//
//        public class ViewHolder extends RecyclerView.ViewHolder{
//            ImageView imageView;
//            int pos;
//            public ViewHolder(@NonNull View itemView) {
//                super(itemView);
//                imageView = itemView.findViewById(R.id.tech_image);
//                imageView.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        Intent intent = new Intent(getActivity(), ZoomActivity.class);
//                        Bundle bundle = new Bundle();
//                        bundle.putInt("pos", pos); //Your id
//                        bundle.putInt("type", 2); //Your id
//                        intent.putExtras(bundle); //Put your id to your next Intent
//                        startActivity(intent);
//                    }
//                });
//
//
//            }
//        }
  //  }
}
