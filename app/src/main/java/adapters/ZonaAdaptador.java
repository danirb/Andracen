package adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.List;

import activities.ConfiguracionActivity;
import activities.ListadoItem;
import es.hol.danirb.andracen.R;
import models.Item;
import models.Zona;
import rest.Service;
import rest.ServiceGenerator;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by dani on 17/12/15.
 */
public class ZonaAdaptador extends RecyclerView.Adapter<ZonaAdaptador.ZonaViewHolder> {
    List<Zona> zonaList;
    Context context ;
    public ZonaAdaptador(List<Zona> zonaList) {
this.zonaList=zonaList;
    }

    @Override
    public ZonaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_listado_zonas,
                parent, false);
        context = parent.getContext();
        return new ZonaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ZonaViewHolder holder, int position) {
        final Zona zona = zonaList.get(position);
        holder.nombre.setText(zonaList.get(position).getNombre());
        holder.cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    mostrarItems(zona.getNombre());
                } catch (Exception e) {
                    e.printStackTrace();
                    Intent intent = new Intent(context, ConfiguracionActivity.class);
                    context.startActivity(intent);
                    Log.d("excep", e.toString());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return zonaList.size();
    }

    private void mostrarItems(String nombretipo) throws Exception {
        Service client = ServiceGenerator.createService(Service.class);
        Call<List<Item>> call1 = client.getItemPorZona(nombretipo);
        call1.enqueue(new Callback<List<Item>>() {
            @Override
            public void onResponse(Response<List<Item>> response, Retrofit retrofit) {
                if (response.isSuccess()) {
                    List<Item> articulos = response.body();
                    Intent intent = new Intent(context, ListadoItem.class);
                    intent.putExtra("lista", (Serializable) articulos);
                    context.startActivity(intent);
                }else{
                    if(response.code()==500)
                        Toast.makeText(context,"No hay articulos",Toast.LENGTH_SHORT).show();
                    else{
                    Intent intent = new Intent(context, ConfiguracionActivity.class);
                    context.startActivity(intent);
                    Log.d("ENQUE", "ELSE");}

                }

            }
            @Override
            public void onFailure(Throwable t) {
                Intent intent = new Intent(context, ConfiguracionActivity.class);
                context.startActivity(intent);
                Log.d("onFailure", t.toString());
            }
        });
    }

    public class ZonaViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView nombre;

        public ZonaViewHolder(View itemView) {
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.cv_zonas);
            nombre = (TextView) itemView.findViewById(R.id.tvNombreZonaCL);
        }
    }
}
