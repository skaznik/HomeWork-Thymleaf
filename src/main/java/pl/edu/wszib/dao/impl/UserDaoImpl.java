package pl.edu.wszib.dao.impl;

import org.springframework.stereotype.Repository;
import pl.edu.wszib.dao.UserDao;
import pl.edu.wszib.domain.Product;
import pl.edu.wszib.domain.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Repository
public class UserDaoImpl implements UserDao {

    private Map<Long, User> usertMap;
    private static Long id = 1L;

    public UserDaoImpl() {
        this.usertMap = new HashMap<>();
        prepareUsersList();
    }


    @Override
    public List<User> getUsers() {
        return new ArrayList<>(usertMap.values());
    }

    @Override
    public void saveUser(User user) {
        if(user.getId()<1){
            user.setId(id);
            id++;
        }
        usertMap.put(user.getId(),user);
    }

    @Override
    public void removeUser(Long id) {
    usertMap.remove(id);
    }

    @Override
    public User getById(Long id) {
        return usertMap.get(id);
    }


    private void prepareUsersList() {
        User user1 = new User();
        user1.setAge(43);
        user1.setCountry("Polska");
        user1.setEmail("skazada@poczta.fm");
        user1.setLogin("skaz76");
        user1.setAvailable(true);
        saveUser(user1);

        User user2 = new User();
        user2.setAge(67);
        user2.setCountry("USA");
        user2.setEmail("b.gates@microsoft.com");
        user2.setLogin("bill67");
        user2.setAvailable(false);
        saveUser(user2);

        User user3 = new User();
        user3.setAge(70);
        user3.setCountry("Columbia");
        user3.setEmail("papadu@jakiś. tam");
        user3.setLogin("papadumeka");
        user3.setAvailable(true);
        saveUser(user3);
    }
}
