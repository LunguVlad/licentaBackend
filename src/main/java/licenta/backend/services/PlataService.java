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
    @Autowired
    private ListPlataService listPlataService;

    public int createPlata(int listaPlataId){
        Plata plata = new Plata();
        ListaPlata listaPlata = listPlataService.getListaPlataById(listaPlataId);
        plata.setListaPlata(listaPlata);
        plata.setUser(listaPlata.getUser());
        plata.setSumaPlatita(listaPlata.getTotalPlata());
        plata.setDataPlata(LocalDate.now().toString());
        plataDao.save(plata);
        return 1;
    }

    public Plata getPlataByListaPlata(int idListaPlata){
       return plataDao.findByListaPlata(listPlataService.getListaPlataById(idListaPlata));
    }
}
