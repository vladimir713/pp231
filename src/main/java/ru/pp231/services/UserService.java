package ru.pp231.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.pp231.models.User;
import ru.pp231.models.UserRepository;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserService {

    @Autowired
    UserRepository repo;

    public List<User> index() {
        return (List<User>) repo.findAll();
    }

    public void save(User user) {
        repo.save(user);
    }

    public void delete(int id) {
        repo.delete(id);
    }

    public User show(int id) {
        return repo.findOne(id);
    }

   public void update(int id, User user) {
        repo.save(user);
    }

}
