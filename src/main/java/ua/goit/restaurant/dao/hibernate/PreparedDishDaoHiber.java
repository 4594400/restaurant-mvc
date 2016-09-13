package ua.goit.restaurant.dao.hibernate;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;
import ua.goit.restaurant.dao.interfaces.PreparedDishDao;
import ua.goit.restaurant.model.PreparedDish;

import java.util.List;

public class PreparedDishDaoHiber implements PreparedDishDao {
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public void save(PreparedDish preparedDish) {
        sessionFactory.getCurrentSession().saveOrUpdate(preparedDish);
    }



    @Override
    @Transactional
    public void remove(PreparedDish preparedDish) {
        sessionFactory.getCurrentSession().delete(preparedDish);

    }


    @Override
    @Transactional
    public PreparedDish load(Long id) {
        return sessionFactory.getCurrentSession().get(PreparedDish.class, id);
    }

    @Override
    @Transactional
    public List<PreparedDish> findByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select p from PreparedDish p where p.dish.name like :name");
        query.setParameter("name", name);
        return query.list();
    }

    @Override
    @Transactional
    public List<PreparedDish> findAll() {
        return sessionFactory.getCurrentSession().createQuery("select p from PreparedDish p").list();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
