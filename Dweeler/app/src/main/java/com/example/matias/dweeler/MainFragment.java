package com.example.matias.dweeler;

import android.app.Fragment;
import android.app.LocalActivityManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
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
    TabHost tab;
    LinearLayout l1;

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
        Intent intent = new Intent().setClass(getActivity(), HogaresActivity.class);
        tab1.setContent(R.id.tab1);
        tab1.setIndicator("", getResources().getDrawable(R.drawable.home));
        tab1.setContent(intent);
        tab.addTab(tab1);
        TabHost.TabSpec tab2 = tab.newTabSpec("tabHogar");
        tab2.setContent(R.id.tab2);
        tab2.setIndicator("", getResources().getDrawable(R.drawable.campana));
        tab1.setContent(R.id.tab2);
        tab.addTab(tab2);
        tab.setCurrentTab(0);
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        mlam.dispatchResume();
    }
}
