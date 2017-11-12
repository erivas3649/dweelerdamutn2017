package ar.com.dweeler.dweeler.vistas;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import ar.com.dweeler.dweeler.R;
import ar.com.dweeler.dweeler.adaptadores.HogaresAdapter;
import ar.com.dweeler.dweeler.dao.HogarDAO;
import ar.com.dweeler.dweeler.daosqlite.HogarSqliteDAO;
import ar.com.dweeler.dweeler.modelos.Hogar;

public class ListadoHogares extends ListFragment {

    public interface ListadoHogaresListener {
        void onHogarSelected(Hogar h);
    }

    private HogarDAO hodao;
    private HogaresAdapter adapter;
    private ListadoHogaresListener listener;

    public ListadoHogares () {
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            listener = (ListadoHogaresListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement ListadoHogaresListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragmento_listado_hogares, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        hodao = new HogarSqliteDAO(getContext().getApplicationContext());
        adapter = new HogaresAdapter(getContext(), hodao.findAll());
        setListAdapter(adapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        listener.onHogarSelected(adapter.getItem(position));
    }

    public static ListadoHogares getOne () {
        return new ListadoHogares();
    }
}
