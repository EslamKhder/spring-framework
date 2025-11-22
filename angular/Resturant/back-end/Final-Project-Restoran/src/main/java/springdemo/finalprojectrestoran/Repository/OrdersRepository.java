package springdemo.finalprojectrestoran.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springdemo.finalprojectrestoran.model.Orders;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long> {
}
