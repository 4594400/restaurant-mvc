package ua.goit.restaurant.dao.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;
import ua.goit.restaurant.dao.interfaces.MenuDao;
import ua.goit.restaurant.model.Dish;
import ua.goit.restaurant.model.Menu;

import java.util.List;


public class MenuDaoHiber implements MenuDao {
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public void save(Menu menu) {
        sessionFactory.getCurrentSession().saveOrUpdate(menu);
    }

    @Override
    @Transactional
    public void remove(Menu menu) {
        sessionFactory.getCurrentSession().delete(menu);

    }

    @Override
    @Transactional
    public void removeAll() {
        sessionFactory.getCurrentSession().createQuery("delete from Menu").executeUpdate();

    }

    @Override
    @Transactional
    public Menu load(Long id) {
        Menu result = sessionFactory.getCurrentSession().get(Menu.class, id);
        if(result==null) {
            throw new RuntimeException("Cannot find Dish by id = " + id);
        }
        return result;
    }

    @Override
    public Menu findByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select m from Menu m where m.name like :name");
        query.setParameter("name", name);
        return (Menu) query.uniqueResult();
    }

    @Override
    @Transactional
    public List<Menu> findAll() {
        return sessionFactory.getCurrentSession().createQuery("select m from Menu m").list();
    }

    @Override
    @Transactional
    public void addDish(Menu menu, Dish dish) {
        //To Realize

    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
