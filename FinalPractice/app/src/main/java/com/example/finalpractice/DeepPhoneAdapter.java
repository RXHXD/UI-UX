package com.example.finalpractice;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.finalpractice.databinding.LayoutPhoneitemBinding;

import java.util.List;

public class DeepPhoneAdapter extends BaseAdapter {

    List<DeepPhone> deepPhoneList;
    LayoutPhoneitemBinding phoneitemBinding;

    public DeepPhoneAdapter(List<DeepPhone> deepPhoneList) {
        this.deepPhoneList = deepPhoneList;
    }

    @Override
    public int getCount() {
        return deepPhoneList.size();
    }

    @Override
    public Object getItem(int i) {
        return deepPhoneList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
       if(view == null)
           {
               phoneitemBinding = LayoutPhoneitemBinding.inflate(LayoutInflater.from(viewGroup.getContext()),viewGroup,false);
           }
        phoneitemBinding.modelName.setText(deepPhoneList.get(i).getCompanyName());
       phoneitemBinding.price.setText(deepPhoneList.get(i).phoneTotalPrice);
       phoneitemBinding.imageView.setImageResource(deepPhoneList.get(i).getPhonePicDrawable());
        return phoneitemBinding.getRoot();
    }
}
