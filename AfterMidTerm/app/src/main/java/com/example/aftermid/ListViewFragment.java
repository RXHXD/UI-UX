package com.example.aftermid;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.example.aftermid.databinding.FragmentListViewBinding;

import java.util.List;


public class ListViewFragment extends Fragment {
    FragmentListViewBinding binding;
    List<ColorSpec> FragColors;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        //  return inflater.inflate(R.layout.fragment_list_view, container, false);
    binding = FragmentListViewBinding.inflate(inflater,container,false);
    return binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ColorSpecViewModel colorSpecViewModel = new ViewModelProvider(
                requireActivity()).get(ColorSpecViewModel.class);
        colorSpecViewModel.getColorList().observe(getViewLifecycleOwner(), new Observer<List<ColorSpec>>() {
            @Override
            public void onChanged(List<ColorSpec> colorSpecList) {
                FragColors = colorSpecList;
                binding.listViewColors.setAdapter(new ColorSpecAdapter(FragColors));
            }
        });

        binding.listViewColors.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Bundle bundle = new Bundle();
                bundle.putInt("COLORVAL",FragColors.get(i).getColorVal());
                NavHostFragment.findNavController(ListViewFragment.this).navigate(R.id.action_listViewFragment_to_SecondFragment,bundle);

            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}