package com.example.matias.dweeler;

import android.app.ListActivity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Matias on 01/10/2017.
 */

public class DispositivoActivity extends ListActivity implements AdapterView.OnItemClickListener {

    public static final String TAG = "DispositivosAndroid";
    private DispositivoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dispositivo_layout);
        adapter = new DispositivoAdapter();
        setListAdapter(adapter);
        cargarDatosDispositivos();
        getListView().setOnItemClickListener(this);
    }

    private void cargarDatosDispositivos(){
        Dispositivo disp = new Dispositivo();
        disp.setType(Dispositivo.TYPE_IMG);
        disp.setDispositivo("Lámpara Comedor");
        disp.setConexion("Conectado");
        adapter.addDispositivo(disp);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, "Hola", Toast.LENGTH_LONG).show();
    }

    class DispositivoAdapter extends BaseAdapter{
        private ArrayList<Dispositivo> dispositivos;
        private LayoutInflater inflater;

        public DispositivoAdapter(){
            dispositivos = new ArrayList<Dispositivo>();
            inflater = LayoutInflater.from(DispositivoActivity.this);
        }

        public void addDispositivo(Dispositivo info){
            if(info != null)
                dispositivos.add(info);
        }

        @Override
        public int getCount() {
            return dispositivos.size();
        }

        @Override
        public Object getItem(int position) {
            return dispositivos.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        class Holder{
            ImageView img_conexion;
            TextView text_dispositivo;
            TextView text_conexion;
            ImageButton img_menuVertical;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Holder holder;
            if (convertView == null) {
                convertView = inflater.inflate(R.layout.item_dispositivo_layout, null);
                holder = new Holder();
                holder.img_conexion = (ImageView) convertView
                        .findViewById(R.id.img_conectado);
                holder.text_dispositivo = (TextView) convertView
                        .findViewById(R.id.txt_dispositivo);
                holder.text_conexion = (TextView) convertView
                        .findViewById(R.id.txt_conexion);
                holder.img_menuVertical = (ImageButton) convertView
                        .findViewById(R.id.btn_menuVertical);
                convertView.setTag(holder);
            } else {
                holder = (Holder) convertView.getTag();
            }

            Dispositivo info = (Dispositivo) getItem(position);
            holder.img_conexion.setBackgroundResource(getConexionTypeIcon(info.getType()));
            holder.text_dispositivo.setText(info.getDispositivo());
            holder.text_conexion.setText(info.getConexion());
            holder.img_menuVertical.setBackgroundResource(getMenuTypeIcon(info
                    .getType()));
            return convertView;
        }
    }

    public int getConexionTypeIcon(int type) {
        int resId = R.drawable.enchufe;
        return resId;
    }

    public int getMenuTypeIcon(int type) {
        int resId = R.drawable.menuvertical;
        return resId;
    }

    public int getMenuPlayTypeIcon(int type) {
        int resId = R.drawable.play;
        return resId;
    }
}
