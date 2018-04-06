package at.refugeescode.mp12_fakebook.persistent;

import at.refugeescode.mp12_fakebook.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PersonRepository extends JpaRepository<Person, Long> {
}
