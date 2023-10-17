package com.example.midtermuiux.adapter;


import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
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
         holder.holderbinding.getRoot().setBackgroundColor(Color.parseColor("#FAFAFA"));
         holder.holderbinding.tunename.setText(adapterTuneList.get(position).getTuneName());
         holder.holderbinding.Tunepic.setImageResource(adapterTuneList.get(position).getTunePic());
         if(selectedIndex == position)
         {
             holder.holderbinding.tuneplayorpause.setImageResource(R.drawable.pause);
             System.out.println("pause");
         }
         else{
             holder.holderbinding.tuneplayorpause.setImageResource(R.drawable.play);
             System.out.println("play");
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
            this.holderbinding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(((ColorDrawable)TuneViewHolder.this.holderbinding.getRoot().getBackground()).getColor() != Color.LTGRAY)
                    {
                        TuneViewHolder.this.holderbinding.getRoot().setBackgroundColor(Color.LTGRAY);
                    }
                    else{
                        TuneViewHolder.this.holderbinding.getRoot().setBackgroundColor(Color.parseColor("#FAFAFA"));
                    }
                }
            });

            this.holderbinding.tuneplayorpause.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(TuneViewHolder.this.getAdapterPosition() == selectedIndex)
                    {
                        setSelectedIndex(-1);
                    }
                    else {
                        setSelectedIndex(TuneViewHolder.this.getAdapterPosition());
                    }
                }
            });

        }

        public TuneViewHolder(@NonNull View itemView)
        {
            super(itemView);
        }
    }

}
