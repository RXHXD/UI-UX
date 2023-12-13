package com.example.finalpractice;

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
import androidx.navigation.fragment.NavHostFragment;

import com.example.finalpractice.databinding.FragmentFirstBinding;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FirstFragment extends Fragment {

    List<Phone> phoneList = new ArrayList<>();
    PhoneViewModel phoneViewModel;
    PhoneAdapter phoneAdapter;

    List<DeepPhone> phoneList1 = new ArrayList<>();
    PhoneViewModel phoneViewModel1;
    DeepPhoneAdapter phoneAdapter1;
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
//        phoneViewModel.getPhoneList().observe(getViewLifecycleOwner(), new Observer<List<Phone>>() {
//            @Override
//            public void onChanged(List<Phone> phones) {
//                phoneList = phones;
//                phoneAdapter = new PhoneAdapter(phoneList);
//                binding.spinner.setAdapter(phoneAdapter);
//            }
//        });

        phoneViewModel.getPhoneList1().observe(requireActivity(), new Observer<List<DeepPhone>>() {
            @Override
            public void onChanged(List<DeepPhone> deepPhones) {
                phoneList1 = deepPhones;
                phoneAdapter1 = new DeepPhoneAdapter(phoneList1);
                binding.spinner.setAdapter(phoneAdapter1);
            }
        });


//      binding.spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//          @Override
//          public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//              Toast.makeText(requireActivity(),phoneList.get(i).getPhoneName(),Toast.LENGTH_SHORT).show();
//          }
//
//          @Override
//          public void onNothingSelected(AdapterView<?> adapterView) {
//
//          }
//      });

        binding.buttonFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // send information from one fragment to another
                Bundle bundle = new Bundle();
               bundle.putString("companyName",phoneList1.get(binding.spinner.getSelectedItemPosition()).getCompanyName());
                bundle.putString("monthlyRate",phoneList1.get(binding.spinner.getSelectedItemPosition()).getMonthlyRate());
                bundle.putString("phoneCameraSpec",phoneList1.get(binding.spinner.getSelectedItemPosition()).getPhoneCameraSpec());
                bundle.putString("phoneTotalPrice",phoneList1.get(binding.spinner.getSelectedItemPosition()).getPhoneTotalPrice());



                // bundle.putInt("phoneColor",phoneList.get(binding.spinner.getSelectedItemPosition()).getPhoneColor());
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment,bundle);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}