package com.example.midtermuiux;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class GestureViewHandler extends AppCompatActivity {
  boolean bigger = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gesture_view_handler);
        ImageView img = findViewById(R.id.imageView);
        TextView txtViewSample = findViewById(R.id.txtViewSample);

        img.setImageResource(R.drawable.bird);
        // Make a Drawable img
        Drawable imger = ResourcesCompat.getDrawable(getResources(),R.drawable.border,getTheme());
        imger.setBounds(0,0,imger.getIntrinsicWidth(),imger.getIntrinsicHeight());

        // Add the image to the text Box
        txtViewSample.setCompoundDrawables(imger,null,imger,null);

        // Adding padding to the text View
        txtViewSample.setCompoundDrawablePadding(8);
        txtViewSample.setAlpha(1.0f);

        // Set Up an On touch click Listener
        txtViewSample.setOnTouchListener(new CustomTouchListener(GestureViewHandler.this){

            @Override
            public void onSingleClick() {
                super.onSingleClick();
                if(txtViewSample.getCurrentTextColor() != ResourcesCompat.getColor(getResources(),R.color.purple_200,getTheme()))
                {
                    txtViewSample.setTextColor(ResourcesCompat.getColor(getResources(),R.color.purple_200,getTheme()));
                }
                else{
                    txtViewSample.setTextColor(Color.rgb(255,255,255));
                }
            }

            @Override
            public void onDoubleClick() {
                super.onDoubleClick();
                if(!bigger)
                {
                    txtViewSample.setTextSize(txtViewSample.getTextSize()/getResources().getDisplayMetrics().density +10);
                    bigger = true;
                }
                else{
                    txtViewSample.setTextSize(txtViewSample.getTextSize()/getResources().getDisplayMetrics().density -10);
                    bigger = false;
                }
            }

            @Override
            public void onLongClick() {

                if(txtViewSample.getPaint().isStrikeThruText())
                {
                    txtViewSample.setPaintFlags(txtViewSample.getPaintFlags() & ~Paint.STRIKE_THRU_TEXT_FLAG);
                }
                else{
                    txtViewSample.setPaintFlags(txtViewSample.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                }

            }

            @Override
            public void onSwipeUp() {
                super.onSwipeUp();
                int horzGravity = txtViewSample.getGravity() & Gravity.HORIZONTAL_GRAVITY_MASK;
                txtViewSample.setGravity(horzGravity | Gravity.TOP);

            }

            @Override
            public void onSwipeDown() {
                super.onSwipeDown();
                int horzGravity = txtViewSample.getGravity() & Gravity.HORIZONTAL_GRAVITY_MASK;
                txtViewSample.setGravity(horzGravity | Gravity.BOTTOM);
            }

            @Override
            public void onSwipeLeft() {
                super.onSwipeLeft();
               int vertzGravity = txtViewSample.getGravity() & Gravity.VERTICAL_GRAVITY_MASK;
               txtViewSample.setGravity(vertzGravity | Gravity.LEFT);
            }

            @Override
            public void onSwipeRight() {
                super.onSwipeRight();
                int vertzGravity = txtViewSample.getGravity() & Gravity.VERTICAL_GRAVITY_MASK;
                txtViewSample.setGravity(vertzGravity | Gravity.RIGHT);

            }

            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return super.onTouch(view, motionEvent);
            }


        });

        img.setOnTouchListener(new CustomTouchListener(GestureViewHandler.this){

            @Override
            public void onSingleClick() {
                super.onSingleClick();
                if(img.getDrawable().getConstantState() != ResourcesCompat.getDrawable(getResources(),R.drawable.bird,getTheme()).getConstantState()){
                    img.setImageResource(R.drawable.bird);
                }
                else{
                    img.setImageResource(R.drawable.fire);
                }
            }
            @Override
            public void onDoubleClick() {
                super.onDoubleClick();
                if(img.getScaleType() != ImageView.ScaleType.FIT_XY)
                {
                    img.setScaleType(ImageView.ScaleType.FIT_XY);
                }
                else{
                    img.setScaleType(ImageView.ScaleType.FIT_CENTER);
                }
            }
        });






    }


}