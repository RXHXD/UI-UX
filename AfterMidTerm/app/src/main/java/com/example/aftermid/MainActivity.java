package com.example.aftermid;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.core.view.WindowCompat;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.aftermid.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        binding.mainContent.mainLayout.setBackgroundColor(Color.parseColor("#FAFAFA"));
        binding.fab.setBackgroundTintList(ColorStateList.valueOf(Color.LTGRAY));
        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ColorDrawable colorDrawable = (ColorDrawable)binding.mainContent.mainLayout.getBackground();
                int colorId = colorDrawable.getColor();
                if(colorId == Color.LTGRAY)
                {
                    binding.mainContent.mainLayout.setBackgroundColor(Color.parseColor("#FAFAFA"));
                    binding.fab.setBackgroundTintList(ColorStateList.valueOf(Color.LTGRAY));
                }
                else{
                    binding.mainContent.mainLayout.setBackgroundColor(Color.LTGRAY);
                    binding.fab.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FAFAFA")));
                }
                Snackbar.make(view, "Like the new Color?", Snackbar.LENGTH_LONG)
                        .setAnchorView(R.id.fab)
                        .setAction("Undo", null).setAction("Undo", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                             if(colorId == Color.LTGRAY)
                             {

                                 binding.mainContent.mainLayout.setBackgroundColor(Color.LTGRAY);
                                 binding.fab.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FAFAFA")));
                             }

                             else{
                                 binding.mainContent.mainLayout.setBackgroundColor(Color.parseColor("#FAFAFA"));
                                 binding.fab.setBackgroundTintList(ColorStateList.valueOf(Color.LTGRAY));
                             }

                            }
                        }).show();
            }
        });
        List<ColorSpec> ColorSpecs = new ArrayList<>();
        List<String> ColorDescs = new ArrayList<>(Arrays.asList("BLACK","ORANGE","PURPLE"));
        List<Integer> ColorVals = new ArrayList<>(
                Arrays.asList(
                        R.color.black,
                        Color.rgb(255,165,0),
                        Color.parseColor("#800080")
                        )
        );

        for(int i=0;i< ColorDescs.size();i++)
        {
            ColorSpec eachColor = new ColorSpec(ColorDescs.get(i),ColorVals.get(i));
            ColorSpecs.add(eachColor);
        }
        // having value to be given to View Model
        ColorSpecViewModel colorSpecViewModel = new ViewModelProvider(this).get(ColorSpecViewModel.class);
        colorSpecViewModel.loadColorList(ColorSpecs);
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
            Toast.makeText(this,"Clicked on settings",Toast.LENGTH_LONG);
            return true;
        }
        else if( id == R.id.action_profile)
        {
            Toast.makeText(this,"Clicked on userprofile",Toast.LENGTH_LONG);
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