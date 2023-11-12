package com.example.pizzeria;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;


public class PersonalizarFragment extends Fragment {
    int itemBarra = 0;
    String itemSpinner = "";
    public PersonalizarFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_personalizar, container, false);
        String[] opciones = {"Pequeña", "Mediana", "Familiar"};
        Spinner spinner = view.findViewById(R.id.spinner);
        SeekBar barra = view.findViewById(R.id.seekBar);
        TextView textoBarra = view.findViewById(R.id.textView7);
        Button button = view.findViewById(R.id.button3);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this.getContext(), com.google.android.material.R.layout.support_simple_spinner_dropdown_item, opciones);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);

        barra.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                itemBarra = progress;
                textoBarra.setText(itemBarra + "");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                itemSpinner = (String) parent.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                itemSpinner = "";
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IngredientesFragment miFragmento = new IngredientesFragment(itemBarra,itemSpinner);

                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.contenedorIngredientes,miFragmento).commit();
            }
        });

                return view;
    }


}