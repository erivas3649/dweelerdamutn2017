package ar.com.dweeler.dweeler.vistas;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import ar.com.dweeler.dweeler.R;
import ar.com.dweeler.dweeler.adaptadores.ActividadesAdapter;
import ar.com.dweeler.dweeler.dao.ActividadDAO;
import ar.com.dweeler.dweeler.daosqlite.ActividadSqliteDAO;
import ar.com.dweeler.dweeler.modelos.Actividad;
import ar.com.dweeler.dweeler.modelos.Habitacion;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListadoActividades extends ListFragment {

    private static final String BROADCASTACTUALIZAR = "ar.com.dweeler.ActividadPrincipal.ACTUALIZAR";
    private IntentFilter filtro;
    private BroadcastReceiver receptor;

    private ActividadDAO acdao;
    private ActividadesAdapter adapter;
    private Habitacion habitacion;

    public ListadoActividades() {}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragmento_listado_actividades, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        acdao = new ActividadSqliteDAO(getContext().getApplicationContext());
        adapter = new ActividadesAdapter(getContext());
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


    public static ListadoActividades getOne (Habitacion h) {
        ListadoActividades la = new ListadoActividades();
        la.habitacion = h;
        return la;
    }

    private void actualizarListado () {
        adapter.setData(acdao.findAllByHabitacion(habitacion.getId()));
        adapter.notifyDataSetChanged();
    }

}
