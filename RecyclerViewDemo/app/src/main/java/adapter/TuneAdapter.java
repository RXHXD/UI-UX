package adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewdemo.databinding.LayoutTuneitemBinding;

import java.util.List;

import model.Tune;

public class TuneAdapter extends RecyclerView.Adapter<TuneAdapter.TuneViewHolder> {

   // Adapter Data
    List<Tune>  adaTuneList;
    int SelectedInd = -1;

    public List<Tune> getAdaTuneList() {
        return adaTuneList;
    }

    public void setAdaTuneList(List<Tune> adaTuneList) {
        this.adaTuneList = adaTuneList;
    }

    public int getSelectedInd() {
        return SelectedInd;
    }

    public void setSelectedInd(int selectedInd) {
        SelectedInd = selectedInd;
    }

    // Constructor to set up the data
    public TuneAdapter(List<Tune> adaTuneList) {
        this.adaTuneList = adaTuneList;
    }


    @NonNull
    @Override
    public TuneViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // inflating external layout
        // creation of tune view holder object
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        LayoutTuneitemBinding binding = LayoutTuneitemBinding.inflate(inflater,parent,false);

       View view = binding.getRoot();

       TuneViewHolder holder = new TuneViewHolder(view,binding);



        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull TuneViewHolder holder, int position) {
      // populate the data in the holder object

        holder.holderBinding.txtView2Tune.setText(adaTuneList.get(position).getTuneName());
        holder.holderBinding.imgView2Tune.setImageResource(adaTuneList.get(position).getTunePic());
    }

    @Override
    public int getItemCount() {
        return adaTuneList.size();
    }

    public class TuneViewHolder extends RecyclerView.ViewHolder {
        LayoutTuneitemBinding holderBinding;


        public TuneViewHolder(@NonNull View itemView)
        {
            super(itemView);
            this.holderBinding = holderBinding;
        }

        public TuneViewHolder(@NonNull View itemView, LayoutTuneitemBinding holderBinding) {
            super(itemView);
            this.holderBinding = holderBinding;
        }
    }
}


