package com.example.selfpracticeviewdemo;

import android.content.Context;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.core.view.GestureDetectorCompat;

public class CustomTouchListener implements View.OnTouchListener{

    GestureDetectorCompat gestureDetectorCompat;
    final String TAG="VIEW DEMO";
    public CustomTouchListener(Context context) {
             gestureDetectorCompat = new GestureDetectorCompat(context,new CustomGestureListener());
    }


    public class CustomGestureListener extends GestureDetector.SimpleOnGestureListener{
        @Override
        public boolean onDown(@NonNull MotionEvent e) {
           // return super.onDown(e);
            return true;
        }

        @Override
        public boolean onSingleTapConfirmed(@NonNull MotionEvent e) {
            onSingleClick();
            return super.onSingleTapConfirmed(e);
        }

        @Override
        public boolean onDoubleTap(@NonNull MotionEvent e) {
            onDoubleClick();
            return super.onDoubleTap(e);
        }

        @Override
        public void onLongPress(@NonNull MotionEvent e) {
            onLongClick();
            super.onLongPress(e);
        }

        @Override
        public boolean onFling(@NonNull MotionEvent e1, @NonNull MotionEvent e2, float velocityX, float velocityY) {
            return super.onFling(e1, e2, velocityX, velocityY);
        }
    }

    public void onSingleClick() {
        Log.d(TAG,"Entered custom touch listener single click");
    }

    public  void onDoubleClick() {
        Log.d(TAG,"Entered custom touch listener Double click");
    }

    public void onLongClick() {
        Log.d(TAG,"Entered custom touch listener long click");
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        //return false; // need to pass the buck to gesture detector's on Touch
       return gestureDetectorCompat.onTouchEvent(motionEvent);
    }


}
