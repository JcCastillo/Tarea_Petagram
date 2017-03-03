package com.jccl.petagram;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        listaMascotas = (RecyclerView) findViewById(R.id.rvMascota);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);
        inicializarMascotas();
        inicializarAdaptador();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch  (item.getItemId()){
            case R.id.mFavoritos:
                irFavoritos();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    public void inicializarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas);
        listaMascotas.setAdapter(adaptador);
    }

    public void inicializarMascotas(){
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota("Rocky",R.drawable.dog1));
        mascotas.add(new Mascota("Rufo",R.drawable.dog2));
        mascotas.add(new Mascota("Terry", R.drawable.dog3));
        mascotas.add(new Mascota("Pelusa", R.drawable.dog4));
        mascotas.add(new Mascota("Rafa", R.drawable.dog5));
        mascotas.add(new Mascota("Jefe", R.drawable.dog6));
        mascotas.add(new Mascota("Canelo", R.drawable.dog7));
    }

    public void irFavoritos(){
        Intent intent = new Intent(this,mascotas_favoritas.class);
        startActivity(intent);
    }
}
