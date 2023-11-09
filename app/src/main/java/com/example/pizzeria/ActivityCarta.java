package com.example.pizzeria;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ViewSwitcher;

public class ActivityCarta extends AppCompatActivity implements PizzaAdapter.OnPizzaItemClickListener{

    private RecyclerView recyclerView;
    private PizzaAdapter pizzaAdapter;
    private Servicio servicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carta);

        Button button6 = findViewById(R.id.button6);

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.contenedor, new RecyclerFragment()).commit();
            }
        });

    }

    @Override
    public void onPizzaItemClick(Pizza pizza) {
        Intent intent = new Intent(this, DetellePizza.class);
        intent.putExtra("pizza", pizza);
        startActivity(intent);

    }

    public void mostrarRecyclerView(View view){
        recyclerView = findViewById(R.id.recyclerView);
        servicio = new Servicio();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        pizzaAdapter = new PizzaAdapter(servicio.getListaPizzasFabricadas(),this);
        recyclerView.setAdapter(pizzaAdapter);
    }


}