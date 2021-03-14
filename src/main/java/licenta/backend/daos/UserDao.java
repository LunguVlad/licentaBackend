package licenta.backend.daos;

import licenta.backend.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface UserDao extends CrudRepository<User,Integer> {
    User findByEmail(String email);
    User findByScaraAndApartament(int scara,int apartament);
}
