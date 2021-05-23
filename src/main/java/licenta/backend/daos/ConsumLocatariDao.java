package licenta.backend.daos;

import licenta.backend.models.ConsumLocatari;
import licenta.backend.models.User;
import org.springframework.data.repository.CrudRepository;

public interface ConsumLocatariDao extends CrudRepository<ConsumLocatari,Integer> {
    ConsumLocatari findByLunaAndAnAndApartament(String luna, String an, Integer apartament);
}
