package adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewdemo.databinding.LayoutTuneitemBinding;

import java.util.List;

import model.Tune;

public class TuneAdapter extends RecyclerView.Adapter<TuneAdapter.TuneViewHolder> {

    List<Tune> adapterTuneList;
    int selectedIndex = -1;

    public List<Tune> getAdapterTuneList() {
        return adapterTuneList;
    }

    public void setAdapterTuneList(List<Tune> adapterTuneList) {
        this.adapterTuneList = adapterTuneList;
    }

    public int getSelectedIndex() {
        return selectedIndex;
    }

    public void setSelectedIndex(int selectedIndex) {
        this.selectedIndex = selectedIndex;
    }

    public TuneAdapter(List<Tune> adapterTuneList) {
        this.adapterTuneList = adapterTuneList;
        this.selectedIndex = -1;
    }

    @NonNull
    @Override
    public TuneViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        LayoutTuneitemBinding binding = LayoutTuneitemBinding.inflate(inflater,parent,false);
        View view = binding.getRoot();
        TuneViewHolder holder = new TuneViewHolder(view,binding);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull TuneViewHolder holder, int position) {
        // populate data in the holder object
        // given positionth data
        holder.holderBinding.txtView2Tune
                .setText(adapterTuneList.get(position).getTuneName());
        holder.holderBinding
                .imgView2Tune.setImageResource(adapterTuneList.get(position).getTunePic());


    }

    @Override
    public int getItemCount() {
        return adapterTuneList.size();
    }

    public class TuneViewHolder extends RecyclerView.ViewHolder{
         LayoutTuneitemBinding holderBinding;

        public TuneViewHolder(@NonNull View itemView, LayoutTuneitemBinding holderBinding) {
            super(itemView);
            this.holderBinding = holderBinding;
        }

        public TuneViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
