package com.example.matias.dweeler;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Matias on 30/09/2017.
 */

public class HogaresActivity extends ListActivity implements AdapterView.OnItemClickListener {

    public static final String TAG = "HogaresAndroid";
    private HogaresAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hogar_layout);
        adapter = new HogaresAdapter();
        setListAdapter(adapter);
        cargarDatos();
        getListView().setClickable(true);
        getListView().setOnItemClickListener(this);
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

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        TabHost.TabSpec tab2 = MainFragment.tab.newTabSpec("tabHabitacion");
        Intent intent = new Intent().setClass(this, HabitacionesActivity.class);
        tab2.setContent(R.id.tab1);
        tab2.setIndicator("Departamento", null);
        tab2.setContent(intent);
        MainFragment.tab.addTab(tab2);
        MainFragment.tab.setCurrentTab(1);
    }

    @Override
    protected void onResume() {
        super.onResume();
        getListView().setClickable(true);
        getListView().setOnItemClickListener(this);
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
            private ImageView img_hogar;
            private TextView text_hogar;
            private TextView text_direccion;
            private ImageButton img_menuVertical;
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
        int resId = R.drawable.home48px;
        return resId;
    }

    public int getMenuTypeIcon(int type) {
        int resId = R.drawable.menuvertical;
        return resId;
    }
}
