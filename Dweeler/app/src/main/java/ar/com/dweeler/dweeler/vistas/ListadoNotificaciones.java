package ar.com.dweeler.dweeler.vistas;


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
        adapter = new NotificacionesAdapter(getContext(), nodao.findAll());
        setListAdapter(adapter);
    }
}
