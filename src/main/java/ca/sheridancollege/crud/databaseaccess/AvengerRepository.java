package ca.sheridancollege.crud.databaseaccess;

import ca.sheridancollege.crud.Beans.Avenger;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AvengerRepository extends CrudRepository<Avenger, Long> {
    // This is the create operation or an insert query
    public Avenger save(Avenger entity);

    // SELECT * FROM AVENGERS where ID = :id
    public Optional<Avenger> findById(Long id);

    // SELECT * FROM AVENGERS
    public List<Avenger> findAll();

    // DELETE from AVENGERS where ID = :id
    public void deleteById(Long id);

}
