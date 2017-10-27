package ar.com.dweeler.dweeler.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ar.com.dweeler.dweeler.R;
import ar.com.dweeler.dweeler.modelos.Notificacion;

/**
 * Created by nemesys on 17/10/17.
 */

public class NotificacionesAdapter extends ListAdapter<Notificacion> {

    private LayoutInflater inflater;

    public NotificacionesAdapter(Context c) {
        this.data = new ArrayList<>();
        this.inflater = LayoutInflater.from(c);
    }

    public NotificacionesAdapter(Context c, List<Notificacion> data) {
        this(c);
        this.data = data;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View itemView = view != null ? view : inflater.inflate(R.layout.item_notificacion, null);
        ViewHolder vh = (ViewHolder) itemView.getTag();
        if(vh == null) {
            vh = new ViewHolder(itemView);
            itemView.setTag(vh);
        }
        vh.refresh(getItem(i));
        return itemView;
    }

    public class ViewHolder {
        private TextView titulo, subtitulo;

        public ViewHolder(View itemView) {
            titulo = itemView.findViewById(R.id.lblTituloItem);
            subtitulo =  itemView.findViewById(R.id.lblSubtituloItem);
        }

        public void refresh (Notificacion n) {
            titulo.setText(n.getMensaje());
            subtitulo.setText(n.getFechaFormateada());
        }
    }
}
