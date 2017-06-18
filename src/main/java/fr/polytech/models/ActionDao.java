package fr.polytech.models;

import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

/**
 * Created by Adrien.
 */

@Transactional
public interface ActionDao extends CrudRepository<Action,Long> {


    Iterable<Action> findAll();
    Action findBynumaction(int numaction);
}
