package com.example.finalpractice;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import com.example.finalpractice.databinding.FragmentFirstBinding;

import java.util.ArrayList;
import java.util.List;

public class FirstFragment extends Fragment {

    List<Phone> phoneList = new ArrayList<>();
    PhoneViewModel phoneViewModel;
    PhoneAdapter phoneAdapter;


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
        phoneViewModel = new ViewModelProvider(requireActivity()).get(PhoneViewModel.class);
        phoneViewModel.getPhoneList().observe(getViewLifecycleOwner(), new Observer<List<Phone>>() {
            @Override
            public void onChanged(List<Phone> phones) {
                phoneList = phones;
                phoneAdapter = new PhoneAdapter(phoneList);
                binding.spinner.setAdapter(phoneAdapter);
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