package com.example.midtermuiux;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button gestures = findViewById(R.id.gestures);
        Button recycler = findViewById(R.id.recyclerhandle);

        gestures.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,GestureViewHandler.class);
                startActivity(intent);
            }
        });

        recycler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             Intent intent = new Intent(MainActivity.this,RecyclerViewHandler.class);
             startActivity(intent);
            }
        });


    }


}