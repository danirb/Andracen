package es.hol.danirb.andracen.controladores;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Debug;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import dto.Item;
import dto.ItemCompleto;
import es.hol.danirb.andracen.R;
import rest.Service;
import rest.ServiceGenerator;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class ItemDetallado extends AppCompatActivity {
    Item articulo;
    ItemCompleto articuloscompleto;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detallado);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Intent intent = getIntent();
        articulo = (Item) intent.getSerializableExtra("articulo");
        context = this;

        TextView tv_nombre = (TextView) findViewById(R.id.tv_nombre_item_id);
        tv_nombre.setText(articulo.getNombreitem());
        TextView tv_tipo = (TextView) findViewById(R.id.tv_tipo_id);
        tv_tipo.setText(articulo.getNombretipo());
        LinearLayout cuadro = (LinearLayout) findViewById(R.id.zona);
        Lienzo zona = new Lienzo(context);
        cuadro.addView(zona);



        context = this;


    }


    public class Lienzo extends View {
        private Bitmap bmp;

        public Lienzo(Context context) {
            super(context);

            bmp = BitmapFactory.decodeResource(getResources(), R.drawable.ic_info_black_24dp
            );

        }

        @Override
        protected void onDraw(Canvas canvas) {
            switch (articulo.getNombrezona()){
                case "Cocinilla":
                    canvas.drawColor(Color.BLUE);
                    break;
                case "Departamento":
                    canvas.drawColor(Color.WHITE);
                    break;

            }
            canvas.drawBitmap(bmp, articulo.getX()*100, articulo.getY()*100, null);
        }
    }
}
