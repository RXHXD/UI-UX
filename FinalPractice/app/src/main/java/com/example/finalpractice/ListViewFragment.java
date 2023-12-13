package com.example.finalpractice;

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

import com.example.finalpractice.databinding.FragmentListViewBinding;

import java.util.List;


public class ListViewFragment extends Fragment {

    FragmentListViewBinding binding;
    List<Phone> phoneInfo;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentListViewBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        PhoneViewModel phoneViewModel = new ViewModelProvider(requireActivity()).get(PhoneViewModel.class);
        phoneViewModel.getPhoneList().observe(getViewLifecycleOwner(), new Observer<List<Phone>>() {
            @Override
            public void onChanged(List<Phone> phones) {
                phoneInfo = phones;
                binding.listviewfragment.setAdapter(new PhoneAdapter(phoneInfo));
            }
        });

        binding.listviewfragment.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Bundle bundle = new Bundle();
                bundle.putInt("phoneColor",phoneInfo.get(i).getPhoneColor());

                // navigate with bundle info
                NavHostFragment.findNavController(ListViewFragment.this).navigate(R.id.action_listviewfragment_to_SecondFragment,bundle);
            }
        });



    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}