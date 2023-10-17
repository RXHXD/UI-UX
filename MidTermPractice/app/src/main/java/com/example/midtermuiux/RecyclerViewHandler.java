package com.example.midtermuiux;

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
import android.widget.LinearLayout;
import android.widget.Toast;

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
    //  GridLayoutManager gm = new GridLayoutManager(this,2);
    //  binding.handler.setLayoutManager(gm);
        ItemTouchHelper.SimpleCallback callback = new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public float getSwipeThreshold(@NonNull RecyclerView.ViewHolder viewHolder) {
                return 0.1f;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                System.out.println("Swiped Left");
                String TuneName = TuneList.get(viewHolder.getAdapterPosition()).getTuneName();
                int position = viewHolder.getAdapterPosition();
                if(direction == ItemTouchHelper.LEFT)
                {
                    AlertDialog.Builder builder = new AlertDialog.Builder(RecyclerViewHandler.this);
                    EditText editTextInputName = new EditText(RecyclerViewHandler.this);
                    builder.setView(editTextInputName);
                    builder.setTitle("Enter new Track");
                    builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
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
                            tuneAdapter.notifyDataSetChanged();
                        }
                    });
                    builder.show();

                }
                else{
                    Toast.makeText(RecyclerViewHandler.this,"Swiped Right"+TuneName,Toast.LENGTH_SHORT).show();
                    tuneAdapter.notifyDataSetChanged();
                }
            }

        };

    ItemTouchHelper helper = new ItemTouchHelper(callback);
    helper.attachToRecyclerView(binding.handler);

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