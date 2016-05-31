package activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.List;

import adapters.ZonaAdaptador;
import es.hol.danirb.andracen.R;
import models.Zona;

public class ListadoZonas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_zonas);
        Intent intent = getIntent();
        List<Zona> zonaList = (List<Zona>) intent.getSerializableExtra("listazonas");
        for(Zona zona : zonaList){
            Log.d("Zonas", zona.toString());
        }
        RecyclerView rv1 = (RecyclerView) findViewById(R.id.rvZonas);
        LinearLayoutManager llm1 = new LinearLayoutManager(this);
        rv1.setLayoutManager(llm1);
        rv1.setAdapter(new ZonaAdaptador(zonaList));

    }

}
