package com.example.pizzeria;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

public class IngredientesFragment extends Fragment {
    TableLayout tableLayout;
    ArrayList<String> listaIngredientes;

    int numeroIngredientes;
    String tamaño;

    public IngredientesFragment(int numeroIngredientes, String tamaño) {
        this.numeroIngredientes = numeroIngredientes;
        this.tamaño = tamaño;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_ingredientes, container, false);
        listaIngredientes = new ArrayList<>();
        ArrayList<CheckBox> listaCheckBox = new ArrayList<>();
        tableLayout = view.findViewById(R.id.table);


        for (int i = 0; i < tableLayout.getChildCount(); i++) {
            TableRow row = (TableRow) tableLayout.getChildAt(i);
            for (int j = 0; j < row.getChildCount(); j++) {
                if (row.getChildAt(j) instanceof CheckBox){
                    CheckBox checkboxAnadir = (CheckBox) row.getChildAt(j);
                    listaCheckBox.add(checkboxAnadir);
                }
            }
        }

        for (CheckBox checkboxUsado: listaCheckBox) {
            checkboxUsado.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    desactivarBotones(view);
                }
            });
        }

        Button button8 = view.findViewById(R.id.button8);

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                realizarPedido();
            }
        });

        return view;
    }

    public void desactivarBotones(View view) {
        int numRows = tableLayout.getChildCount();
        listaIngredientes.clear();
        for (int i = 0; i < numRows; i++) {
            TableRow row = (TableRow) tableLayout.getChildAt(i);

            // Iterar a través de cada celda en la fila
            int numCells = row.getChildCount();
            for (int j = 0; j < numCells; j++) {
                View cell = row.getChildAt(j);

                if (cell instanceof CheckBox) {
                    CheckBox checkbox = (CheckBox) cell;
                    if (listaIngredientes.size() == numeroIngredientes) {
                        comprobarBotones();
                    }

                    else{
                        checkbox.setEnabled(true);
                        if (checkbox.isChecked()){
                            listaIngredientes.add(checkbox.getText().toString());
                        }
                    }

                }
            }
        }

    }

    public TipoIngrediente convertirIngrediente(String ingrediente){
        TipoIngrediente ingredienteFinal = null;
        switch (ingrediente){
            case "Ternera":{
                ingredienteFinal = TipoIngrediente.TERNERA;
                break;
            }
            case "Jamón York": {
                ingredienteFinal = TipoIngrediente.JAMON_YORK;
                break;
            }
            case "Atún": {
                ingredienteFinal = TipoIngrediente.ATUN;
                break;
            }
            case "Pollo": {
                ingredienteFinal = TipoIngrediente.POLLO;
                break;
            }
            case "Barbacoa": {
                ingredienteFinal = TipoIngrediente.SALSA_BARBACOA;
                break;
            }
            case "Huevo": {
                ingredienteFinal = TipoIngrediente.HUEVO_BATIDO;
                break;
            }
            case "Aceitunas": {
                ingredienteFinal = TipoIngrediente.ACEITUNAS;
                break;
            }
            case "Queso": {
                ingredienteFinal = TipoIngrediente.QUESO_RULO_DE_CABRA;
                break;
            }
            case "Cheddar": {
                ingredienteFinal = TipoIngrediente.SALSA_CHEDDAR;
                break;
            }
            case "Jamón": {
                ingredienteFinal = TipoIngrediente.JAMON;
                break;
            }
            case "Trufa": {
                ingredienteFinal = TipoIngrediente.TRUFA;
                break;
            }
            case "Chorizo": {
                ingredienteFinal = TipoIngrediente.CHORIZO;
                break;
            }
            case "Gaucha": {
                ingredienteFinal = TipoIngrediente.SALSA_GAUCHA;
                break;
            }
            case "Gambas": {
                ingredienteFinal = TipoIngrediente.GAMBAS;
                break;
            }
            case "Calabaza": {
                ingredienteFinal = TipoIngrediente.CALABAZA;
                break;
            }
            case "Peperonni": {
                ingredienteFinal = TipoIngrediente.PEPERONNI;
                break;
            }
            case "Nata": {
                ingredienteFinal = TipoIngrediente.NATA;
                break;
            }
            case "Beicon": {
                ingredienteFinal = TipoIngrediente.BEICON;
                break;
            }
            case "Patatas": {
                ingredienteFinal = TipoIngrediente.PATATAS_FRITAS;
                break;
            }
            case "Maiz": {
                ingredienteFinal = TipoIngrediente.MAIZ;
                break;
            }
        }

        return ingredienteFinal;

    }

    public void realizarPedido(){
        ArrayList<TipoIngrediente> listaIngredientesEnum = new ArrayList<>();
        TipoTamano tamañoEnum = null;
        double precio = 10;
        if (tamaño == "Pequeña"){
            tamañoEnum = TipoTamano.PEQUEÑA;
            precio += 2;
        }
        else if(tamaño == "Mediana" ){
            tamañoEnum = TipoTamano.MEDIANA;
            precio += 3;
        }
        else{
            tamañoEnum = TipoTamano.FAMILIAR;
            precio += 5;
        }
        for (int i = 0; i < numeroIngredientes; i++) {
            precio += 1;
        }


        for (int i = 0; i < listaIngredientes.size(); i++) {
            listaIngredientesEnum.add(convertirIngrediente(listaIngredientes.get(i)));
        }

        TipoIngrediente[] miArray = new TipoIngrediente[listaIngredientesEnum.size()];
        miArray = listaIngredientesEnum.toArray(miArray);

        Pizza pizza = new Pizza("Tu Pizza", numeroIngredientes, miArray, tamañoEnum, precio);

        Intent intent = new Intent(this.getActivity(), DetellePizza.class);
        intent.putExtra("pizza",pizza);
        startActivity(intent);

    }

    public void comprobarBotones() {
        int numRows = tableLayout.getChildCount();
        for (int i = 0; i < numRows; i++) {
            TableRow row = (TableRow) tableLayout.getChildAt(i);
            for (int j = 0; j < row.getChildCount(); j++) {
                View cell = row.getChildAt(j);
                if (cell instanceof CheckBox){
                    CheckBox checkBox = (CheckBox) cell;
                    if (checkBox.isChecked() == false){
                        checkBox.setEnabled(false);
                    }
                }
            }
        }
    }

}

