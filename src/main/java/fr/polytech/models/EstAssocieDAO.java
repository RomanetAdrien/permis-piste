package fr.polytech.models;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by theo.
 */
public interface EstAssocieDAO extends CrudRepository<EstAssocie, Long> {


    Iterable<EstAssocie> findByNumaction(int numaction);

}