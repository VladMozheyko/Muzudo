package com.example.muzudo.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.muzudo.R;
import com.example.muzudo.model.Image;


import java.util.List;

public class InstructionAdapter  extends RecyclerView.Adapter<InstructionAdapter.ViewHolder> {

    private final LayoutInflater inflater;
    private final List<Integer> images;

    public InstructionAdapter(Context context, List<Integer> images) {
        this.images = images;
        this.inflater = LayoutInflater.from(context);
    }


    @NonNull
    @Override
    public InstructionAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.instruction_item, parent, false);
        return new InstructionAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull InstructionAdapter.ViewHolder holder, int position) {
        int pos = images.get(position);
        holder.imageView.setImageResource(pos);
    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.instruction_image);
        }

    }
}
