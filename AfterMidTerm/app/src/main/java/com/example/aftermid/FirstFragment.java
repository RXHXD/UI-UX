package com.example.aftermid;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavHost;
import androidx.navigation.fragment.NavHostFragment;

import com.example.aftermid.databinding.FragmentFirstBinding;

import java.util.ArrayList;
import java.util.List;

public class FirstFragment extends Fragment {
    List<ColorSpec> FragColors = new ArrayList<>();
    ColorSpecViewModel colorSpecViewModel;
    ColorSpecAdapter colorSpecAdapter;

    private FragmentFirstBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        colorSpecViewModel =  new ViewModelProvider(requireActivity()).get(ColorSpecViewModel.class);
       colorSpecViewModel.getColorList().observe(getViewLifecycleOwner(), new Observer<List<ColorSpec>>() {
           @Override
           public void onChanged(List<ColorSpec> colorSpecs) {
               FragColors = colorSpecs;
               colorSpecAdapter = new ColorSpecAdapter(FragColors);
               binding.spinnerColors.setAdapter(colorSpecAdapter);
           }
       });

       binding.spinnerColors.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
           @Override
           public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
               Toast.makeText(requireActivity(),FragColors.get(i).getColorDesc(),Toast.LENGTH_SHORT);
           }

           @Override
           public void onNothingSelected(AdapterView<?> adapterView) {

           }
       });



        binding.buttonFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             Bundle bundle = new Bundle();
             bundle.putInt("COLORVAL",FragColors.get(binding.spinnerColors.getSelectedItemPosition()).getColorVal());
             NavHostFragment.findNavController(FirstFragment.this).navigate(R.id.action_FirstFragment_to_SecondFragment,bundle);



            }
        });

        binding.buttonFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}