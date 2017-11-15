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

import java.util.ArrayList;
import java.util.Calendar;

import ar.com.dweeler.dweeler.R;
import ar.com.dweeler.dweeler.adaptadores.NotificacionesAdapter;
import ar.com.dweeler.dweeler.dao.NotificacionDAO;
import ar.com.dweeler.dweeler.daosqlite.NotificacionSqliteDAO;
import ar.com.dweeler.dweeler.modelos.Notificacion;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListadoNotificaciones extends ListFragment {

    private static final String BROADCASTACTUALIZARNOTIFICACIONES = "ar.com.dweeler.ActividadPrincipal.ACTUALIZARNOTIFICACIONES";
    private IntentFilter filtro;
    private BroadcastReceiver receptor;

    private NotificacionDAO nodao;
    private NotificacionesAdapter adapter;

    public ListadoNotificaciones() {}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragmento_listado_notificaciones, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        nodao = new NotificacionSqliteDAO(getContext().getApplicationContext());
        adapter = new NotificacionesAdapter(getContext());
        filtro = new IntentFilter(BROADCASTACTUALIZARNOTIFICACIONES);
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

    private void actualizarListado () {
        adapter.setData(nodao.findAll());
        adapter.notifyDataSetChanged();
    }
}
