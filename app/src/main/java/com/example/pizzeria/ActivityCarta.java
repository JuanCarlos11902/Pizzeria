package com.example.pizzeria;

import androidx.appcompat.app.AppCompatActivity;
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
        ViewSwitcher viewSwitcher = (ViewSwitcher) findViewById(R.id.viewSwitcher);
        View myFirstView = findViewById(R.id.recyclerView);
        View mySecondView = findViewById(R.id.textViewCambiado);
        Button button1 = (Button) findViewById(R.id.button6);
        button1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (viewSwitcher.getCurrentView() != myFirstView) {
                    viewSwitcher.showPrevious();
                } else if (viewSwitcher.getCurrentView() != mySecondView) {
                    viewSwitcher.showNext();
                }
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