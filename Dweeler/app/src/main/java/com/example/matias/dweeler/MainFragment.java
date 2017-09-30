package com.example.matias.dweeler;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
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
        tab = (TabHost) rootView.findViewById(R.id.main_tab);
        tab.setup();
        TabHost.TabSpec tab1 = tab.newTabSpec("miTab");
        tab1.setContent(R.id.tab1);
        tab1.setIndicator("Hola");
        tab.addTab(tab1);
        l1 = (LinearLayout) rootView.findViewById(R.id.tab1);
    }
}
