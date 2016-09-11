package activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.Serializable;
import java.util.List;

import es.hol.danirb.andracen.R;
import models.Item;
import models.Tipo;
import models.Zona;
import rest.Service;
import rest.ServiceGenerator;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class PantallaCarga extends AppCompatActivity {
    private List<Item> articulos;
    private List<Zona> zonas;
    private List<Tipo> tipos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_carga);
        Button btn_todos = (Button) findViewById(R.id.btn_todos);
        btn_todos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    mostrarTodos();
                } catch (Exception e) {
                    e.printStackTrace();
                    Intent intent = new Intent(PantallaCarga.this, ConfiguracionActivity.class);
                    startActivity(intent);
                }
            }
        });
        Button btn_categorias = (Button) findViewById(R.id.btn_categorias);
        btn_categorias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    mostrarTipos();
                } catch (Exception e) {
                    e.printStackTrace();
                    Intent intent = new Intent(PantallaCarga.this, ConfiguracionActivity.class);
                    startActivity(intent);
                }

            }
        });
        Button btn_zonas = (Button) findViewById(R.id.btn_zonas);
        btn_zonas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    mostrarZonas();
                } catch (Exception e) {
                    e.printStackTrace();
                    Intent intent = new Intent(PantallaCarga.this, ConfiguracionActivity.class);
                    startActivity(intent);
                }

            }
        });

    }

    private void mostrarZonas() {
        Service client2 = ServiceGenerator.createService(Service.class);
        Call<List<Zona>> call = client2.getZonas();
        call.enqueue(new Callback<List<Zona>>() {
            @Override
            public void onResponse(Response<List<Zona>> response, Retrofit retrofit) {
                if (response.isSuccess()) {
                    zonas = response.body();
                    Intent intent = new Intent(PantallaCarga.this, ListadoZonas.class);
                    intent.putExtra("listazonas", (Serializable) zonas);
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(PantallaCarga.this, ConfiguracionActivity.class);
                    startActivity(intent);
                    Log.d("ENQUE", "ELSE");
                }

            }

            @Override
            public void onFailure(Throwable t) {
                Intent intent = new Intent(PantallaCarga.this, ConfiguracionActivity.class);
                startActivity(intent);
                Log.d("onFailure", t.toString());
            }
        });
    }

    private void mostrarTipos() {
        Service client3 = ServiceGenerator.createService(Service.class);
        Call<List<Tipo>> call = client3.getTipos();
        call.enqueue(new Callback<List<Tipo>>() {
            @Override
            public void onResponse(Response<List<Tipo>> response, Retrofit retrofit) {
                if (response.isSuccess()) {
                    tipos = response.body();

                    Intent intent = new Intent(PantallaCarga.this, ListadoTipos.class);
                    intent.putExtra("listadotipos", (Serializable) tipos);
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(PantallaCarga.this, ConfiguracionActivity.class);
                    startActivity(intent);
                    Log.d("ENQUE", "ELSE");
                }

            }

            @Override
            public void onFailure(Throwable t) {
                Intent intent = new Intent(PantallaCarga.this, ConfiguracionActivity.class);
                startActivity(intent);
                Log.d("onFailure", t.toString());
            }
        });
    }

    private void mostrarTodos() throws Exception {
        Service client = ServiceGenerator.createService(Service.class);
        Call<List<Item>> call1 = client.repoItems();
        call1.enqueue(new Callback<List<Item>>() {
            @Override
            public void onResponse(Response<List<Item>> response, Retrofit retrofit) {
                if (response.isSuccess()) {
                    articulos = response.body();
                    Intent intent = new Intent(PantallaCarga.this, ListadoItem.class);
                    intent.putExtra("lista", (Serializable) articulos);
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(PantallaCarga.this, ConfiguracionActivity.class);
                    startActivity(intent);
                    Log.d("ENQUE", "ELSE");
                }

            }

            @Override
            public void onFailure(Throwable t) {
                Intent intent = new Intent(PantallaCarga.this, ConfiguracionActivity.class);
                startActivity(intent);
                Log.d("onFailure", t.toString());
            }
        });
    }
}
