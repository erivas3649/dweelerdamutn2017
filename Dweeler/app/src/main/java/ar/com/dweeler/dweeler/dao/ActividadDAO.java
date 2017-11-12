package ar.com.dweeler.dweeler.dao;

import java.util.List;

import ar.com.dweeler.dweeler.modelos.Actividad;

/**
 * Created by nemesys on 27/10/17.
 */

public interface ActividadDAO extends BasicDAO<Actividad, Integer>{
    List<Actividad> findAllByHabitacion(Integer habitacionId);
}
