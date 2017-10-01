package com.example.matias.dweeler;

import android.app.ListActivity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Matias on 01/10/2017.
 */

public class HabitacionesActivity extends ListActivity {

    public static final String TAG = "HogaresAndroid";
    private HabitacionesAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.habitacion_layout);
        adapter = new HabitacionesAdapter();
        setListAdapter(adapter);
        cargarDatos();
    }

    private void cargarDatos(){

        Habitacion habitacion = new Habitacion();
        habitacion.setType(Habitacion.TYPE_COMEDOR);
        habitacion.setHabitacion("COMEDOR");
        habitacion.setQuien("Tú");
        adapter.addHabitacion(habitacion);

        habitacion = new Habitacion();
        habitacion.setType(Habitacion.TYPE_LIVING);
        habitacion.setHabitacion("LIVING");
        habitacion.setQuien("Tú");
        adapter.addHabitacion(habitacion);

        habitacion = new Habitacion();
        habitacion.setType(Habitacion.TYPE_COCINA);
        habitacion.setHabitacion("COCINA");
        habitacion.setQuien("Tú");
        adapter.addHabitacion(habitacion);

        habitacion = new Habitacion();
        habitacion.setType(Habitacion.TYPE_DORMITORIO);
        habitacion.setHabitacion("DORMITORIO");
        habitacion.setQuien("Tú");
        adapter.addHabitacion(habitacion);
    }

    class HabitacionesAdapter extends BaseAdapter{
        private ArrayList<Habitacion> habitaciones;
        private LayoutInflater inflater;

        public HabitacionesAdapter(){
            habitaciones = new ArrayList<Habitacion>();
            inflater = LayoutInflater.from(HabitacionesActivity.this);
        }

        public void addHabitacion(Habitacion habitacion){
            if(habitacion != null){
                habitaciones.add(habitacion);
            }
        }

        @Override
        public int getCount() {
            return habitaciones.size();
        }

        @Override
        public Object getItem(int position) {
            return habitaciones.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        class Holder{
            ImageView img_habitacion;
            TextView text_habitacion;
            TextView text_quien;
            ImageButton img_menuVertical;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Holder holder;
            if (convertView == null) {
                convertView = inflater.inflate(R.layout.item_habitacion_layout, null);
                holder = new Holder();
                holder.img_habitacion = (ImageView) convertView
                        .findViewById(R.id.img_habitacion);
                holder.text_habitacion = (TextView) convertView
                        .findViewById(R.id.txt_habitacion);
                holder.text_quien = (TextView) convertView
                        .findViewById(R.id.txt_quien);
                holder.img_menuVertical = (ImageButton) convertView
                        .findViewById(R.id.btn_menuVertical);
                convertView.setTag(holder);
            } else {
                holder = (Holder) convertView.getTag();
            }

            Habitacion info = (Habitacion) getItem(position);
            holder.img_habitacion.setBackgroundResource(getHabitacionTypeIcon(info.getType()));
            holder.text_habitacion.setText(info.getHabitacion());
            holder.text_quien.setText(info.getQuien());
            holder.img_menuVertical.setBackgroundResource(getMenuTypeIcon(info
                    .getType()));
            return convertView;
        }
    }

    public int getHabitacionTypeIcon(int type) {
        int resId = 0;
        switch (type){
            case Habitacion.TYPE_COMEDOR:
                resId = R.drawable.comedor;
                break;
            case Habitacion.TYPE_LIVING:
                resId = R.drawable.living;
                break;
            case Habitacion.TYPE_COCINA:
                resId = R.drawable.cocina;
                break;
            case Habitacion.TYPE_DORMITORIO:
                resId = R.drawable.dormir;
                break;
        }
        return resId;
    }

    public int getMenuTypeIcon(int type) {
        int resId = R.drawable.menuvertical;
        return resId;
    }
}
