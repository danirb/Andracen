package adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import es.hol.danirb.andracen.R;
import es.hol.danirb.andracen.controladores.ItemDetallado;
import models.Item;
import models.ItemCompleto;

/**
 * Created by dani on 14/12/15.
 */
public class ItemAdaptador extends RecyclerView.Adapter<ItemAdaptador.DatoViewHolder>  {
    List<Item> articuloList;
    ItemCompleto articuloscompleto;
    Context context ;
    public ItemAdaptador(List<Item> articuloList) {
        this.articuloList = articuloList;
    }

    @Override
    public DatoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_listado_items,
                parent, false);
      context = parent.getContext();

        return new DatoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(DatoViewHolder holder, int position) {
        final Item articulo = articuloList.get(position);
        holder.nombre.setText(articulo.getNombreitem());
        holder.tipo.setText(articulo.getNombretipo());
        holder.cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context.getApplicationContext(), ItemDetallado.class);
                intent.putExtra("articulo",articulo);

                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return articuloList.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }



    public class DatoViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView nombre;
        TextView tipo;

        public DatoViewHolder(View itemView) {
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.cv_datos);
            nombre = (TextView) itemView.findViewById(R.id.tvNombreItemCL);
            tipo = (TextView) itemView.findViewById(R.id.tvTipoItemCL);
        }

    }



}
