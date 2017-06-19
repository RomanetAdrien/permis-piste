package fr.polytech.models;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by hagoterio on 19/06/17.
 */
public interface IndicateurDAO  extends CrudRepository<Indicateur,Long> {

    Iterable<Indicateur> findByNumaction(Integer numaction);
}
