package com.example.selfpracticeviewdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    final String TAG ="GESTURE_DEMO";
    boolean bigger = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG,"Entered Gesture Demo");
        try{
            // bunch of stmts
        }catch (Exception e)
        {
          // add a toast to user indicating something needs fixing
            e.printStackTrace();
        }
        TextView txtViewSample = findViewById(R.id.txtViewSample);
        ImageView imageViewSample = findViewById(R.id.imgViewSample);
        Button shButtonTextOrImg = findViewById(R.id.btnTxtOrImage);
        Button shButtonBoth = findViewById(R.id.btnShowBoth);

        // get the drawable img from the resources
        Drawable img = ResourcesCompat.getDrawable(getResources(),R.drawable.border,getTheme());

        img.setBounds(0,0,img.getIntrinsicWidth(),img.getIntrinsicHeight());
        txtViewSample.setCompoundDrawables(img,null,img,null);
        txtViewSample.setCompoundDrawablePadding(8);
        txtViewSample.setAlpha(1.0f); // 1- fully Opaque, 0- fully transparent
        shButtonBoth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtViewSample.setVisibility(View.VISIBLE);
                imageViewSample.setVisibility(View.VISIBLE);
            }
        });

        shButtonTextOrImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(shButtonTextOrImg.getText().toString().equals("show Text"))
                {
                    txtViewSample.setVisibility(View.VISIBLE);
                    imageViewSample.setVisibility(View.INVISIBLE);
                    shButtonTextOrImg.setText(getResources().getText(R.string.txtShowImage));
                }
                else{
                    txtViewSample.setVisibility(View.GONE);
                    imageViewSample.setVisibility(View.VISIBLE);
                    shButtonTextOrImg.setText(getResources().getText(R.string.txtShowText));
                }
            }
        });

        // set up on Touch Listener on TextView
        txtViewSample.setOnTouchListener(new CustomTouchListener(MainActivity.this){
            @Override
            public void onSwipeUp() {
                super.onSwipeUp();
                int horzGravity = txtViewSample.getGravity() & Gravity.HORIZONTAL_GRAVITY_MASK;
                txtViewSample.setGravity(horzGravity | Gravity.TOP);
            }

            @Override
            public void onSwipeDown() {
                int horzGravity = txtViewSample.getGravity() & Gravity.HORIZONTAL_GRAVITY_MASK;
                txtViewSample.setGravity(horzGravity | Gravity.BOTTOM);
                super.onSwipeDown();
            }

            @Override
            public void onSwipeLeft() {
                int vertzGravity = txtViewSample.getGravity() & Gravity.VERTICAL_GRAVITY_MASK;
                txtViewSample.setGravity(vertzGravity | Gravity.LEFT);
                super.onSwipeLeft();
            }

            @Override
            public void onSwipeRight() {
                int vertzGravity = txtViewSample.getGravity() & Gravity.VERTICAL_GRAVITY_MASK;
                txtViewSample.setGravity(vertzGravity | Gravity.RIGHT);
                super.onSwipeRight();
            }

            @Override
            public void onLongClick() {

                if(txtViewSample.getPaint().isStrikeThruText())
                {
                    txtViewSample.setPaintFlags(txtViewSample.getPaintFlags() & ~Paint.STRIKE_THRU_TEXT_FLAG);

                }else{
                    txtViewSample.setPaintFlags(txtViewSample.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

                }
                super.onLongClick();
            }

            @Override
            public void onSingleClick() {


                super.onSingleClick();

                if(txtViewSample.getCurrentTextColor() != ResourcesCompat.getColor(getResources(),R.color.purple_200,getTheme())){
                    txtViewSample.setTextColor(ResourcesCompat.getColor(getResources(),R.color.purple_200,getTheme()));

                }
                else{
                    //txtViewSample.setTextColor(Color.WHITE);
                      txtViewSample.setTextColor(Color.rgb(255,255,255));
                }
            }

            @Override
            public void onDoubleClick() {

                 if(!bigger)
                 {
                     txtViewSample.setTextSize(txtViewSample.getTextSize()/getResources().getDisplayMetrics().density + 10);
                   bigger = true;
                 } else{
                     txtViewSample.setTextSize(txtViewSample.getTextSize()/getResources().getDisplayMetrics().density - 10);
                   bigger = false;
                 }
                super.onDoubleClick();
            }

            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Log.d(TAG,"Entered TextView on Touch");
                return super.onTouch(view, motionEvent);
            }
        });

        imageViewSample.setOnTouchListener(new CustomTouchListener(MainActivity.this){
            @Override
            public void onSingleClick() {
                super.onSingleClick();
            }

            @Override
            public void onDoubleClick() {
                super.onDoubleClick();
            }
        });


    }
}