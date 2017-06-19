package fr.polytech.models;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by theo.
 */
public interface IndicateurDAO  extends CrudRepository<Indicateur,Long> {

    Iterable<Indicateur> findByNumaction(Integer numaction);
}
