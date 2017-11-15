package ar.com.dweeler.dweeler.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import ar.com.dweeler.dweeler.R;
import ar.com.dweeler.dweeler.modelos.Actividad;

/**
 * Created by nemesys on 17/10/17.
 */

public class ActividadesAdapter extends ListAdapter<Actividad> {

    private LayoutInflater inflater;

    public ActividadesAdapter(Context c) {
        super();
        this.inflater = LayoutInflater.from(c);
    }

    public ActividadesAdapter(Context c, List<Actividad> data) {
        this(c);
        this.data = data;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View itemView = view != null ? view : inflater.inflate(R.layout.item_actividad, null);
        ViewHolder vh = (ViewHolder) itemView.getTag();
        if(vh == null) {
            vh = new ViewHolder(itemView);
            itemView.setTag(vh);
        }
        vh.refresh(getItem(i));
        return itemView;
    }

    public static class ViewHolder {
        private TextView titulo;

        public ViewHolder(View itemView) {
            titulo = itemView.findViewById(R.id.lblTituloActividad);
        }

        public void refresh (Actividad a) {
            titulo.setText(a.getNombre());
        }
    }
}
