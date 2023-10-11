package com.example.recyclerviewdemo.adapters;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewdemo.R;
import com.example.recyclerviewdemo.databinding.LayoutTuneitemBinding;
import com.example.recyclerviewdemo.model.Tune;

import java.util.List;

public class TuneAdapter extends RecyclerView.Adapter<TuneAdapter.TuneViewHolder> {
    //Adapter Data
    List<Tune> adapterTuneList;
    int SelectedInd = -1;

    //Constructor to set up the data

    public TuneAdapter(List<Tune> adapterTuneList) {
        this.adapterTuneList = adapterTuneList;
        this.SelectedInd = -1;
    }

    public List<Tune> getAdapterTuneList() {
        return adapterTuneList;
    }

    public void setAdapterTuneList(List<Tune> adapterTuneList) {
        this.adapterTuneList = adapterTuneList;
        notifyDataSetChanged();
    }

    public int getSelectedInd() {
        return SelectedInd;
    }

    public void setSelectedInd(int selectedInd) {

        SelectedInd = selectedInd;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TuneViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflating external layout
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        LayoutTuneitemBinding binding =
                LayoutTuneitemBinding.inflate(inflater,parent,false);
        View view = binding.getRoot();


        //creation of tune view holder object
        TuneViewHolder holder = new TuneViewHolder(view,binding);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull TuneViewHolder holder, int position) {
        //populate the data in the holder object
        //given position th data
        holder.holderBinding.getRoot().setBackgroundColor(Color.parseColor("#FAFAFA"));
        holder.holderBinding.txtView2Tune
                .setText(adapterTuneList.get(position).getTuneName());
        holder.holderBinding.imgView2Tune
                .setImageResource(adapterTuneList.get(position).getTunePic());

       if(SelectedInd == position)
       {
           holder.holderBinding.imgViewPlayPause.setImageResource(R.drawable.pause);
       }
      else{
          holder.holderBinding.imgViewPlayPause.setImageResource(R.drawable.play);
       }

    }

    @Override
    public int getItemCount() {
        return adapterTuneList.size();
    }

    public class TuneViewHolder extends RecyclerView.ViewHolder {
        LayoutTuneitemBinding holderBinding;

        public TuneViewHolder(@NonNull View itemView,
                              LayoutTuneitemBinding holderBinding) {
            super(itemView);
            this.holderBinding = holderBinding;
            this.holderBinding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if( ((ColorDrawable)TuneViewHolder.this.holderBinding.getRoot().getBackground()).getColor() != Color.LTGRAY ){
                        TuneViewHolder.this.holderBinding.getRoot().setBackgroundColor(Color.LTGRAY);

                    }
                    else{
                        TuneViewHolder.this.holderBinding.getRoot().setBackgroundColor(Color.parseColor("FAFAFA"));
                    }

                }
            });
            this.holderBinding.imgViewPlayPause.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(TuneViewHolder.this.getAdapterPosition() == SelectedInd){
                        setSelectedInd(-1);
                    }
                    else{
                        setSelectedInd(TuneViewHolder.this.getAdapterPosition());
                    }
                }
            });

        }

        public TuneViewHolder(@NonNull View itemView) {

            super(itemView);
        }
    }
}
