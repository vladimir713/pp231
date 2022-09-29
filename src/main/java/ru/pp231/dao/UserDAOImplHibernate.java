package ru.pp231.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import ru.pp231.models.User;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class UserDAOImplHibernate implements UserDAO {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    //@Transactional
    @Override
    public List<User> index() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from User").list();
    }

    //@Transactional
    @Override
    public void save(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(user);
    }

    @Override
    //@Transactional
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(session.get(User.class, id));
    }

    @Override
    //@Transactional
    public User show(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(User.class, id);
    }

    @Override
    //@Transactional
    public void update(int id, User user) {
        Session session = sessionFactory.getCurrentSession();
        session.update(user);
    }
}
