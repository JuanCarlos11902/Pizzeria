package com.example.pizzeria;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PizzaAdapter extends RecyclerView.Adapter<PizzaAdapter.PizzaViewHolder> {

    private ArrayList<Pizza> pizzaList;

    public PizzaAdapter(ArrayList<Pizza> pizzaList){
        this.pizzaList = pizzaList;
    }

    @NonNull
    @Override
    public PizzaAdapter.PizzaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_pizza, parent, false);
        return new PizzaAdapter.PizzaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PizzaAdapter.PizzaViewHolder holder, int position) {
        Pizza pizza = pizzaList.get(position);
        holder.bind(pizza);
    }

    @Override
    public int getItemCount() {
       return pizzaList.size();
    }

    public class PizzaViewHolder extends RecyclerView.ViewHolder {

        private TextView txtNombre;
        private TextView txtNumeroIngredientes;
        private TextView txtIngredientes;
        private TextView txtTamaño;
        private TextView txtPrecio;


        public PizzaViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNombre = itemView.findViewById(R.id.txtNombre);
            txtNumeroIngredientes = itemView.findViewById(R.id.txtNumero);
            txtIngredientes = itemView.findViewById(R.id.txtIngredientes);
            txtTamaño = itemView.findViewById(R.id.txtTamaño);
            txtPrecio = itemView.findViewById(R.id.txtPrecio);
        }

        public void bind(Pizza pizza) {
            txtNombre.setText(pizza.getNombre());
            txtNumeroIngredientes.setText(pizza.getNumeroIngredientes());
            txtIngredientes.setText(convertirArray(pizza));
        }

        public String convertirArray(Pizza pizza) {
            String cadena = "";

            for (int i = 0; i < pizza.getIngredientes().length; i++) {
                cadena += pizza.getIngredientes()[i].toString();
            }

            return cadena;
        }

    }
}



