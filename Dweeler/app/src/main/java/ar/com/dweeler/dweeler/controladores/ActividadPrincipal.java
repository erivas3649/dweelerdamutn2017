package ar.com.dweeler.dweeler.controladores;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import ar.com.dweeler.dweeler.R;
import ar.com.dweeler.dweeler.modelos.Habitacion;
import ar.com.dweeler.dweeler.modelos.Hogar;
import ar.com.dweeler.dweeler.vistas.DetalleHabitacion;
import ar.com.dweeler.dweeler.vistas.ListadoActividades;
import ar.com.dweeler.dweeler.vistas.ListadoDispositivos;
import ar.com.dweeler.dweeler.vistas.ListadoHabitaciones;
import ar.com.dweeler.dweeler.vistas.ListadoHogares;
import ar.com.dweeler.dweeler.vistas.ListadoIntegrantes;

public class ActividadPrincipal extends AppCompatActivity implements ListadoHogares.ListadoHogaresListener, ListadoHabitaciones.ListadoHabitacionesListener {

    private Hogar hogar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad_principal);
        findViewById(R.id.imgImagenUsuario).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mostrarPerfil();
            }
        });
        findViewById(R.id.txtNombreUsuario).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mostrarPerfil();
            }
        });
        findViewById(R.id.btnNotificaciones).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mostrarNotificaciones();
            }
        });
        findViewById(R.id.lblTitulo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mostrarHogares();
            }
        });
        findViewById(R.id.btnHogares).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mostrarHogares();
            }
        });
        findViewById(R.id.btnDispositivos).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceMainFragment(ListadoDispositivos.getOne(hogar), false);
            }
        });
        findViewById(R.id.btnIntegrantes).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceMainFragment(ListadoIntegrantes.getOne(hogar), false);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        mostrarHogares();
    }

    @Override
    public void onHogarSelected(Hogar h) {
        hogar = h;
        findViewById(R.id.barraPrincipal).setVisibility(View.VISIBLE);
        TextView titulo = (TextView) findViewById(R.id.lblTitulo);
        titulo.setText(hogar.getNombre());
        replaceMainFragment(ListadoHabitaciones.getOne(h), true);
    }

    @Override
    public void onHabitacionSelected(Habitacion h) {
        replaceMainFragment(DetalleHabitacion.getOne(h), true);
    }

    private void mostrarHogares() {
        findViewById(R.id.barraPrincipal).setVisibility(View.GONE);
        replaceMainFragment(ListadoHogares.getOne(), false);
    }

    private void mostrarNotificaciones () {
        Intent i = new Intent(ActividadPrincipal.this, ActividadNotificaciones.class);
        startActivity(i);
    }

    private void mostrarPerfil () {
        Intent i = new Intent(ActividadPrincipal.this, ActividadPerfilUsuario.class);
        startActivity(i);
    }

    private void replaceMainFragment(Fragment f, boolean keepOnStack) {
        FragmentTransaction transaction= getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frgPlaceholder, f);
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        if(keepOnStack) {
            transaction.addToBackStack(null);
        }
        transaction.commit();
    }
}
