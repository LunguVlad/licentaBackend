package licenta.backend.daos;

import licenta.backend.models.FacturaRebu;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacturaRebuDao extends CrudRepository<FacturaRebu,Integer> {
}
