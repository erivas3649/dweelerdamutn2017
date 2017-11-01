package ar.com.dweeler.dweeler.vistas;


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
import ar.com.dweeler.dweeler.modelos.Actividad;
import ar.com.dweeler.dweeler.modelos.Habitacion;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListadoActividades extends ListFragment {


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
        List<Actividad> actividades = new ArrayList<>();
        actividades.add(new Actividad("Encender Todas las Lamparas"));
        actividades.add(new Actividad("Ver Televisión"));
        actividades.add(new Actividad("Todas las Lamparas al 50%"));
        adapter = new ActividadesAdapter(getContext(), actividades);
        setListAdapter(adapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {

    }

    public static ListadoActividades getOne (Habitacion h) {
        ListadoActividades la = new ListadoActividades();
        la.habitacion = h;
        return la;
    }

}
