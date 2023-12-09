package com.example.datedemo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.datedemo.databinding.LayoutDogitemBinding;

import java.util.List;

public class DogAdapter extends RecyclerView.Adapter<DogAdapter.DogViewHolder> {
    List<Dog> AdapterDogList;


    public DogAdapter(List<Dog> adapterDogList) {

        AdapterDogList = adapterDogList;
    }

    @NonNull
    @Override
    public DogViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //return null;
        //Inflate the binding
        //using binding create holder object
        //return holder object

        LayoutDogitemBinding binding = LayoutDogitemBinding
                                        .inflate(LayoutInflater
                                                .from(parent.getContext()),
                                                parent, false);
        DogViewHolder holder = new DogViewHolder(binding.getRoot(), binding);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull DogViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {

        return AdapterDogList.size();
    }

    public class DogViewHolder extends RecyclerView.ViewHolder {
        LayoutDogitemBinding binding;

        public DogViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        public DogViewHolder(@NonNull View itemView, LayoutDogitemBinding binding) {
            super(itemView);
            this.binding = binding;
        }
    }
}
