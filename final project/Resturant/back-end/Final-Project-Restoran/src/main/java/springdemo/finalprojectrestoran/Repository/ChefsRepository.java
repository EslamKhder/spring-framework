package springdemo.finalprojectrestoran.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springdemo.finalprojectrestoran.model.Category;
import springdemo.finalprojectrestoran.model.Chefs;

@Repository
public interface ChefsRepository extends JpaRepository<Chefs, Long> {
}
