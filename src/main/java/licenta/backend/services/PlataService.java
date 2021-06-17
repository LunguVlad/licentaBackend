package licenta.backend.services;

import licenta.backend.daos.PlataDao;
import licenta.backend.models.ListaPlata;
import licenta.backend.models.Plata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class PlataService {
    @Autowired
    private PlataDao plataDao;

    public int createPlata(ListaPlata listaPlata){
        Plata plata = new Plata();
        plata.setListaPlata(listaPlata);
        plata.setUser(listaPlata.getUser());
        plata.setSumaPlatita(listaPlata.getTotalPlata());
        plata.setDataPlata(LocalDate.now().toString());
        return 1;
    }
}
