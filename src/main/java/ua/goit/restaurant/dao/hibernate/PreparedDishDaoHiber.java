package ua.goit.restaurant.dao.hibernate;


import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;
import ua.goit.restaurant.dao.interfaces.PreparedDishDao;
import ua.goit.restaurant.model.PreparedDish;

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

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
