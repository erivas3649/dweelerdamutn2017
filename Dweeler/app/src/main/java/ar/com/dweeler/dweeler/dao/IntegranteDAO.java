package ar.com.dweeler.dweeler.dao;

import java.util.List;

import ar.com.dweeler.dweeler.modelos.Hogar;
import ar.com.dweeler.dweeler.modelos.Integrante;

/**
 * Created by nemesys on 27/10/17.
 */

public interface IntegranteDAO extends BasicDAO<Integrante, Integer> {
    List<Integrante> findAllByHogar(Integer hogarId);
    boolean insert(Integrante instance, Hogar hogarInstance);
}
