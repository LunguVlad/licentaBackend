package licenta.backend.services;

import licenta.backend.daos.CheltuialaDao;
import licenta.backend.models.Bloc;
import licenta.backend.models.Cheltuiala;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheltuialaService {
    @Autowired
    private CheltuialaDao cheltuialaDao;

    @Autowired
    private BlocService blocService;

    public List<Cheltuiala> getAllConsumuriContorizate(int numarBloc) {
        Bloc bloc =blocService.getBloc(numarBloc);
        return cheltuialaDao.findAllByBloc(bloc);
    }

    public int addCheltuiala(Cheltuiala cheltuiala, int numarBloc) {
        Bloc bloc =blocService.getBloc(numarBloc);
        cheltuiala.setBloc(bloc);
        cheltuialaDao.save(cheltuiala);
        return 1;
    }
}
