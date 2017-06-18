package fr.polytech.models;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by hagoterio on 19/06/17.
 */
public interface InscriptionDAO   extends CrudRepository<Inscription, Long> {

    Iterable<Inscription> findByNumjeu(int numjeu);
}
