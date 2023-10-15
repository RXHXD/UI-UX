package com.example.midtermuiux;

import android.content.Context;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.core.view.GestureDetectorCompat;

public class CustomTouchListener implements View.OnTouchListener{


    GestureDetectorCompat gestureDetectorCompat;

    final String TAG = "View Demo";
    public CustomTouchListener(Context context)
    {
        gestureDetectorCompat = new GestureDetectorCompat(context,new CustomGestureListener());
    }



    public class CustomGestureListener extends GestureDetector.SimpleOnGestureListener{


        public CustomGestureListener() {
            super();
        }

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
            final int SWIPE_DIST_THRESHOLD = 10;
            final int SWIPE_VEL_THRESHOLD = 20;
            float distX = e2.getX() - e1.getX();
            float distY = e2.getY() - e1.getY();

            if(Math.abs(distX) > Math.abs(distY)   &&
                Math.abs(distX) > SWIPE_DIST_THRESHOLD &&
                Math.abs(velocityX) > SWIPE_VEL_THRESHOLD)
            {
                if(distX > 0)
                {
                    onSwipeRight();
                }
                else{
                    onSwipeLeft();
                }
            } else if(  Math.abs(distY) > Math.abs(distX) &&
                        Math.abs(distY) > SWIPE_DIST_THRESHOLD &&
                        Math.abs(velocityY) > SWIPE_VEL_THRESHOLD)
            {
                if(distY > 0)
                {
                    onSwipeDown();
                }
                else{
                    onSwipeUp();
                }
            }
            return super.onFling(e1, e2, velocityX, velocityY);
        }

        @Override
        public void onShowPress(@NonNull MotionEvent e) {
            super.onShowPress(e);
        }

        @Override
        public boolean onDown(@NonNull MotionEvent e) {
            return true;
        }

        @Override
        public boolean onDoubleTap(@NonNull MotionEvent e) {
            return super.onDoubleTap(e);
        }

        @Override
        public boolean onDoubleTapEvent(@NonNull MotionEvent e) {
            onDoubleClick();
            return super.onDoubleTapEvent(e);
        }

        @Override
        public boolean onSingleTapConfirmed(@NonNull MotionEvent e) {
            onSingleClick();
            return super.onSingleTapConfirmed(e);
        }

        @Override
        public boolean onContextClick(@NonNull MotionEvent e) {
            return super.onContextClick(e);
        }
    }

    public void onSingleClick() {
        Log.d(TAG,"Entered custom on Touch Single Click Listener");
    }

    public void onDoubleClick() {
        Log.d(TAG,"Entered custom on Touch Double Click Listener");
    }

    public void onLongClick() {
     Log.d(TAG,"Entered custom on Touch Long Listener");
    }


    public void onSwipeUp() {
        Log.d(TAG,"Entered custom on Swipe Up");
    }



    public void onSwipeDown() {
        Log.d(TAG,"Entered custom on Swipe Down");
    }

    public void onSwipeLeft() {
        Log.d(TAG,"Entered custom on Swipe Left");
    }

    public void onSwipeRight() {
        Log.d(TAG,"Entered custom on Swipe Right");
    }



    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return gestureDetectorCompat.onTouchEvent(motionEvent);
    }
}
