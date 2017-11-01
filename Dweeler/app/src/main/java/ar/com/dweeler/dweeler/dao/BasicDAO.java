package ar.com.dweeler.dweeler.dao;

import java.util.List;

/**
 * Created by nemesys on 27/10/17.
 */

public interface BasicDAO<E, K> {
    List<E> findAll ();
    E findOne (K id);
    boolean insert (E instance);
    boolean update (E instance);
    boolean remove (E instance);
}
