package licenta.backend.daos;

import licenta.backend.models.Bloc;
import licenta.backend.models.FacturaSuez;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.jsf.FacesContextUtils;

import java.util.List;

public interface FacturaSuezDao extends CrudRepository<FacturaSuez,Integer> {
    FacturaSuez findByLunaAndAn(String luna, String an);
    List<FacturaSuez> findAllByBloc(Bloc bloc);
}
