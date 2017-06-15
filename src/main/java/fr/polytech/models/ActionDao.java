package fr.polytech.models;

import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

/**
 * Created by FloAdmin on 26/06/2016.
 */

@Transactional
public interface ActionDao extends CrudRepository<Action,Long> {


    Iterable<Action> findAll();
    Action findBynumaction(int numaction);
}
