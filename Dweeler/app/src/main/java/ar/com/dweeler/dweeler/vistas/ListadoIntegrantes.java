package ar.com.dweeler.dweeler.vistas;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import ar.com.dweeler.dweeler.R;
import ar.com.dweeler.dweeler.adaptadores.IntegrantesAdapter;
import ar.com.dweeler.dweeler.modelos.Hogar;
import ar.com.dweeler.dweeler.modelos.Integrante;

public class ListadoIntegrantes extends ListFragment {

    private IntegrantesAdapter adapter;
    private Hogar hogar;

    public ListadoIntegrantes() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragmento_listado_integrantes, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ArrayList<Integrante> integrantes = new ArrayList<>();
        integrantes.add(new Integrante("Eric Rivas", "erivas@dweeler.com", R.drawable.usuario1));
        integrantes.add(new Integrante("Matias Pavan", "matias@dweeler.com", R.drawable.usuario2));
        adapter = new IntegrantesAdapter(getContext(), integrantes);
        setListAdapter(adapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {

    }

    public static ListadoIntegrantes getOne (Hogar h) {
        ListadoIntegrantes li = new ListadoIntegrantes();
        li.hogar = h;
        return li;
    }

}
