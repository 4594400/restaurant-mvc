package ua.goit.restaurant.dao.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;
import ua.goit.restaurant.dao.interfaces.IngredientDao;
import ua.goit.restaurant.model.Ingredient;

import java.util.List;


public class IngredientDaoHiber implements IngredientDao {

    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public void save(Ingredient ingredient) {
        sessionFactory.getCurrentSession().saveOrUpdate(ingredient);
    }

    @Override
    @Transactional
    public void remove(Ingredient ingredient) {
        sessionFactory.getCurrentSession().delete(ingredient);

    }

    @Override
    @Transactional
    public void removeAll() {
        sessionFactory.getCurrentSession().createQuery("delete from Ingredient").executeUpdate();

    }

    @Override
    @Transactional
    public Ingredient load(Long id) {
        Ingredient result = sessionFactory.getCurrentSession().get(Ingredient.class, id);
        if (result == null) {
            throw new RuntimeException("Cannot find Ingredient by id = " + id);
        }
        return result;
    }

    @Override
    @Transactional
    public Ingredient findByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select i from Ingredient i where i.name like :name");
        query.setParameter("name", name);

        return (Ingredient) query.uniqueResult();
    }

    @Override
    @Transactional
    public List<Ingredient> findAll() {
        return sessionFactory.getCurrentSession().createQuery("select i from Ingredient i").list();
    }


    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
