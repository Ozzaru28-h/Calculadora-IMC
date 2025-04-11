    package com.example.aplicacionpoonombreestudiante;


    import android.content.Intent;
    import android.os.Bundle;
    import android.view.View;
    import android.widget.ArrayAdapter;
    import android.widget.Button;
    import android.widget.EditText;
    import android.widget.RadioButton;
    import android.widget.RadioGroup;
    import android.widget.Spinner;
    import android.widget.Toast;

    import androidx.appcompat.app.AppCompatActivity;

    import java.util.ArrayList;

    public class MainActivity extends AppCompatActivity {
        private EditText etNombre, etPeso, etAltura;
        private RadioGroup rgGenero;
        private Spinner spCiudad;
        private Button btnGuardar, btnVer;
        public static ArrayList<PersonaIMC> listaPersonas = new ArrayList<>();
        @Override
        protected void onCreate(Bundle savedInstanceState) { super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
    // Enlazamos los componentes del layout
            etNombre = findViewById(R.id.et_nombre);
            etPeso = findViewById(R.id.et_peso);
            etAltura = findViewById(R.id.et_altura);
            rgGenero = findViewById(R.id.rg_genero);
            spCiudad = findViewById(R.id.sp_ciudad);
            btnGuardar = findViewById(R.id.btn_guardar);
            btnVer = findViewById(R.id.btn_ver);
    // Llenamos el spinner desde código Java
            String[] ciudades = {"Bogotá", "Medellín", "Cali", "Popayán","Piendamó"}; ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                    android.R.layout.simple_spinner_item, ciudades);
            spCiudad.setAdapter(adapter);
    // Evento clic del botón Guardars
            btnGuardar.setOnClickListener(new View.OnClickListener() { @Override
            public void onClick(View v) {
                guardarDatos();
            }
            });
    // Evento clic del botón Ver
            btnVer.setOnClickListener(new View.OnClickListener() { @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Lista_Usuario.class); startActivity(intent);
            }
            });
        }
        // Método para capturar los datos y guardarlos
        private void guardarDatos() {
            String nombre = etNombre.getText().toString();
            double peso = Double.parseDouble(etPeso.getText().toString()); double altura = Double.parseDouble(etAltura.getText().toString());
            int generoId = rgGenero.getCheckedRadioButtonId();
            RadioButton rbSeleccionado = findViewById(generoId);
            String genero = rbSeleccionado.getText().toString();
            String ciudad = spCiudad.getSelectedItem().toString();
    // Crear objeto de tipo PersonaIMC y agregarlo a la lista
            PersonaIMC persona = new PersonaIMC(nombre, peso, altura, genero, ciudad); listaPersonas.add(persona);
            Toast.makeText(this, "Datos guardados correctamente", Toast.LENGTH_SHORT).show();
            limpiarCampos();
        }
    //Método para limpiar los campos del formulario
        private void limpiarCampos() {
        etNombre.setText("");
        etPeso.setText("");
        etAltura.setText("");
        rgGenero.clearCheck();
        spCiudad.setSelection(0);
    }}
