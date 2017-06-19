package fr.polytech.models;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by theo.
 */
public interface FixeDAO  extends CrudRepository<Fixe, Long> {


    Iterable<Fixe> findByNummission(int nummission);

}
