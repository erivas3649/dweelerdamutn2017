package ar.com.dweeler.dweeler.dao;

import java.util.List;

import ar.com.dweeler.dweeler.modelos.Habitacion;
import ar.com.dweeler.dweeler.modelos.Hogar;

/**
 * Created by nemesys on 27/10/17.
 */

public interface HabitacionDAO extends BasicDAO<Habitacion, Integer> {
    List<Habitacion> findAllByHogar(int hogarId);

    boolean insert(Habitacion instance, Hogar hogarInstance);
}
