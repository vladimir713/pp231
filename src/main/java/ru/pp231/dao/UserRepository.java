package ru.pp231.dao;

import org.springframework.data.repository.CrudRepository;
import ru.pp231.models.User;

public interface UserRepository extends CrudRepository<User, Integer> {

}