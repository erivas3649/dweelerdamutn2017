package ar.com.dweeler.dweeler.adaptadores;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ar.com.dweeler.dweeler.R;
import ar.com.dweeler.dweeler.modelos.Integrante;

/**
 * Created by nemesys on 17/10/17.
 */

public class IntegrantesAdapter extends ListAdapter<Integrante> {

    private LayoutInflater inflater;

    public IntegrantesAdapter(Context c) {
        this.data = new ArrayList<>();
        this.inflater = LayoutInflater.from(c);
    }

    public IntegrantesAdapter(Context c, List<Integrante> data) {
        this(c);
        this.data = data;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View itemView = view != null ? view : inflater.inflate(R.layout.item_listado, null);
        ViewHolder vh = (ViewHolder) itemView.getTag();
        if(vh == null) {
            vh = new ViewHolder(itemView);
            itemView.setTag(vh);
        }
        vh.refresh(getItem(i));
        return itemView;
    }

    public class ViewHolder {
        private ImageView icono;
        private TextView titulo, subtitulo;

        public ViewHolder(View itemView) {
            titulo = itemView.findViewById(R.id.lblTituloItem);
            subtitulo =  itemView.findViewById(R.id.lblSubtituloItem);
            icono = itemView.findViewById(R.id.imgIconoItem);
        }

        public void refresh (Integrante i) {
            titulo.setText(i.getNombre());
            subtitulo.setText(i.getEmail());
            icono.setImageResource(R.drawable.usuario1);
        }
    }
}
