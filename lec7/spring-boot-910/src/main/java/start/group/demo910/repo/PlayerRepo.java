package start.group.demo910.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import start.group.demo910.model.Player;

@Repository
public interface PlayerRepo extends JpaRepository<Player, Long> {

}
