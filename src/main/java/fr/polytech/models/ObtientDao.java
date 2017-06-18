package fr.polytech.models;

        import org.springframework.data.repository.CrudRepository;

        import javax.transaction.Transactional;
/**
 * Created by Quentin
 */
@Transactional
public interface ObtientDao  extends CrudRepository<Obtient, Long> {
    /**
     * This method will find all the Obtient instances.
     * Note that this method is not implemented and its working code will be
     * automagically generated from its signature by Spring Data JPA.
     */

    Iterable<Obtient> findAll();
}