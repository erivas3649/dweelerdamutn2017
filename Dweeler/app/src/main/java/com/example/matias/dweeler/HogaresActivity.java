package com.example.matias.dweeler;

import android.app.ListActivity;
import android.os.Bundle;
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
 * Created by Matias on 30/09/2017.
 */

public class HogaresActivity extends ListActivity {

    public static final String TAG = "MainAndroidDialogs";
    private HogaresAdapter adapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hogar_layout);
        adapter = new HogaresAdapter();

        setListAdapter(adapter);
        cargarDatos();
    }

    private void cargarDatos(){
        for (int i = 0; i < 1; i++){
            Hogar hogar = new Hogar();
            hogar.setType(Hogar.TYPE_HOGAR);
            hogar.setHogar("Departamento");
            hogar.setDireccion("Bv. Illia 430 3° A");
            adapter.addHogar(hogar);
        }
    }


    class HogaresAdapter extends BaseAdapter{
        private ArrayList<Hogar> hogares;
        private LayoutInflater layoutInflater;

        public HogaresAdapter(){
            hogares = new ArrayList<Hogar>();
            layoutInflater = LayoutInflater.from(HogaresActivity.this);
        }

        public void addHogar(Hogar info) {
            if (info != null) {
                hogares.add(info);
            }
        }

        @Override
        public int getCount() {
            return hogares.size();
        }

        @Override
        public Object getItem(int position) {
            return hogares.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        class Holder{
            ImageView img_hogar;
            TextView text_hogar;
            TextView text_direccion;
            ImageButton img_menuVertical;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Holder holder;
            if (convertView == null) {
                convertView = layoutInflater.inflate(R.layout.item_hogar_layout, null);
                holder = new Holder();
                holder.img_hogar = (ImageView) convertView
                        .findViewById(R.id.img_hogar);
                holder.text_hogar = (TextView) convertView
                        .findViewById(R.id.txt_hogar);
                holder.text_direccion = (TextView) convertView
                        .findViewById(R.id.txt_direccion);
                holder.img_menuVertical = (ImageButton) convertView
                        .findViewById(R.id.btn_menuVertical);
                convertView.setTag(holder);
            } else {
                holder = (Holder) convertView.getTag();
            }

            Hogar info = (Hogar) getItem(position);
            holder.img_hogar.setBackgroundResource(getHogarTypeIcon(info.getType()));
            holder.text_hogar.setText(info.getHogar());
            holder.text_direccion.setText(info.getDireccion());
            holder.img_menuVertical.setBackgroundResource(getMenuTypeIcon(info
                    .getType()));
            return convertView;
        }
    }

    public int getHogarTypeIcon(int type) {
        int resId = R.drawable.home;
        return resId;
    }

    public int getMenuTypeIcon(int type) {
        int resId = R.drawable.menu_vertical;
        return resId;
    }
}
