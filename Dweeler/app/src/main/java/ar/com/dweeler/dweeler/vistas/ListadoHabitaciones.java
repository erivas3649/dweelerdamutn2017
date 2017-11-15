package ar.com.dweeler.dweeler.vistas;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import ar.com.dweeler.dweeler.R;
import ar.com.dweeler.dweeler.adaptadores.HabitacionesAdapter;
import ar.com.dweeler.dweeler.dao.HabitacionDAO;
import ar.com.dweeler.dweeler.daosqlite.HabitacionSqliteDAO;
import ar.com.dweeler.dweeler.modelos.Habitacion;
import ar.com.dweeler.dweeler.modelos.Hogar;

public class ListadoHabitaciones extends ListFragment {

    public interface ListadoHabitacionesListener {
        void onHabitacionSelected(Habitacion h);
    }

    private static final String BROADCASTACTUALIZAR = "ar.com.dweeler.ActividadPrincipal.ACTUALIZAR";
    private IntentFilter filtro;
    private BroadcastReceiver receptor;

    private HabitacionDAO hadao;
    private HabitacionesAdapter adapter;
    private ListadoHabitacionesListener listener;
    private Hogar hogar;

    public ListadoHabitaciones() {
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            listener = (ListadoHabitacionesListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement ListadoHabitacionesListener");
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragmento_listado_habitaciones, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        hadao = new HabitacionSqliteDAO(getContext().getApplicationContext());
        adapter = new HabitacionesAdapter(getContext());
        filtro = new IntentFilter(BROADCASTACTUALIZAR);
        receptor = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
            actualizarListado();
            }
        };
        getActivity().registerReceiver(receptor, filtro);
        setListAdapter(adapter);
        actualizarListado();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        getActivity().unregisterReceiver(receptor);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        listener.onHabitacionSelected(adapter.getItem(position));
    }

    public static ListadoHabitaciones getOne(Hogar h) {
        ListadoHabitaciones lh = new ListadoHabitaciones();
        lh.hogar = h;
        return  lh;
    }

    private void actualizarListado () {
        adapter.setData(hadao.findAllByHogar(hogar.getId()));
        adapter.notifyDataSetChanged();
    }
}
