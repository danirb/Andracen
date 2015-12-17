package es.hol.danirb.andracen.controladores;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import java.io.Serializable;
import java.util.List;
import java.util.concurrent.TimeUnit;

import dto.Item;
import es.hol.danirb.andracen.R;

import rest.Service;
import rest.ServiceGenerator;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class PantallaCarga extends AppCompatActivity {
    private Service client;
    private List<Item> articulos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_carga);
        Button btn_todos = (Button) findViewById(R.id.btn_todos);
        btn_todos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    lanzarLlamada();
                } catch (Exception e) {
                    e.printStackTrace();
                    Intent intent = new Intent(PantallaCarga.this, ConfiguracionActivity.class);
                    startActivity(intent);
                }
            }
        });

        }


    private void lanzarLlamada() throws Exception {
        client = ServiceGenerator.createService(Service.class);//creo servicio
        Call<List<Item>> call = client.repoItems();
        call.enqueue(new Callback<List<Item>>() {
            @Override
            public void onResponse(Response<List<Item>> response, Retrofit retrofit) {
                if (response.isSuccess()) {
                    articulos = response.body();
                    Intent intent = new Intent(PantallaCarga.this, ListadoDatos.class);
                    intent.putExtra("lista", (Serializable) articulos);
                    startActivity(intent);
                }else{
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
