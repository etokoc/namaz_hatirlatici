package com.ertugrul.myjava.data.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ertugrul.myjava.data.model.EzanItem;
import com.ertugrul.myjava.databinding.RecylerviewRowItemBinding;

import java.util.ArrayList;

public class EzanTimeRecylerView extends RecyclerView.Adapter<EzanTimeRecylerView.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder {
        RecylerviewRowItemBinding _binding;

        public ViewHolder(@NonNull RecylerviewRowItemBinding binding) {
            super(binding.getRoot());
            _binding = binding;
        }
    }

    ArrayList<EzanItem> _ezanList;

    public void setList(ArrayList<EzanItem> ezanList) {
        _ezanList = ezanList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecylerviewRowItemBinding binding = RecylerviewRowItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder._binding.txtEzanName.setText(_ezanList.get(position).getEzanName());
        holder._binding.txtStartTime.setText(_ezanList.get(position).getEzanStartTime());
        holder._binding.txtEndTime.setText(_ezanList.get(position).getEzanEndTime());
    }

    @Override
    public int getItemCount() {
        return _ezanList.size();
    }
}
