package fr.polytech.models;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by hagoterio on 19/06/17.
 */
public interface FixeDAO  extends CrudRepository<Fixe, Long> {


    Iterable<Fixe> findByNummission(int nummission);

}
