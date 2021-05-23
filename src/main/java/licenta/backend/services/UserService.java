package licenta.backend.services;


import licenta.backend.daos.UserDao;
import licenta.backend.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public int createUser(User user) {
        userDao.save(user);
        return 1;
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        userDao.findAll().forEach(user -> users.add(user));

        return users;
    }

    public User getUserByEmail(String email) {
        User user = userDao.findByEmail(email);
        if(user!=null){
            return user;
        }else{
            throw new NullPointerException();
        }
    }

    public User getUserByScaraAndApartament(int scara, int apartament) {
        User user = userDao.findByScaraAndApartament(scara,apartament);
        if(user!=null){
            return user;
        }else{
            throw new NullPointerException();
        }
    }

    public int updateUser(String email, User updatedUser) {

        //TODO validations for all fields
        User userToChange = userDao.findByEmail(email);

        userToChange.setFirstName(updatedUser.getFirstName());
        userDao.save(userToChange);

        return 1;
    }

    public List<User> getUsersByScara(int scara) {
        System.out.println("USERSERVICE");
        return userDao.findByScara(scara);
    }

    public User getUserByAccount(String email, String password) {
        User user  = userDao.findByEmailAndPassword(email,password);
        System.out.println(user);
        return user;
    }

    public User getUserById(Integer userId) {
        Optional<User> user = userDao.findById(userId);
        if(user.isPresent()){
            return user.get();
        }
        return null;
    }

    public User getUserByApartament(Integer apartament){
        User user = userDao.findByApartament(apartament);
        return user;
    }
}
