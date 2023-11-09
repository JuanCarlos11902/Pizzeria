package com.example.pizzeria;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class RecyclerFragment extends Fragment implements PizzaAdapter.OnPizzaItemClickListener{

    public RecyclerFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_recycler, container, false);

        RecyclerView recyclerView;
        PizzaAdapter pizzaAdapter;
        Servicio servicio;

        recyclerView = view.findViewById(R.id.recyclerView);
        servicio = new Servicio();
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        pizzaAdapter = new PizzaAdapter(servicio.getListaPizzasFabricadas(), this);

        recyclerView.setAdapter(pizzaAdapter);

        return view;
    }

    @Override
    public void onPizzaItemClick(Pizza pizza) {
        Intent intent = new Intent(getActivity(), DetellePizza.class);
        intent.putExtra("pizza", pizza);
        startActivity(intent);
    }
}