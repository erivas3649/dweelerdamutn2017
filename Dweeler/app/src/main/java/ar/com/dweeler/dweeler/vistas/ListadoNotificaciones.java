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
import ar.com.dweeler.dweeler.modelos.Notificacion;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListadoNotificaciones extends ListFragment {

    private NotificacionesAdapter adapter;

    public ListadoNotificaciones() {}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragmento_listado_notificaciones, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ArrayList<Notificacion> notificaciones = new ArrayList<>();
        notificaciones.add(new Notificacion("Eric ha agregado a Matias a Departamento Cordoba", Calendar.getInstance().getTime()));
        notificaciones.add(new Notificacion("Matias dice: che me olvide las llaves", Calendar.getInstance().getTime()));
        notificaciones.add(new Notificacion("Dweeler ha iniciado el ahorro de energia en las habitaciones desocupadas", Calendar.getInstance().getTime()));
        adapter = new NotificacionesAdapter(getContext(), notificaciones);
        setListAdapter(adapter);
    }
}
