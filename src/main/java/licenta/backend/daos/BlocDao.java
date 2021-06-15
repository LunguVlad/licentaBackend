package licenta.backend.daos;

import licenta.backend.models.Bloc;
import org.springframework.data.repository.CrudRepository;

public interface BlocDao extends CrudRepository<Bloc,Integer> {
}
