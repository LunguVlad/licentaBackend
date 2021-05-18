package licenta.backend.services;

import licenta.backend.daos.ConsumLocatariDao;
import licenta.backend.models.ConsumLocatari;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConsumLocatariService {

    @Autowired
    private ConsumLocatariDao consumLocatariDao;

    public List<ConsumLocatari> getAllConsumuriLocatari() {
        List<ConsumLocatari> consumuriLocatari = new ArrayList<>();
        consumLocatariDao.findAll().forEach(consumLocatari -> consumuriLocatari.add(consumLocatari));
        return consumuriLocatari;
    }


    public int addConsum(ConsumLocatari consumLocatari) {
        consumLocatariDao.save(consumLocatari);
        return 1;
    }
}
