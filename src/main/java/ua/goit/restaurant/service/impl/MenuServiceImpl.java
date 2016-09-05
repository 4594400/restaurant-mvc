package ua.goit.restaurant.service.impl;

import org.springframework.transaction.annotation.Transactional;
import ua.goit.restaurant.dao.interfaces.MenuDao;
import ua.goit.restaurant.model.Dish;
import ua.goit.restaurant.model.Menu;
import ua.goit.restaurant.service.interfaces.MenuService;

import java.util.List;

public class MenuServiceImpl implements MenuService {

    private MenuDao menuDao;

    @Override
    @Transactional
    public void save(Menu menu) {
        menuDao.save(menu);
    }

    @Override
    @Transactional
    public void remove(Menu menu) {
        menuDao.remove(menu);

    }

    @Override
    @Transactional
    public void removeAll() {
        menuDao.removeAll();
    }

    @Override
    @Transactional
    public Menu load(Long id) {
        return menuDao.load(id);
    }

    @Override
    @Transactional
    public Menu findByName(String name) {
        return menuDao.findByName(name);
    }

    @Override
    @Transactional
    public List<Menu> findAll() {
        return menuDao.findAll();
    }

    @Override
    @Transactional
    public List<Dish> findAllDishByMenuId(Long id) {
        return menuDao.findAllDishByMenuId(id);
    }

    @Override
    @Transactional
    public void addDishToMenu(Menu menu, Dish dish) {
        menuDao.addDishToMenu(menu, dish);
    }


    public void setMenuDao(MenuDao menuDao) {
        this.menuDao = menuDao;
    }
}
