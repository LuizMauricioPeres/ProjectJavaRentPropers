package ga.barru.seu_barriga.repository;

import ga.barru.seu_barriga.model.People;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeopleRepository extends JpaRepository<People, Long> {

}
