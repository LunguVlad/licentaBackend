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

    public List<ConsumContorizat> getAllConsumuriContorizate() {
        List<ConsumContorizat> consumuriContorizate = new ArrayList<>();
        consumContorizatDao.findAll().forEach(consumuriContorizate::add);

        return consumuriContorizate;
    }

    public int addConsum(ConsumContorizat consum) {
        consumContorizatDao.save(consum);
        return 1;
    }
}
