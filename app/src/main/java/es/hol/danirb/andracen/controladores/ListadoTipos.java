package es.hol.danirb.andracen.controladores;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import adapters.TipoAdaptador;
import dto.Tipo;
import es.hol.danirb.andracen.R;

public class ListadoTipos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_tipos);
        Intent intent = getIntent();
        List<Tipo> tipoList = (List<Tipo>) intent.getSerializableExtra("listadotipos");
        RecyclerView rv = (RecyclerView) findViewById(R.id.rvTipos);
        LinearLayoutManager llm3 = new LinearLayoutManager(this);
        rv.setLayoutManager(llm3);
        rv.setAdapter(new TipoAdaptador(tipoList));
    }
}
