package adapters;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import dto.Item;
import es.hol.danirb.andracen.R;

/**
 * Created by dani on 14/12/15.
 */
public class ArticuloAdaptador extends RecyclerView.Adapter<ArticuloAdaptador.DatoViewHolder> {
    List<Item> articuloList;

    public ArticuloAdaptador(List<Item> articuloList) {
        this.articuloList = articuloList;
    }

    @Override
    public DatoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_listado_datos,
                parent, false);
        return new DatoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(DatoViewHolder holder, int position) {
        holder.nombre.setText(articuloList.get(position).getNombreitem());
        holder.tipo.setText(articuloList.get(position).getNombretipo());
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
