package ar.com.dweeler.dweeler.dao;

import java.util.List;

import ar.com.dweeler.dweeler.modelos.Actividad;
import ar.com.dweeler.dweeler.modelos.Habitacion;

/**
 * Created by nemesys on 27/10/17.
 */

public interface ActividadDAO extends BasicDAO<Actividad, Integer>{
    List<Actividad> findAllByHabitacion(Integer habitacionId);
    boolean insert(Actividad instance, Habitacion habitacionInstance);
}
