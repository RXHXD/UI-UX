package com.example.finalpractice;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;

import androidx.core.view.WindowCompat;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.finalpractice.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    // DeepPhone Array List
    List<DeepPhone> deepPhoneList = new ArrayList<>();
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void ReadCsv()
    {
      InputStream inputStream = getResources().openRawResource(R.raw.phoneinfo);
      BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
      try{
          String csvLine;
         while((csvLine = reader.readLine()) != null){
             String[] eachPhoneField = csvLine.split(",");
             int phoneId = Integer.parseInt(eachPhoneField[0]);
             String modelName = eachPhoneField[1];
             String monthlyPlan = eachPhoneField[2];
             String phoneCameraDescription = eachPhoneField[3];
             int totalPhoneAmount = Integer.parseInt(eachPhoneField[4]);
             String phonereleaseDate = eachPhoneField[5];

             // one line for putting all the images
           int phoneDrawable = getResources().getIdentifier(modelName,"drawable",getPackageName());

           // formatting the date
             DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
             LocalDate dob = LocalDate.parse(phonereleaseDate,formatter);




             // creation of Object
             DeepPhone deepPhone = new DeepPhone(phoneId,modelName,monthlyPlan,phoneCameraDescription,totalPhoneAmount,phoneDrawable,dob);

             deepPhoneList.add(deepPhone);
         }

      }catch (Exception e)
      {
          e.printStackTrace();
      }


      for(int i=0; i<deepPhoneList.size();i++)
      {
          Log.d("msg",deepPhoneList.get(i).toString());
      }



    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Cool", Snackbar.LENGTH_LONG)
                        .setAnchorView(R.id.fab)
                        .setAction("Action", null).show();
            }
        });

        // make a list of Phone Type
        List<Phone> phoneList = new ArrayList<>();

        // Adding manual Data into the List
        List<String> phoneDesc = new ArrayList<>(Arrays.asList("Nakia","Blackbeery","Lenova","Asus"));
        List<Integer> phoneColor = new ArrayList<>(Arrays.asList(
                Color.parseColor("#000000"),
                Color.rgb(255,165,0),
                Color.parseColor("#FF00FF"),
                Color.parseColor("#008080")
               ));

        // adding element to phone model
        for (int i=0;i<phoneDesc.size();i++)
        {
            Phone phone = new Phone(phoneColor.get(i),phoneDesc.get(i));
            phoneList.add(phone);
        }


        // call csv file
        ReadCsv();

          // making instance of Phone View Model
        PhoneViewModel phoneViewModel = new ViewModelProvider(this).get(PhoneViewModel.class);
        phoneViewModel.loadColorList(phoneList);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Toast.makeText(this,"Clicked on settings",Toast.LENGTH_SHORT).show();
            return true;
        } else if(id == R.id.action_search) {
            Toast.makeText(this,"Clicked on Search",Toast.LENGTH_SHORT).show();
            return true;
        } else if(id == R.id.action_profile) {
            Toast.makeText(this,"Clicked on userprofile",Toast.LENGTH_SHORT).show();
             return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }
}