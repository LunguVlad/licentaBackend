package licenta.backend.daos;

import licenta.backend.models.Bloc;
import licenta.backend.models.ListaPlata;
import licenta.backend.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ListaPlataDao extends CrudRepository<ListaPlata, Integer> {
    ListaPlata findByUserAndLunaAndAn(User user,String luna, String an);
    List<ListaPlata> findByLunaAndAn(String luna,String an);
}
