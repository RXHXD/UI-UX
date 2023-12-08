package com.example.aftermid;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.aftermid.databinding.LayoutColoritemBinding;

import java.util.List;

public class ColorSpecAdapter extends BaseAdapter {
    public ColorSpecAdapter(List<ColorSpec> colorList) {
        ColorList = colorList;
    }

    List<ColorSpec>  ColorList;
   LayoutColoritemBinding coloritemBinding;

    @Override
    public int getCount() {
        return ColorList.size();
    }

    @Override
    public Object getItem(int i) {
        return ColorList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null)
        {
            // very important step its viewgroup not view
           coloritemBinding = LayoutColoritemBinding.inflate(LayoutInflater.from(viewGroup.getContext()),viewGroup,false);
           coloritemBinding.textViewColorItem.setText(ColorList.get(i).getColorDesc());
           coloritemBinding.textViewColorItem.setTextColor(ColorList.get(i).getColorVal());

        }
        return coloritemBinding.getRoot();
    }
}
