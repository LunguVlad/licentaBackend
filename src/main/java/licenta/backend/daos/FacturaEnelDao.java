package licenta.backend.daos;

import licenta.backend.models.Bloc;
import licenta.backend.models.FacturaEnel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FacturaEnelDao extends CrudRepository<FacturaEnel,Integer> {

    FacturaEnel findByLunaAndAn(String luna, String an);
    List<FacturaEnel> findAllByBloc(Bloc bloc);
}
