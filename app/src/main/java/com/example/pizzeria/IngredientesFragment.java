package com.example.pizzeria;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

        tableLayout = view.findViewById(R.id.table);

        return view;
    }

    public void checkboxClickado(View view){
        desactivarBotones();
    }

    public void desactivarBotones(){
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
                    if (listaIngredientes.size() == numeroIngredientes && !checkbox.isChecked()){
                        checkbox.setEnabled(false);
                    }
                    else{
                        listaIngredientes.add((String) checkbox.getText());
                    }

                }
            }
        }
    }

    public TipoIngrediente convertirIngrediente(String ingrediente){
        TipoIngrediente ingredienteFinal = null;
        switch (ingrediente){
            case "Ternera": ingredienteFinal = TipoIngrediente.TERNERA;
            case "Jamón York": ingredienteFinal = TipoIngrediente.JAMON_YORK;
            case "Atún": ingredienteFinal = TipoIngrediente.ATUN;
            case "Pollo": ingredienteFinal = TipoIngrediente.POLLO;
            case "Barbacoa": ingredienteFinal = TipoIngrediente.SALSA_BARBACOA;
            case "Huevo": ingredienteFinal = TipoIngrediente.HUEVO_BATIDO;
            case "Aceitunas": ingredienteFinal = TipoIngrediente.ACEITUNAS;
            case "Queso": ingredienteFinal = TipoIngrediente.QUESO_RULO_DE_CABRA;
            case "Cheddar": ingredienteFinal = TipoIngrediente.SALSA_CHEDDAR;
            case "Jamón": ingredienteFinal = TipoIngrediente.JAMON;
            case "Trufa": ingredienteFinal = TipoIngrediente.TRUFA;
            case "Chorizo": ingredienteFinal = TipoIngrediente.CHORIZO;
            case "Gaucha": ingredienteFinal = TipoIngrediente.SALSA_GAUCHA;
            case "Gambas": ingredienteFinal = TipoIngrediente.GAMBAS;
            case "Calabaza": ingredienteFinal = TipoIngrediente.CALABAZA;
            case "Peperonni": ingredienteFinal = TipoIngrediente.PEPERONNI;
            case "Nata": ingredienteFinal = TipoIngrediente.NATA;
            case "Beicon": ingredienteFinal = TipoIngrediente.BEICON;
            case "Patatas": ingredienteFinal = TipoIngrediente.PATATAS_FRITAS;
            case "Maiz": ingredienteFinal = TipoIngrediente.MAIZ;
        }

        return ingredienteFinal;

    }

    public void realizarPedido(View view){
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

        Pizza pizza = new Pizza("Tu Pizza", numeroIngredientes, (TipoIngrediente[]) listaIngredientesEnum.toArray(), tamañoEnum, precio);

        Intent intent = new Intent(this.getActivity(), DetellePizza.class);
        intent.putExtra("pizza",pizza);

    }



}

