package com.example.muzudo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

import com.example.muzudo.model.Image;
import com.example.muzudo.screens.GeysersFragment;

import java.util.List;

public class ZoomActivity extends AppCompatActivity {

    private ImageView imageView;

    private ScaleGestureDetector mScaleGestureDetector;
    private GestureDetector gestureDetector;

    private float mScale = 1f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zoom);
        imageView = findViewById(R.id.img_zoom);

        Bundle bundle = getIntent().getExtras();
        int pos = bundle.getInt("pos");
        int type = bundle.getInt("type");
        if(type == 1) {
            imageView.setImageResource(Repository.instructionsList.get(pos));
        }
        else if(type == 2){
            imageView.setImageResource(Repository.repairList.get(pos));
        }

        gestureDetector = new GestureDetector(this, new GestureListener());
        mScaleGestureDetector = new ScaleGestureDetector(this, new ScaleGestureDetector.
                SimpleOnScaleGestureListener() {
            @Override
            public boolean onScale(ScaleGestureDetector detector) {

                float scale = 1 - detector.getScaleFactor();
                float prevScale = mScale;
                mScale += scale;

                if (mScale > 10f)
                    mScale = 10f;

                ScaleAnimation scaleAnimation = new ScaleAnimation(1f / prevScale,
                        1f / mScale, 1f / prevScale, 1f / mScale,
                        detector.getFocusX(), detector.getFocusY());
                scaleAnimation.setDuration(0);
                scaleAnimation.setFillAfter(true);
                imageView.startAnimation(scaleAnimation);
                return true;
            }
        });
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        super.dispatchTouchEvent(event);

        mScaleGestureDetector.onTouchEvent(event);
        gestureDetector.onTouchEvent(event);
        return gestureDetector.onTouchEvent(event);
    }


    private class GestureListener extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onDown(MotionEvent e) {
            return true;
        }

        @Override
        public boolean onDoubleTap(MotionEvent e) {
            return true;
        }
    }
}