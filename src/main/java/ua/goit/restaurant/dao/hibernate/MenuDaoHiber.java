package ua.goit.restaurant.dao.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ua.goit.restaurant.dao.interfaces.MenuDao;
import ua.goit.restaurant.model.Dish;
import ua.goit.restaurant.model.Menu;

import javax.persistence.TypedQuery;
import java.util.ArrayList;
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

    /*@Override
    @Transactional
    public Menu load(Long id) {
        Menu result = (Menu) sessionFactory.getCurrentSession().get(Menu.class, id);
        if(result==null) {
            throw new RuntimeException("Cannot find Menu by id = " + id);
        }
        return result;
    }*/

    @Override
    @Transactional
    public Menu load(Long id) {
        Query query = sessionFactory.getCurrentSession().createQuery("select m from Menu m where m.id = :id");
        query.setParameter("id", id);
        Menu result = (Menu) query.uniqueResult();
        if(result==null) {
            throw new RuntimeException("Cannot find Menu by id = " + id);
        }
        return result;
    }

    @Override
    @Transactional
    public Menu findByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select m from Menu m where m.name = :name");
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
    public List<Dish> findAllDishByMenuId(Long id) {
        TypedQuery query = sessionFactory.getCurrentSession().createQuery(
                "from Menu m JOIN m.dishes d WHERE m.id=:idMenu", Dish.class);
        query.setParameter("idMenu", id);
        List<Dish> result = query.getResultList();

        return result;

    }

    @Override
    @Transactional
    public void addDishToMenu(Menu menu, Dish dish) {
        if (!menu.getDishes().contains(dish)){
            menu.getDishes().add(dish);
            sessionFactory.getCurrentSession().saveOrUpdate(menu);
        } else {
            throw new RuntimeException("Dish already exist in menu = " + menu.getName());
        }


    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
