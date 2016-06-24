package fr.polytech.models;

import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

/**
 * Created by John.
 */
@Transactional
public interface JeuDao extends CrudRepository<Jeu, Long> {

    /**
     * This method will find an User instance in the database by its email.
     * Note that this method is not implemented and its working code will be
     * automagically generated from its signature by Spring Data JPA.
     */
    Iterable<Jeu> findAll();
}
