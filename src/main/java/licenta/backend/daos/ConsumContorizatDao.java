package licenta.backend.daos;

import licenta.backend.models.Bloc;
import licenta.backend.models.ConsumContorizat;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ConsumContorizatDao extends CrudRepository<ConsumContorizat,Integer> {
    List<ConsumContorizat> findAllByBloc(Bloc bloc);
}
