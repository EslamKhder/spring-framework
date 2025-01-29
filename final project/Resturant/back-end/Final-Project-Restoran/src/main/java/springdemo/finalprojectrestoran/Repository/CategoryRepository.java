package springdemo.finalprojectrestoran.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springdemo.finalprojectrestoran.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
