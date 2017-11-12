package ar.com.dweeler.dweeler.dao;

import java.util.List;

import ar.com.dweeler.dweeler.modelos.Dispositivo;
import ar.com.dweeler.dweeler.modelos.Hogar;

/**
 * Created by nemesys on 27/10/17.
 */

public interface DispositivoDAO extends BasicDAO<Dispositivo, Integer> {
    List<Dispositivo> findAllByHogar(Integer hogarId);
    List<Dispositivo> findAllByHabitacion(Integer habitacionId);
}
