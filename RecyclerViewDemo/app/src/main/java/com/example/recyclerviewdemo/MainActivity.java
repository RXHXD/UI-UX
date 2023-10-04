package com.example.recyclerviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<String> TuneNames = new ArrayList<>(Arrays.asList("Beauty and the Beast",
            "Lion King", "Mary Poppins", "Game of Thrones", "Ozark" ));
    List<Integer> TunePics = new ArrayList<>(Arrays.asList(R.drawable.beauty,
            R.drawable.lionking, R.drawable.marypoppins,
            R.drawable.gameofthrones, R.drawable.ozark ));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}