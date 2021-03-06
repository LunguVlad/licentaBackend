package licenta.backend.services;

import licenta.backend.daos.ConsumContorizatDao;
import licenta.backend.models.ConsumContorizat;
import licenta.backend.models.FacturaApaNova;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConsumContorizatService {
    @Autowired
    private ConsumContorizatDao consumContorizatDao;
    @Autowired
    private BlocService blocService;

    public List<ConsumContorizat> getAllConsumuriContorizate(int numarBloc) {
        return consumContorizatDao.findAllByBloc(blocService.getBloc(numarBloc));
    }

    public int addConsum(ConsumContorizat consum, int numarBloc) {
        consum.setBloc( blocService.getBloc(numarBloc));
        consumContorizatDao.save(consum);
        return 1;
    }
}
