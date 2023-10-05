package com.example.selfpracticeviewdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    final String TAG ="GESTURE_DEMO";

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

    }
}