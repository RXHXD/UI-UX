package com.example.datedemo;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import com.example.datedemo.databinding.ActivityMainBinding;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    //List<Dog> DogList;
    List<Dog> DogList;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ReadDogData();
        Log.d("DATEDEMO",DogList.size() + " dogs in the list");
         DogAdapter dogAdapter = new DogAdapter(DogList, new DogAdapter.OnItemClickListener() {
             @Override
             public void onItemClick(int i) {
                 binding.txtViewAdoptionSumary.setText("Thank You for taking "+DogList.get(i).getDogName()+" to their forever home");
             }
         });
         binding.recyclerViewDogItems.setAdapter(dogAdapter);
         binding.recyclerViewDogItems.setLayoutManager(new LinearLayoutManager(this));
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    private void ReadDogData(){

        DogList = new ArrayList<>();
        InputStream inputStream = getResources().openRawResource(R.raw.doginfo);
        BufferedReader reader = new BufferedReader(new InputStreamReader((inputStream)));
        try{
          String csvLine;
          // no header in input file
            while ((csvLine = reader.readLine()) != null)
            {
                String[] eachDogFields = csvLine.split(",");
                int dogId = Integer.parseInt(eachDogFields[0]);
                String resourceName = eachDogFields[1];
                String breedName = eachDogFields[2];
                String dogName = eachDogFields[3];
                String dogDobStr = eachDogFields[4];
                int dogDrawable = getResources().getIdentifier(resourceName,"drawable",getPackageName());

                // d- one or more digits for date e.g., 8,16,31
                // dd- two digits for date e.g., 08,16,31
                // MMM - three letter month code e.g., SEP, OCT, MAY
                // MM - two digit month numbers e.g., 01,12,10
                //yyyy - four digit year number e.g., 1638, 2023, 1949
                //yy - two digit year number e.g., 38, 23, 49

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MMM-yyyy");
                LocalDate dob = LocalDate.parse(dogDobStr,formatter);
                Dog eachDog = new Dog(dogId,breedName,dogName,dogDrawable,dob);
                DogList.add(eachDog);

            }

        }catch (Exception ex)
        {
            ex.printStackTrace();
        }



    }



}