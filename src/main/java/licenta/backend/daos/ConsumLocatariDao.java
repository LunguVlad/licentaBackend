package licenta.backend.daos;

import licenta.backend.models.ConsumLocatari;
import licenta.backend.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsumLocatariDao extends CrudRepository<ConsumLocatari,Integer> {
    ConsumLocatari findByLunaAndAnAndUser(String luna, String an, User user);
}
