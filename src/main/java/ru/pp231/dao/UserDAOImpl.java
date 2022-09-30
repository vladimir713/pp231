package ru.pp231.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.pp231.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Component
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    public UserDAOImpl(@Qualifier("entityManager") EntityManager em) {
        this.em = em;
    }

    @Override
    public List<User> index() {
        return em.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public void save(User user) {
        em.persist(user);
    }

    @Override
    public void delete(int id) {
        User user = show(id);
        em.remove(user);
    }

    @Override
    public User show(int id) {
        TypedQuery<User> q = em.createQuery(
                "select u from User u where u.id = :id", User.class);
        return q.getSingleResult();
    }

    @Override
    public void update(int id, User updUser) {
        User user = show(id);
        user.setName(updUser.getName());
        user.setAge(updUser.getAge());
        em.merge(user);
    }
}
