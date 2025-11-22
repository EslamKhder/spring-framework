package springdemo.finalprojectrestoran.Repository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import springdemo.finalprojectrestoran.model.Product;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
Page<Product> findAllByCategoryId(Long id, Pageable pageable);
List<Product> findByName(String name);

@Query(value = "SELECT * FROM Product WHERE LOWER(name) LIKE '%' || LOWER(:val) || '%' OR LOWER(description) LIKE '%' || LOWER(:val) || '%'", nativeQuery = true)
Page<Product> getProductByLetters(@Param("val") String letters, Pageable pageable);

@Query(value = "SELECT count(id) from Product", nativeQuery = true)
int findProductSize();
@Query(value = "SELECT count(id) from Product where category.id = ?1")
int findProductSizeByCategoryId(Long id);

@Query(value = "SELECT count(id) from Product WHERE LOWER(name) LIKE '%' || LOWER(:val) || '%' OR LOWER(description) LIKE '%' || LOWER(:val) || '%'", nativeQuery = true)
int findProductSizeByKey( @Param("val") String value);


}
