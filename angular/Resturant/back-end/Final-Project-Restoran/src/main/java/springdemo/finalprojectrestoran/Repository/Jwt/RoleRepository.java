package springdemo.finalprojectrestoran.Repository.Jwt;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import springdemo.finalprojectrestoran.model.ClientModels.Role;

@Repository
public interface RoleRepository  extends JpaRepository<Role, Long> {
    Role findByCode(String code);

}
