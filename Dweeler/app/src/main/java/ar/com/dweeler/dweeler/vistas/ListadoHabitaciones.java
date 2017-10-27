package ar.com.dweeler.dweeler.vistas;


import android.content.Context;
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
import ar.com.dweeler.dweeler.modelos.Habitacion;
import ar.com.dweeler.dweeler.modelos.Hogar;

public class ListadoHabitaciones extends ListFragment {

    public interface ListadoHabitacionesListener {
        void onHabitacionSelected(Habitacion h);
    }

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
        ArrayList<Habitacion> habitaciones = new ArrayList<>();
        habitaciones.add(new Habitacion("Comedor", "Tu", Habitacion.TIPO.COMEDOR));
        habitaciones.add(new Habitacion("Cocina", "Tu", Habitacion.TIPO.COCINA));
        habitaciones.add(new Habitacion("Living", "Tu", Habitacion.TIPO.LIVING));
        habitaciones.add(new Habitacion("Dormitorio Principal", "Tu", Habitacion.TIPO.DORMITORIO));
        habitaciones.add(new Habitacion("Dormitorio Niños", "Tu", Habitacion.TIPO.DORMITORIO));
        habitaciones.add(new Habitacion("Oficina", "Tu", Habitacion.TIPO.OFICINA));
        habitaciones.add(new Habitacion("Porche", "Tu", Habitacion.TIPO.GENERICA));
        habitaciones.add(new Habitacion("Garage", "Tu", Habitacion.TIPO.GENERICA));
        adapter = new HabitacionesAdapter(getContext(), habitaciones);
        setListAdapter(adapter);
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
}
