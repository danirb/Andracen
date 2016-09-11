package activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import adapters.ItemAdaptador;
import es.hol.danirb.andracen.R;
import models.Item;

/**
 * Created by dani on 14/12/15.
 */
public class ListadoItem extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_items);
        Intent intent = getIntent();
        List<Item> articuloList = (List<Item>) intent.getSerializableExtra("lista");
        RecyclerView rv = (RecyclerView) findViewById(R.id.rvDatos);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        rv.setAdapter(new ItemAdaptador(articuloList));
    }
}
