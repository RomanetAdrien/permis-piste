package fr.polytech.models;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Cyril on 23/06/2016.
 */
@Transactional
public interface JeuDao  extends CrudRepository<User, Long> {

    /**
     * This method will return all games from the database.
     * Note that this method is not implemented and its working code will be
     * automagically generated from its signature by Spring Data JPA.
     */
    Iterable<User> findAll();

}
