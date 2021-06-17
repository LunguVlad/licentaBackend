package licenta.backend.daos;

import licenta.backend.models.ListaPlata;
import licenta.backend.models.Plata;
import licenta.backend.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PlataDao extends CrudRepository<Plata,Integer> {
    Plata findByListaPlata(ListaPlata listaPlata);
    List<Plata> findAllByUser(User user);
}
