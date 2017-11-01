package ar.com.dweeler.dweeler.vistas;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ar.com.dweeler.dweeler.R;
import ar.com.dweeler.dweeler.adaptadores.PagerAdapter;
import ar.com.dweeler.dweeler.modelos.Habitacion;


public class DetalleHabitacion extends Fragment {

    private PagerAdapter adapter;
    private Habitacion habitacion;

    public DetalleHabitacion() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragmento_detalle_habitacion, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        adapter = new PagerAdapter(getFragmentManager());
        adapter.addTab(ListadoDispositivos.getOne(habitacion), "DISPOSITIVOS");
        adapter.addTab(ListadoActividades.getOne(habitacion), "ACTIVIDADES");
        ViewPager pager = getView().findViewById(R.id.layoutPager);
        pager.setAdapter(adapter);
        TabLayout tabber = getView().findViewById(R.id.layoutTabber);
        tabber.setupWithViewPager(pager);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    public static DetalleHabitacion getOne (Habitacion h) {
        DetalleHabitacion da = new DetalleHabitacion();
        da.habitacion = h;
        return da;
    }
}
