package ru.pp231.dao;

import org.springframework.stereotype.Component;
import ru.pp231.models.User;

import java.util.List;

public interface UserDAO {
    public List<User> index();

    public User show(int id);

    public void save(User user);

    public void delete(int id);

    public void update(int id, User updatedUser);
}
