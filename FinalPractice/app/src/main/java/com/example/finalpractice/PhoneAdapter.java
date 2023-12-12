package com.example.finalpractice;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.finalpractice.databinding.LayoutColoritemBinding;

import java.util.List;

public class PhoneAdapter extends BaseAdapter {

    List<Phone> phoneList;
    LayoutColoritemBinding coloritemBinding;

    public PhoneAdapter(List<Phone> phoneList) {
        this.phoneList = phoneList;
    }

    @Override
    public int getCount() {
        return phoneList.size();
    }

    @Override
    public Object getItem(int i) {
        return phoneList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null)
        {
            coloritemBinding = LayoutColoritemBinding.inflate(LayoutInflater.from(viewGroup.getContext()),viewGroup,false);
        }
     coloritemBinding.txtViewColourItem.setText(phoneList.get(i).getPhoneName());
     coloritemBinding.txtViewColourItem.setTextColor(phoneList.get(i).getPhoneColor());
     return coloritemBinding.getRoot();
    }
}
