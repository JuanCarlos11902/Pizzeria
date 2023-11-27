package com.example.pizzeria;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ViewSwitcher;

import java.util.ArrayList;

public class ActivityCarta extends AppCompatActivity{

    private RecyclerView recyclerView;
    private PizzaAdapter pizzaAdapter;
    private SQLiteHelper helper = new SQLiteHelper(this.getApplicationContext(),"Pizzeria",null,1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carta);

        Button button6 = findViewById(R.id.button6);

        button6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (getSupportFragmentManager().findFragmentById(R.id.contenedor) != null){
                    getSupportFragmentManager().beginTransaction().remove(getSupportFragmentManager().findFragmentById(R.id.contenedor)).commit();
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.contenedor,new PersonalizarFragment()).commit();
            }
        });

    }

    public void mostrarRecyclerView(View view) {

            if (getSupportFragmentManager().findFragmentById(R.id.contenedor) != null) {
                getSupportFragmentManager().beginTransaction().remove(getSupportFragmentManager().findFragmentById(R.id.contenedor)).commit();
            }

            RecyclerFragment fragment = new RecyclerFragment(Servicio.getInstance(helper).getListaPizzasFabricadas());

            getSupportFragmentManager().beginTransaction().replace(R.id.contenedor, fragment).commit();

    }

    public void mostrarPizzasFavoritas(View view){

        ArrayList<Pizza> listaPizzasReciclar = new ArrayList<>();
        SharedPreferences preferences = getSharedPreferences("MisPreferencias", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        int idUsuario = preferences.getInt("idUsuario", 0);

        for (int i = 0; i < Servicio.getInstance(helper).getListaUsuarios().size(); i++) {
            if (idUsuario == Servicio.getInstance(helper).getListaUsuarios().get(i).getId()) {
                listaPizzasReciclar = Servicio.getInstance(helper).getListaUsuarios().get(i).getListaPizzasFavoritas();
            }
        }

        if (getSupportFragmentManager().findFragmentById(R.id.contenedor) != null) {
            getSupportFragmentManager().beginTransaction().remove(getSupportFragmentManager().findFragmentById(R.id.contenedor)).commit();
        }


        getSupportFragmentManager().beginTransaction().replace(R.id.contenedor, new RecyclerFragment(listaPizzasReciclar)).commit();
    }

    public void volverAtras(View view){
        finish();
    }



}