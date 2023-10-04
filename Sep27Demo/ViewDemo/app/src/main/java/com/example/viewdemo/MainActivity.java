package com.example.viewdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.content.res.Resources;
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

    final String TAG = "GESTURE_DEMO";
    boolean bigger = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG,"Entered Gesture Demo");
        try {
           //bunch of stmts
        } catch (Exception ex){
            //you may add a log Log.e(TAG, "error msg");
            //add a toast to the user indicating something needs fixing
            ex.printStackTrace();
        }
        TextView txtViewSample = findViewById(R.id.txtViewSample);
        ImageView imgViewSample = findViewById(R.id.imgViewSample);
        Button btnShowTextOrImage = findViewById(R.id.btnShowTextOrImage);
        Button btnShowBoth = findViewById(R.id.btnShowBoth);
        Drawable img = ResourcesCompat.getDrawable(
                            getResources(),
                            R.drawable.border,getTheme());
        img.setBounds(0, 0,
                img.getIntrinsicWidth(),img.getIntrinsicHeight());
        txtViewSample.setCompoundDrawables(img,null,img,null);
        txtViewSample.setCompoundDrawablePadding(8);
        txtViewSample.setAlpha(1f); //float value - 1 - fully opaque, 0 - fully transparent

        //A few questions about padding, and height have come up
	//I will address these next week - please remind me

        btnShowBoth.setOnClickListener((View view) -> {
            //both text view and img view visible
            txtViewSample.setVisibility(View.VISIBLE);
            imgViewSample.setVisibility(View.VISIBLE);
        });
        btnShowTextOrImage.setOnClickListener((View view) -> {
            if (btnShowTextOrImage.getText()
                    .toString().equals("Show Text")){
                txtViewSample.setVisibility(View.VISIBLE);
                imgViewSample.setVisibility(View.INVISIBLE);
                btnShowTextOrImage.setText(getResources()
                        .getText(R.string.txtShowImage));
            } else {
                txtViewSample.setVisibility(View.GONE);
                imgViewSample.setVisibility(View.VISIBLE);
                btnShowTextOrImage.setText(getResources()
                        .getText(R.string.txtShowText));
            }

        });

        //set up on Touch Listener on TextView
        txtViewSample.setOnTouchListener(new CustomTouchListener(MainActivity.this){
            @Override
            public void onSingleClick() {
                super.onSingleClick();
                if (txtViewSample.getCurrentTextColor() !=
                            ResourcesCompat.getColor(
                                    getResources(),R.color.purple_200,getTheme())){
                    txtViewSample.setTextColor(ResourcesCompat.getColor(getResources(),
                                R.color.purple_200,getTheme()));
                } else {
                    //txtViewSample.setTextColor(Color.WHITE);
                    txtViewSample.setTextColor(Color.rgb(255,255,255));
                }
            }

            @Override
            public void onDoubleClick() {
                //change the font size
                if (!bigger){
                    txtViewSample.setTextSize(
                            txtViewSample.getTextSize()
                                    /getResources().getDisplayMetrics().density + 10);
                    bigger = true;
                } else {
                    txtViewSample.setTextSize(
                            txtViewSample.getTextSize()
                                    /getResources().getDisplayMetrics().density - 10);
                    bigger = false;
                }

                super.onDoubleClick();
            }

            @Override
            public void onLongClick() {
                //here have the logic for what long click
                //on TextView should do
                if (txtViewSample.getPaint().isStrikeThruText()){
                    txtViewSample.setPaintFlags(txtViewSample.getPaintFlags()
                                    & ~Paint.STRIKE_THRU_TEXT_FLAG);
                } else {
                    txtViewSample.setPaintFlags(txtViewSample.getPaintFlags()
                            | Paint.STRIKE_THRU_TEXT_FLAG);
                }
                super.onLongClick();
            }

            @Override
            public void onSwipeUp() {
                super.onSwipeUp();
                int horzGravity = txtViewSample.getGravity()
                            & Gravity.HORIZONTAL_GRAVITY_MASK;
                txtViewSample.setGravity(horzGravity | Gravity.TOP);
            }

            @Override
            public void onSwipeDown() {
                super.onSwipeDown();
                int horzGravity = txtViewSample.getGravity()
                        & Gravity.HORIZONTAL_GRAVITY_MASK;
                txtViewSample.setGravity(horzGravity | Gravity.BOTTOM);
            }

            @Override
            public void onSwipeLeft() {
                super.onSwipeLeft();
                int verGravity = txtViewSample.getGravity()
                        & Gravity.VERTICAL_GRAVITY_MASK;
                txtViewSample.setGravity(verGravity | Gravity.LEFT);
            }

            @Override
            public void onSwipeRight() {
                super.onSwipeRight();
                int verGravity = txtViewSample.getGravity()
                        & Gravity.VERTICAL_GRAVITY_MASK;
                txtViewSample.setGravity(verGravity | Gravity.RIGHT);
            }

            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Log.d(TAG,"Entered TextView on Touch");
                return super.onTouch(view, motionEvent);
            }
        });

        imgViewSample.setOnTouchListener(
                new CustomTouchListener(MainActivity.this) {
                    @Override
                    public void onSingleClick() {

                        super.onSingleClick();
                       if(imgViewSample.getDrawable().getConstantState() != ResourcesCompat.getDrawable(getResources(),R.drawable.bird,getTheme()).getConstantState())
                       {
                          imgViewSample.setImageResource(R.drawable.bird);
                       }
                        else{
                            imgViewSample.setImageResource(R.drawable.fire);
                       }

                    }

                    @Override
                    public void onDoubleClick() {
                        super.onDoubleClick();


                        if(imgViewSample.getScaleType() != ImageView.ScaleType.FIT_XY){
                            imgViewSample.setScaleType(ImageView.ScaleType.FIT_XY);
                        }
                        else{
                            imgViewSample.setScaleType(ImageView.ScaleType.FIT_CENTER);
                        }
                    }
                });

    }
}