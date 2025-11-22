package springdemo.finalprojectrestoran.Repository.Jwt;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springdemo.finalprojectrestoran.model.ClientModels.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{

    Client findByEmail(String email);

}
