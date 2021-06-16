package licenta.backend.daos;

import licenta.backend.models.Bloc;
import licenta.backend.models.FacturaApaNova;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FacturaApaNovaDao extends CrudRepository<FacturaApaNova,Integer> {

    FacturaApaNova findByLunaAndAn(String luna, String an);
    List<FacturaApaNova> findAllByBloc(Bloc bloc);
}
