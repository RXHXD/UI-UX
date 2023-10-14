package com.example.recyclerviewdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.example.recyclerviewdemo.adapters.TuneAdapter;
import com.example.recyclerviewdemo.databinding.ActivityMainBinding;
import com.example.recyclerviewdemo.model.Tune;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<String> TuneNames = new ArrayList<>(Arrays.asList("Beauty and the Beast",
            "Lion King", "Mary Poppins", "Game of Thrones", "Ozark" ));
    List<Integer> TunePics = new ArrayList<>(Arrays.asList(R.drawable.beauty,
            R.drawable.lionking, R.drawable.marypoppins,
            R.drawable.gameofthrones, R.drawable.ozark ));
    List<Tune> TuneList = new ArrayList<>(); //empty list

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        ActivityMainBinding binding
                = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        LoadModel();

        TuneAdapter tuneAdapter = new TuneAdapter(TuneList);
        LinearLayoutManager lm = new LinearLayoutManager(this);
        binding.reccyclerViewTunes.setAdapter(tuneAdapter);
        binding.reccyclerViewTunes.setLayoutManager(lm);

        GridLayoutManager gm = new GridLayoutManager(this,1);
        binding.reccyclerViewTunes.setLayoutManager(gm);


        ItemTouchHelper.SimpleCallback callback = new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public float getSwipeThreshold(@NonNull RecyclerView.ViewHolder viewHolder) {
                return 0.1f;
            }

            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
              return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                String TuneName = TuneList.get(viewHolder.getAdapterPosition()).getTuneName();
                int position = viewHolder.getAdapterPosition();
                 if(direction == ItemTouchHelper.LEFT)
                 {
//                     Toast.makeText(MainActivity.this,"Swiped Left ",+Toast.LENGTH_SHORT).show();
//                     tuneAdapter.notifyDataSetChanged();

                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                     EditText editTextInputName = new EditText(MainActivity.this);
                     builder.setView(editTextInputName);
                     builder.setTitle("Enter New Track");
                     builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                         @Override
                         public void onClick(DialogInterface dialogInterface, int i) {
                             // get the new text
                             // change the text
                             // call notify data set Changed
                             tuneAdapter.getAdapterTuneList().get(position).setTuneName(editTextInputName.getText().toString());
                              tuneAdapter.notifyDataSetChanged();
                         }
                     });


                     builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                         @Override
                         public void onClick(DialogInterface dialogInterface, int i) {
                               tuneAdapter.notifyDataSetChanged();
                         }
                     });

                     builder.setOnDismissListener(new DialogInterface.OnDismissListener() {
                         @Override
                         public void onDismiss(DialogInterface dialogInterface) {
                             tuneAdapter.
                                     notifyDataSetChanged();
                         }
                     });


                  builder.show();

                 } else{
                     Toast.makeText(MainActivity.this,"Swiped Right"+TuneName,Toast.LENGTH_SHORT).show();
                    tuneAdapter.notifyDataSetChanged();
                 }
            }
        };

        ItemTouchHelper helper = new ItemTouchHelper(callback);
        helper.attachToRecyclerView(binding.reccyclerViewTunes);


    }
    private void LoadModel(){
        for (int i = 0; i < TuneNames.size(); i++){
            Tune eachTune = new Tune(TuneNames.get(i), TunePics.get(i));
            TuneList.add(eachTune); //cannot be done if list is null
        }
    }
}