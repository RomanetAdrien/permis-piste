package fr.polytech.models;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by hagoterio on 19/06/17.
 */
public interface EstAssocieDAO extends CrudRepository<EstAssocie, Long> {


    Iterable<EstAssocie> findByNumaction(int numaction);

}