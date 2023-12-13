package com.example.finalpractice;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.finalpractice.databinding.FragmentSecondBinding;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
       if(getArguments() != null)
       {
           int phoneColor = getArguments().getInt("phoneColor",Color.BLUE);
           binding.textviewSecond.setTextColor(phoneColor);
       }



        binding.buttonSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });

       binding.btnThird.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               NavHostFragment.findNavController(SecondFragment.this).navigate(R.id.action_SecondFragment_to_listviewfragment);
           }
       });


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}