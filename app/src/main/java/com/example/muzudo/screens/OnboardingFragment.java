package com.example.muzudo.screens;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.muzudo.OnBoardingGridAdapter;
import com.example.muzudo.R;
import com.example.muzudo.Repository;
import com.example.muzudo.model.Image;

public class OnboardingFragment extends Fragment implements View.OnTouchListener{

    private ImageView imageView;
    private ImageView stateImg;
    private TextView mainHeader;
    private TextView secondHeader;
    float x1;
    float x2;

    int pos;
    View view;

    private String[] mainHeaders;
    private String[] secondHeaders;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainHeaders =  getResources().getStringArray(R.array.main_headers);
        secondHeaders = getResources().getStringArray(R.array.second_headers);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.onboarding_fragment, container, false);

        init(view);

        return view;
    }

    private void init(View view) {
        imageView = view.findViewById(R.id.onboarding_image);
        stateImg = view.findViewById(R.id.onboardingStateImg1);
        mainHeader = view.findViewById(R.id.onboarding_main_header);
        secondHeader = view.findViewById(R.id.onboarding_second_header);
        imageView.setOnTouchListener(this);
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
        if(pos == 4){
            pos = 0;
            imageView.setImageResource(Repository.onBoardingImages.get(pos));
            mainHeader.setText(mainHeaders[pos]);
            secondHeader.setText(secondHeaders[pos]);
            return;
        }
        pos++;
        imageView.setImageResource(Repository.onBoardingImages.get(pos));
        stateImg.setImageResource(Repository.onBoardingStates.get(1));
        stateImg = view.findViewById(Repository.onBoardingStatePositions.get(pos));
        stateImg.setImageResource(Repository.onBoardingStates.get(0));
        mainHeader.setText(mainHeaders[pos]);
        secondHeader.setText(secondHeaders[pos]);
    }

    private void showLeft() {
        if(pos == 0){
            pos = 4;
            imageView.setImageResource(Repository.onBoardingImages.get(pos));
            mainHeader.setText(mainHeaders[pos]);
            secondHeader.setText(secondHeaders[pos]);
            return;
        }
        pos--;
        imageView.setImageResource(Repository.onBoardingImages.get(pos));
        stateImg.setImageResource(Repository.onBoardingStates.get(1));
        stateImg = view.findViewById(Repository.onBoardingStatePositions.get(pos));
        stateImg.setImageResource(Repository.onBoardingStates.get(0));
        mainHeader.setText(mainHeaders[pos]);
        secondHeader.setText(secondHeaders[pos]);
    }

}
