package licenta.backend.services;

import licenta.backend.daos.CheltuialaDao;
import licenta.backend.models.Bloc;
import licenta.backend.models.Cheltuiala;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CheltuialaService {
    @Autowired
    private CheltuialaDao cheltuialaDao;

    @Autowired
    private BlocService blocService;

    public List<Cheltuiala> getAllCheltuieli(int numarBloc) {
        Bloc bloc =blocService.getBloc(numarBloc);
        return cheltuialaDao.findAllByBloc(bloc);
    }

    public int addCheltuiala(Cheltuiala cheltuiala, int numarBloc) {
        Bloc bloc =blocService.getBloc(numarBloc);
        cheltuiala.setBloc(bloc);
        if(cheltuiala.getLuna() == null || cheltuiala.getAn() == null){
            cheltuiala.setLuna(String.valueOf(LocalDate.now().minusMonths(1).getMonthValue()));
            cheltuiala.setAn(String.valueOf(LocalDate.now().minusMonths(1).getYear()));
        }
        cheltuialaDao.save(cheltuiala);
        return 1;
    }
}
