package licenta.backend.services;

import licenta.backend.daos.BlocDao;
import licenta.backend.models.Bloc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlocService {
    @Autowired
    private BlocDao blocDao;

    public Bloc getBloc(int numarBloc) {
        return blocDao.findById(numarBloc).get();
    }

    public int addBloc(Bloc bloc) {
        blocDao.save(bloc);
        return 1;
    }
}
