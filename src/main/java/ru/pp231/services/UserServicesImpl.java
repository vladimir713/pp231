package ru.pp231.services;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.pp231.dao.UserDAO;
import ru.pp231.models.User;

import javax.transaction.Transactional;
import java.util.List;

@Component
public class UserServicesImpl implements UserService {

    private final UserDAO userDAO;
    public UserServicesImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Transactional
    @Override
    public List<User> index() {
        return userDAO.index();
    }

    @Transactional
    @Override
    public void save(User user) {
        userDAO.save(user);
    }

    @Override
    @Transactional
    public void delete(int id) {
        userDAO.delete(id);
    }

    @Override
    @Transactional
    public User show(int id) {
        return show(id);
    }

    @Override
    @Transactional
    public void update(int id, User user) {
        userDAO.update(id, user);
    }

}
