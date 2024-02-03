package com.example.muzudo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class ErrorsActivity extends AppCompatActivity implements View.OnTouchListener{

    private ImageView imageView;

    private ImageView imageView1;
    private ImageView imageView2;
    private LinearLayout linearLayout;

    private ScaleGestureDetector mScaleGestureDetector;
    private GestureDetector gestureDetector;

    private float mScale = 1f;

    int count = 0;
    float x1;
    float x2;

    int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_errors);

        imageView = findViewById(R.id.img_errors);
        linearLayout = findViewById(R.id.errors_container);
        linearLayout.setOnTouchListener(this);


    }




    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        view.onTouchEvent(motionEvent);
        switch (motionEvent.getAction()) {
            case MotionEvent.ACTION_DOWN:
                x1 = motionEvent.getX();
                break;

            case MotionEvent.ACTION_UP:
                x2 = motionEvent.getX();

                        if (x1 - x2 > 20) {
                            showRight();

                        }

                        if (x1 - x2 < 20) {
                            showLeft();

                        }



        }
        return true;
    }

    private void showRight() {
        if(pos == 2){
            pos = 0;
            imageView.setImageResource(Repository.error_codes.get(pos));

            return;
        }
        pos++;
        imageView.setImageResource(Repository.error_codes.get(pos));


    }

    private void showLeft() {
        if(pos == 0){
            pos = 2;
            imageView.setImageResource(Repository.error_codes.get(pos));

            return;
        }

        pos--;
        imageView.setImageResource(Repository.error_codes.get(pos));

    }



}