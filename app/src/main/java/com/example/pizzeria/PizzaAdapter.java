package com.example.pizzeria;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PizzaAdapter extends RecyclerView.Adapter<PizzaAdapter.ViewHolder> {
    @NonNull
    @Override
    public PizzaAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull PizzaAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}

public class ViewHolder extends RecyclerView.ViewHolder{

    TextView 
    public ViewHolder(@NonNull View itemView) {
        super(itemView);
    }
}
