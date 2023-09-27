package com.example.viewdemo;

import android.content.Context;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.core.view.GestureDetectorCompat;

public class CustomTouchListener implements View.OnTouchListener{
    GestureDetectorCompat gestureDetectorCompat; //needs the context
    final String TAG = "View Demo";
    public CustomTouchListener(Context context) {
        gestureDetectorCompat = new GestureDetectorCompat(context,new CustomGestureListener());
    }


    //create custom gesture listener
    //use that to create gestureDetectorCompat object
    // can detect long Press, UpSwipe, DownSwipe
    // it detects a method Fling : sudden quick movement around different direction
    public class CustomGestureListener extends GestureDetector.SimpleOnGestureListener {

        @Override
        public boolean onSingleTapUp(@NonNull MotionEvent e) {
            return super.onSingleTapUp(e);
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

        @Override
        public boolean onDown(@NonNull MotionEvent e) {
           // return super.onDown(e);
            return true;
        }

        @Override
        public boolean onDoubleTap(@NonNull MotionEvent e) {
            onDoubleClick();
            return super.onDoubleTap(e);
        }

        @Override
        public boolean onSingleTapConfirmed(@NonNull MotionEvent e) {
            return super.onSingleTapConfirmed(e);
        }
    }

    public void onDoubleClick() {
        Log.d(TAG,"Entered custom touch listener double click");
    }

    public void onLongClick() {
   Log.d(TAG,"Entered custom touch listener long click");
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {

        // return false //need ti pass the buck to gesturedetectors's onTouch

        return gestureDetectorCompat.onTouchEvent(motionEvent);
    }
}
