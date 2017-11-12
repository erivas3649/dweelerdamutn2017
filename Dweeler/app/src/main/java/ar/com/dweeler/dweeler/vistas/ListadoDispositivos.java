package ar.com.dweeler.dweeler.vistas;


import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import ar.com.dweeler.dweeler.R;
import ar.com.dweeler.dweeler.adaptadores.DispositivosAdapter;
import ar.com.dweeler.dweeler.dao.DispositivoDAO;
import ar.com.dweeler.dweeler.daosqlite.DispositivoSqliteDAO;
import ar.com.dweeler.dweeler.modelos.Dispositivo;
import ar.com.dweeler.dweeler.modelos.Habitacion;
import ar.com.dweeler.dweeler.modelos.Hogar;

public class ListadoDispositivos extends ListFragment {

    private Hogar hogar;
    private Habitacion habitacion;
    private DispositivoDAO didao;
    private DispositivosAdapter adapter;

    public ListadoDispositivos() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragmento_listado_dispositivos, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        didao = new DispositivoSqliteDAO(getContext().getApplicationContext());
        List<Dispositivo> dispositivos;
        if(habitacion != null) {
            dispositivos = didao.findAllByHabitacion(habitacion.getId());
        }
        else {
            dispositivos = didao.findAllByHogar(hogar.getId());
        }
        adapter = new DispositivosAdapter(getContext(), dispositivos);
        setListAdapter(adapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {

    }

    public static ListadoDispositivos getOne(Habitacion h) {
        ListadoDispositivos ld = new ListadoDispositivos();
        ld.habitacion = h;
        return ld;
    }

    public static ListadoDispositivos getOne(Hogar h) {
        ListadoDispositivos ld = new ListadoDispositivos();
        ld.hogar = h;
        return ld;
    }
}
