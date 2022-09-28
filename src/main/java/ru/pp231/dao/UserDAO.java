package ru.pp231.dao;

import org.springframework.stereotype.Component;
import ru.pp231.models.User;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Vladimir Chugunov
 */
@Component
public class UserDAO {
    private static int PEOPLE_COUNT;
    private List<User> people;

    {
        people = new ArrayList<>();

        people.add(new User(++PEOPLE_COUNT, "Tom", 33));
        people.add(new User(++PEOPLE_COUNT, "Bob", 45));
        people.add(new User(++PEOPLE_COUNT, "Mike", 66));
        people.add(new User(++PEOPLE_COUNT, "Katy", 23));
    }

    public List<User> index() {
        return people;
    }

    public User show(int id) {
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void save(User user) {
        user.setId(++PEOPLE_COUNT);
        people.add(user);
    }

    public void delete(int id) {
        people.removeIf(p -> p.getId() == id);
    }

    public void update(int id, User updatedUser) {
        User userToBeUpdated = show(id);
        userToBeUpdated.setName(updatedUser.getName());
        userToBeUpdated.setAge(updatedUser.getAge());
    }
}
