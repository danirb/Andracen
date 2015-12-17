package es.hol.danirb.andracen.controladores;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import adapters.ArticuloAdaptador;
import dto.Item;
import es.hol.danirb.andracen.R;

/**
 * Created by dani on 14/12/15.
 */
public class ListadoDatos extends AppCompatActivity {
    private RecyclerView rv;
    private List<Item> articuloList = new ArrayList<Item>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_datos);
        Intent intent = getIntent();
        articuloList = (List<Item>) intent.getSerializableExtra("lista");
        rv = (RecyclerView) findViewById(R.id.rvDatos);
        LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext());
        rv.setLayoutManager(llm);
        rv.setAdapter(new ArticuloAdaptador(articuloList));
    }
}
