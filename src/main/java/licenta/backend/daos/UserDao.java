package licenta.backend.daos;

import licenta.backend.models.Bloc;
import licenta.backend.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface UserDao extends CrudRepository<User,Integer> {
    User findByEmail(String email);
    User findByScaraAndApartament(int scara,int apartament);
    List<User> findByScara(int scara);
    User findByEmailAndPassword(String email,String password);
    User findByApartament(int apartament);
    List<User> findAllByBloc(Bloc bloc);


}
