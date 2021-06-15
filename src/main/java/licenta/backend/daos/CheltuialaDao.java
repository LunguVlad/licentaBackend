package licenta.backend.daos;

import licenta.backend.models.Bloc;
import licenta.backend.models.Cheltuiala;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CheltuialaDao extends CrudRepository<Cheltuiala,Integer> {
    List<Cheltuiala> findAllByBloc(Bloc bloc);
}
