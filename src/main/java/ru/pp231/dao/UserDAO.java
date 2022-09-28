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

        people.add(new User(++PEOPLE_COUNT, "Tom"));
        people.add(new User(++PEOPLE_COUNT, "Bob"));
        people.add(new User(++PEOPLE_COUNT, "Mike"));
        people.add(new User(++PEOPLE_COUNT, "Katy"));
    }

    public List<User> index() {
        return people;
    }

    public User show(int id) {
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void save(User person) {
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }
}
