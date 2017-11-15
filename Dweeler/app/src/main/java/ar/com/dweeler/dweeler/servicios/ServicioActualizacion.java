package ar.com.dweeler.dweeler.servicios;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URL;
import java.text.ParseException;
import java.util.logging.Logger;

import ar.com.dweeler.dweeler.dao.ActividadDAO;
import ar.com.dweeler.dweeler.dao.DispositivoDAO;
import ar.com.dweeler.dweeler.dao.HabitacionDAO;
import ar.com.dweeler.dweeler.dao.HogarDAO;
import ar.com.dweeler.dweeler.dao.IntegranteDAO;
import ar.com.dweeler.dweeler.dao.NotificacionDAO;
import ar.com.dweeler.dweeler.daosqlite.ActividadSqliteDAO;
import ar.com.dweeler.dweeler.daosqlite.DispositivoSqliteDAO;
import ar.com.dweeler.dweeler.daosqlite.HabitacionSqliteDAO;
import ar.com.dweeler.dweeler.daosqlite.HogarSqliteDAO;
import ar.com.dweeler.dweeler.daosqlite.IntegranteSqliteDAO;
import ar.com.dweeler.dweeler.daosqlite.NotificacionSqliteDAO;
import ar.com.dweeler.dweeler.modelos.Actividad;
import ar.com.dweeler.dweeler.modelos.Dispositivo;
import ar.com.dweeler.dweeler.modelos.Habitacion;
import ar.com.dweeler.dweeler.modelos.Hogar;
import ar.com.dweeler.dweeler.modelos.Integrante;
import ar.com.dweeler.dweeler.modelos.Notificacion;

/**
 * Created by nemesys on 10/11/17.
 */

public class ServicioActualizacion {

    public interface ActualizacionListener {
        void onActualizado();
    }

    private RequestQueue requestQueue;
    private static ServicioActualizacion instancia;
    private static  final String URL_BASE = "";
    private HogarDAO hogarDAO;
    private HabitacionDAO habitacionDAO;
    private DispositivoDAO dispositivoDAO;
    private ActividadDAO actividadDAO;
    private IntegranteDAO integranteDAO;
    private NotificacionDAO notificacionDAO;

    private  ServicioActualizacion (Context c) {
        requestQueue = Volley.newRequestQueue(c);
        hogarDAO = new HogarSqliteDAO(c);
        habitacionDAO = new HabitacionSqliteDAO(c);
        dispositivoDAO = new DispositivoSqliteDAO(c);
        actividadDAO = new ActividadSqliteDAO(c);
        integranteDAO = new IntegranteSqliteDAO(c);
        notificacionDAO = new NotificacionSqliteDAO(c);
    }

    public void obtenerDatos(final ActualizacionListener listener) {
        String url = "http://planetario.s3-website-sa-east-1.amazonaws.com/dweeler/app/erivas3649/data?appid=f2542f3329a4e90f7b2a8b7d752f327a";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray hogares = response.getJSONArray("hogares");
                    for (int i = 0; i < hogares.length(); i++) {
                        Hogar ho = Hogar.parse(hogares.getJSONObject(i));
                        hogarDAO.insert(ho);
                        JSONArray habitaciones = hogares.getJSONObject(i).getJSONArray("habitaciones");
                        for (int j = 0; j < habitaciones.length(); j++) {
                            Habitacion ha = Habitacion.parse(habitaciones.getJSONObject(j));
                            habitacionDAO.insert(ha, ho);
                            JSONArray dispositivos = habitaciones.getJSONObject(j).getJSONArray("dispositivos");
                            for (int k = 0; k < dispositivos.length(); k++) {
                                Dispositivo di = Dispositivo.parse(dispositivos.getJSONObject(k));
                                dispositivoDAO.insert(di, ha);
                            }
                            JSONArray actividades = habitaciones.getJSONObject(j).getJSONArray("actividades");
                            for (int l = 0; l < actividades.length(); l++) {
                                Actividad ac = Actividad.parse(actividades.getJSONObject(l));
                                actividadDAO.insert(ac, ha);
                            }
                        }
                        JSONArray integrantes = hogares.getJSONObject(i).getJSONArray("integrantes");
                        for (int m = 0; m < integrantes.length(); m++) {
                            Integrante in = Integrante.parse(integrantes.getJSONObject(m));
                            integranteDAO.insert(in, ho);
                        }
                    }
                } catch (JSONException e) {
                    Logger.getLogger(getClass().toString(), e.getMessage());
                }
                listener.onActualizado();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Logger.getLogger(getClass().toString(), error.getMessage());
            }
        }
        );
        requestQueue.add(request);
    }

    public void obtenerNotificaciones(final ActualizacionListener listener) {
        String url = "http://planetario.s3-website-sa-east-1.amazonaws.com/dweeler/app/erivas3649/notificaciones/data?appid=f2542f3329a4e90f7b2a8b7d752f327a";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray notificaciones = response.getJSONArray("notificaciones");
                    for (int i = 0; i < notificaciones.length(); i++) {
                        Notificacion n = Notificacion.parse(notificaciones.getJSONObject(i));
                        notificacionDAO.insert(n);
                    }
                } catch (Exception e) {
                    Logger.getLogger(getClass().toString(), e.getMessage());
                }
                listener.onActualizado();
            }
        },  new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Logger.getLogger(getClass().toString(), error.getMessage());
            }
        });
        requestQueue.add(request);
    }

    public static ServicioActualizacion getInstance (Context c) {
        if(instancia == null) {
            instancia = new ServicioActualizacion(c);
        }
        return instancia;
    }
}
