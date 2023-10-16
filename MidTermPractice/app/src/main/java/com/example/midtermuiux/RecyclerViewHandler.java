package com.example.midtermuiux;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.example.midtermuiux.adapter.TuneAdapter;
import com.example.midtermuiux.databinding.ActivityMainBinding;
import com.example.midtermuiux.databinding.ActivityRecyclerViewHandlerBinding;
import com.example.midtermuiux.model.Tune;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RecyclerViewHandler extends AppCompatActivity {

    List<String> TuneNames = new ArrayList<>(Arrays.asList("beauty and the beast","Lion King","Marry Poppins","Game of Throne","Ozark"));
    List<Integer> TunePics = new ArrayList<>(Arrays.asList(R.drawable.beauty,R.drawable.lionking,R.drawable.marypoppins,R.drawable.gameofthrones,R.drawable.ozark));
    List<Tune> TuneList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityRecyclerViewHandlerBinding binding = ActivityRecyclerViewHandlerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        LoadModel();
        TuneAdapter tuneAdapter = new TuneAdapter(TuneList);
        LinearLayoutManager lm = new LinearLayoutManager(this);
      binding.handler.setAdapter(tuneAdapter);
      binding.handler.setLayoutManager(lm);

    }


    private void LoadModel()
    {
        for(int i=0;i<TuneNames.size();i++)
        {
            Tune eachTune = new Tune(TuneNames.get(i),TunePics.get(i));
            TuneList.add(eachTune);
        }

    }


}