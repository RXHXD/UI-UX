package com.example.selfpracticeviewdemo;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;

import androidx.core.view.GestureDetectorCompat;

public class CustomTouchListener implements View.OnTouchListener{

    GestureDetectorCompat gestureDetectorCompat;

    public CustomTouchListener(Context context) {

    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return false;
    }
}
