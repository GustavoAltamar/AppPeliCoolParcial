package com.example.pelicool;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import androidx.appcompat.app.AlertDialog;

public class registraPelicula extends AppCompatActivity {

    private EditText peli, dir;
    private RadioButton rb1, rb2;
    private Spinner generos;
    private String item;
    private ArrayList<Pelicula> Peli = new ArrayList<Pelicula>();
    private String idioma;
    private Button guadar, cancel, lista;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registra_pelicula);

        peli = findViewById(R.id.etxt_pelicula);
        dir = findViewById(R.id.etxt_director);
        generos = findViewById(R.id.spn_genero);
        rb1 = findViewById(R.id.rbd_1);
        rb2 = findViewById(R.id.rbd_2);
        String[] genero = {"psicologico", "comedia", "terror", "tragedia", "suspenso", "romance", "Accion"};
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.item, R.id.txt_gen, genero);
        generos.setAdapter(arrayAdapter);

        guadar = findViewById(R.id.btn_guarda);
        cancel = findViewById(R.id.btn_cancela);
        lista = findViewById(R.id.btn_lista);


    }

    public void guardarPelicula() {
        item = generos.getSelectedItem().toString();
        AlertDialog.Builder builder = new AlertDialog.Builder(registraPelicula.this);
        builder.setMessage("¿Desea guardar la pelicula?")
                .setPositiveButton("SI", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        if (rb1.isChecked() == true) {
                            idioma = ("ingles");
                            Peli.add(new Pelicula(peli.getText().toString(), dir.getText().toString(), idioma, idioma));
                        }
                        if (rb2.isChecked() == true) {
                            idioma = ("Español");
                            Peli.add(new Pelicula(peli.getText().toString(), dir.getText().toString(), item, idioma));
                        }
                        Toast.makeText(getApplicationContext(), " Guardado", Toast.LENGTH_LONG).show();
                    }
                })
                .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                        Toast.makeText(getApplicationContext(), " Cancelado", Toast.LENGTH_LONG).show();
                    }
                });
        AlertDialog alerta = builder.create();
        alerta.show();
    }

    public void onClick(View v) {

        switch (v.getId()) {


            case R.id.btn_guarda:
                guardarPelicula();
                break;

            case R.id.btn_cancela:
                AlertDialog.Builder b = new AlertDialog.Builder(registraPelicula.this);
                b.setMessage("Desea Cancelar")
                        .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                                Toast.makeText(getApplicationContext(), "Cancelado", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
                AlertDialog a = b.create();
                a.show();
                break;

            case R.id.btn_lista:
                Intent i = new Intent(getApplicationContext(), listaPeliculas.class);
                i.putParcelableArrayListExtra("datos", Peli);
                startActivity(i);
                break;
        }
    }
}
