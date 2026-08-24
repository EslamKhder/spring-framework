package start.group.demo910.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import start.group.demo910.model.Account;
import start.group.demo910.model.Roles;

import java.util.Optional;

@Repository
public interface RolesRepo extends JpaRepository<Roles, Long> {

}
