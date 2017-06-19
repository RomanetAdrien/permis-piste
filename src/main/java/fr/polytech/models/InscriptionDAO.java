package fr.polytech.models;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by theo.
 */
public interface InscriptionDAO   extends CrudRepository<Inscription, Long> {

    Iterable<Inscription> findByNumjeu(int numjeu);

    Iterable<Inscription> findByNumapprenant(int numjeu);
}
