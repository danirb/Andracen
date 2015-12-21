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

import dto.Item;
import dto.Tipo;
import es.hol.danirb.andracen.R;
import es.hol.danirb.andracen.controladores.ConfiguracionActivity;
import es.hol.danirb.andracen.controladores.ItemDetallado;
import es.hol.danirb.andracen.controladores.ListadoItem;
import rest.Service;
import rest.ServiceGenerator;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by dani on 17/12/15.
 */
public class TipoAdaptador extends RecyclerView.Adapter<TipoAdaptador.TipoViewHolder> {
    List<Tipo> tipoList;
    Context context ;
    public TipoAdaptador(List<Tipo> tipoList) {
this.tipoList = tipoList;
    }

    @Override
    public TipoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_listado_tipos,
                parent, false);
        context = parent.getContext();
        return new TipoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(TipoViewHolder holder, int position) {
        final Tipo tipo = tipoList.get(position);
        holder.nombre.setText(tipo.getNombre());
        holder.cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    mostrarItems(tipo.getNombre());
                } catch (Exception e) {
                    e.printStackTrace();
                    Intent intent = new Intent(context, ConfiguracionActivity.class);
                    context.startActivity(intent);
                    Log.d("excep",e.toString());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return tipoList.size();
    }
    public class TipoViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView nombre;

        public TipoViewHolder(View itemView) {
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.cv_tipos);
            nombre = (TextView) itemView.findViewById(R.id.tvNombreTipoCL);
        }
    }
    private void mostrarItems(String nombretipo) throws Exception {
        Service client = ServiceGenerator.createService(Service.class);
        Call<List<Item>> call1 = client.getItemPorTipo(nombretipo);
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
                        Toast.makeText(context, "No hay articulos", Toast.LENGTH_SHORT).show();
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
}
