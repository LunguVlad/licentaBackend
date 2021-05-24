package licenta.backend.services;

import licenta.backend.daos.ConsumLocatariDao;
import licenta.backend.models.ConsumLocatari;
import licenta.backend.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConsumLocatariService {

    @Autowired
    private ConsumLocatariDao consumLocatariDao;
    @Autowired
    private UserService userService;

    public List<ConsumLocatari> getAllConsumuriLocatari() {
        List<ConsumLocatari> consumuriLocatari = new ArrayList<>();
        consumLocatariDao.findAll().forEach(consumLocatari -> consumuriLocatari.add(consumLocatari));
        return consumuriLocatari;
    }


    public int addConsum(ConsumLocatari consumLocatari, Integer userId) {

        User user = userService.getUserById(userId);

        consumLocatari.setUser(user);

        consumLocatariDao.save(consumLocatari);
        return 1;
    }

    public ConsumLocatari getConsumByLunaAnUser(String luna, String an, User user){
        return consumLocatariDao.findByLunaAndAnAndUser(luna,an,user);
    }
}
