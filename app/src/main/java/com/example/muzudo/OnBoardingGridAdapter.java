package com.example.muzudo;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class OnBoardingGridAdapter extends BaseAdapter {

    private Context mContext;

    public OnBoardingGridAdapter(Context context) {
        mContext = context;
    }

    @Override
    public int getCount() {
        System.out.println("size: "+ Repository.onBoardingImages.size());
        return 5;
    }

    @Override
    public Object getItem(int position) {
        return Repository.onBoardingImages.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if(convertView == null){
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (ImageView) convertView;
        }
        imageView.setImageResource(Repository.onBoardingImages.get(position));
        return imageView;
    }
}
