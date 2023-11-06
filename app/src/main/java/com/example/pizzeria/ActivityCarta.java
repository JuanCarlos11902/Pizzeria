package com.example.pizzeria;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;

public class ActivityCarta extends AppCompatActivity implements PizzaAdapter.OnPizzaItemClickListener{

    private RecyclerView recyclerView;
    private PizzaAdapter pizzaAdapter;
    private Servicio servicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carta);

        recyclerView = findViewById(R.id.recyclerView);
        servicio = new Servicio();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        pizzaAdapter = new PizzaAdapter(servicio.getListaPizzasFabricadas(),this);
        recyclerView.setAdapter(pizzaAdapter);
    }

    @Override
    public void onPizzaItemClick(Pizza pizza) {
        Intent intent = new Intent(this, DetellePizza.class);
        intent.putExtra("pizza", pizza);
        startActivity(intent);

    }
}