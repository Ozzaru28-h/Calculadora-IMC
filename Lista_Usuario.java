package com.example.aplicacionpoonombreestudiante;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class Lista_Usuario extends AppCompatActivity {
    private ListView lvResultados;
    @Override
    protected void onCreate(Bundle savedInstanceState) { super.onCreate(savedInstanceState); setContentView(R.layout.activity_lista_usuario);
        lvResultados = findViewById(R.id.lv_resultados);
        ArrayList<String> datosResumen = new ArrayList<>(); for (PersonaIMC persona : MainActivity.listaPersonas) {
            datosResumen.add(persona.getResumen());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, datosResumen);
        lvResultados.setAdapter(adapter); }
}