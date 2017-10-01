package com.example.matias.dweeler;

import android.app.Fragment;
import android.app.LocalActivityManager;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by Matias on 29/09/2017.
 */

public class MainFragment extends Fragment {

    LocalActivityManager mlam;
    ImageView img_perfil;
    TextView txt_nombrePerfil;
    ImageButton btn_notificaciones;
    public static TabHost tab;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        View rootView = getView();
        img_perfil = (ImageView) rootView.findViewById(R.id.img_perfil);
        btn_notificaciones = (ImageButton) rootView.findViewById(R.id.btn_notificaciones);
        txt_nombrePerfil = (TextView) rootView.findViewById(R.id.lbl_nombrePerfil);
        mlam = new LocalActivityManager(getActivity(), false);
        mlam.dispatchCreate(savedInstanceState);
        tab = (TabHost) rootView.findViewById(R.id.main_tab);
        tab.setup(mlam);
        TabHost.TabSpec tab1 = tab.newTabSpec("tabHome");
        Intent intentHogares = new Intent().setClass(getActivity(), HogaresActivity.class);
        tab1.setContent(R.id.tab1);
        tab1.setIndicator("", getResources().getDrawable(R.drawable.home));
        tab1.setContent(intentHogares);
        tab.addTab(tab1);
        tab.getTabWidget().getChildAt(tab.getCurrentTab())
                .setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
        TabHost.TabSpec tab2 = MainFragment.tab.newTabSpec("tabHabitacion");
        Intent intentHabitaciones = new Intent().setClass(getActivity(), HabitacionesActivity.class);
        tab2.setContent(R.id.tab1);
        tab2.setIndicator("Departamento", null);
        tab2.setContent(intentHabitaciones);
        MainFragment.tab.addTab(tab2);
        TabHost.TabSpec tab3 = MainFragment.tab.newTabSpec("tabDispositivos");
        Intent intentDispositivos = new Intent().setClass(getActivity(), DispositivoActivity.class);
        tab3.setContent(R.id.tab3);
        tab3.setIndicator("Comedor", null);
        tab3.setContent(intentDispositivos);
        MainFragment.tab.addTab(tab3);
        tab.setCurrentTab(0);

        tab.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                for (int i = 0; i < tab.getTabWidget().getChildCount(); i++) {
                    tab.getTabWidget().getChildAt(i)
                            .setBackgroundColor(getResources().getColor(R.color.colorAccent)); // unselected
                }
                tab.getTabWidget().getChildAt(tab.getCurrentTab())
                        .setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark)); // selected
            }
        });
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        for(int i=0;i < tab.getTabWidget().getChildCount();i++)
        {
            TextView tv = (TextView) tab.getTabWidget().getChildAt(i).findViewById(android.R.id.title);
            tv.setTextColor(getResources().getColor(R.color.colorWhite));
        }
        mlam.dispatchResume();
    }
}
