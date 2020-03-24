package com.example.pelicool;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;



import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class listaPeliculas extends AppCompatActivity {

    private ArrayList<Pelicula> registro = new ArrayList<Pelicula>();
    private ArrayAdapter<Pelicula> arrayAdapter;
    private ListView listaprincipla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_peliculas);

        Intent in = getIntent();
        registro = in.getParcelableArrayListExtra("datos");
        listaprincipla = findViewById(R.id.lv_lista);
        arrayAdapter = new ArrayAdapter<Pelicula>(this, R.layout.lista_item, R.id.txt_lista2,registro);
        listaprincipla.setAdapter(arrayAdapter);
        arrayAdapter.notifyDataSetChanged();

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mnu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id){


            case R.id.az:
                Collections.sort(registro, new Comparator<Pelicula>() {
                    @Override
                    public int compare(Pelicula o1, Pelicula o2) {
                        return o1.getPelicula().compareTo(o2.getPelicula());
                    }
                });
                arrayAdapter.notifyDataSetChanged();
                break;
            case R.id.borrar:
                registro.remove(0);
               arrayAdapter.notifyDataSetChanged();
                break;

            case R.id.invertir:
                Collections.reverse(registro);
                arrayAdapter.notifyDataSetChanged();
                break;


            case R.id.genero:
                Collections.sort(registro, new Comparator<Pelicula>() {
                    @Override
                    public int compare(Pelicula o1, Pelicula o2) {
                        return o1.getTipo().compareTo(o2.getTipo());
                    }
                });
                arrayAdapter.notifyDataSetChanged();

                break;

        }
        return super.onOptionsItemSelected(item);
    }
}
