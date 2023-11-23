package com.example.pizzeria;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class DetellePizza extends AppCompatActivity {

    Pizza pizza;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detelle_pizza);

        Intent intent = getIntent();

        if (intent.hasExtra("pizza")){
            pizza = (Pizza) intent.getSerializableExtra("pizza");
        }

        TextView txtNombre = findViewById(R.id.editTextTextMultiLine);
        TextView txtNumeroIngredientes = findViewById(R.id.editTextTextMultiLine2);
        TextView txtIngredientes = findViewById(R.id.editTextTextMultiLine3);
        TextView txtTamaño = findViewById(R.id.editTextTextMultiLine4);
        Button btnPagar = findViewById(R.id.button2);

        txtNombre.setText(pizza.getNombre());
        txtNumeroIngredientes.setText(pizza.getNumeroIngredientes() + "");
        txtIngredientes.setText(Arrays.deepToString(pizza.getIngredientes()));
        txtTamaño.setText(pizza.getTamano().toString());
        btnPagar.setText("Pagar " + pizza.getPrecio() + "$");


    }

    public void ventanaConfirmacion(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        View viewInflada = LayoutInflater.from(this).inflate(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,null);
        builder.setView(viewInflada).setTitle("Ventana de Confirmación").
                setMessage("Estás seguro de que quieres confirmar el pedido?").
                setPositiveButton(
                        "Aceptar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(getApplicationContext(), "Su pedido llegará en aproximadamente 25 minutos.", Toast.LENGTH_SHORT).show();
                                finish();
                            }
                        }
                ).setNegativeButton(
                        "Cancelar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        }
                );

        AlertDialog dialog = builder.create();

        dialog.show();
    }

    public void agregarPizza(View view){
        SharedPreferences preferences = getSharedPreferences("MisPreferencias", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        int idUsuario = preferences.getInt("idUsuario",0);

        for (int i = 0; i < Servicio.getInstance().getListaUsuarios().size(); i++) {
            if (idUsuario == Servicio.getInstance().getListaUsuarios().get(i).getId()){
                Servicio.getInstance().getListaUsuarios().get(i).getListaPizzasFavoritas().add(pizza);
            }
        }
    }

    public void volverAtras(View view){
        finish();
    }

}