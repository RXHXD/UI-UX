package com.example.midtermuiux.adapter;


import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.midtermuiux.R;
import com.example.midtermuiux.databinding.LayoutBinding;
import com.example.midtermuiux.model.Tune;

import java.util.List;

public class TuneAdapter extends RecyclerView.Adapter<TuneAdapter.TuneViewHolder> {

  List<Tune> adapterTuneList;
  int selectedIndex = -1;

    public TuneAdapter(List<Tune> adapterTuneList) {
        this.adapterTuneList = adapterTuneList;
        this.selectedIndex = -1;
    }


    @NonNull
    @Override
    public TuneViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        LayoutBinding binding = LayoutBinding.inflate(inflater,parent,false);
        View view = binding.getRoot();
        TuneViewHolder holder =  new TuneViewHolder(view,binding);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull TuneViewHolder holder, int position) {
      //   holder.holderbinding.getRoot().setBackgroundColor(Color.parseColor("FAFAFA"));
         holder.holderbinding.tunename.setText(adapterTuneList.get(position).getTuneName());
         holder.holderbinding.Tunepic.setImageResource(adapterTuneList.get(position).getTunePic());
         if(selectedIndex == position)
         {
             holder.holderbinding.tuneplayorpause.setImageResource(R.drawable.pause);
         }
         else{
             holder.holderbinding.tuneplayorpause.setImageResource(R.drawable.play);
         }
    }

    @Override
    public int getItemCount() {
        System.out.println("List size :"+adapterTuneList.size());
        return adapterTuneList.size();
    }

    public List<Tune> getAdapterTuneList() {
        return adapterTuneList;
    }

    public void setAdapterTuneList(List<Tune> adapterTuneList) {
        this.adapterTuneList = adapterTuneList;
        notifyDataSetChanged();
    }

    public int getSelectedIndex() {
        return selectedIndex;
    }

    public void setSelectedIndex(int selectedIndex) {
        this.selectedIndex = selectedIndex;
        notifyDataSetChanged();
    }

    public class TuneViewHolder extends RecyclerView.ViewHolder {
         LayoutBinding holderbinding;

        public TuneViewHolder(@NonNull View itemView,LayoutBinding holderBinding) {
            super(itemView);
            this.holderbinding = holderBinding;
        }
    }

}
