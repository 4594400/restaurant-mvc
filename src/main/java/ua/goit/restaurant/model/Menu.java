package ua.goit.restaurant.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "menus")
public class Menu {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name")
    private String name;

    ////////////////////////////////
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "menus_to_dishes",
            joinColumns = {@JoinColumn (name = "menuId")},
            inverseJoinColumns = {@JoinColumn (name = "dishId")}
            )
    private List<Dish> dishes;

    public Menu() {
    }

    public Menu(String name, List<Dish> dishes) {
        this.name = name;
        this.dishes = dishes;
    }
////////////////////////////////
    @JsonIgnore
    public boolean isNew() {
        return (this.id == null);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dishes=" + dishes +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Menu)) return false;

        Menu menu = (Menu) o;

        if (name != null ? !name.equals(menu.name) : menu.name != null) return false;
        return dishes != null ? dishes.equals(menu.dishes) : menu.dishes == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (dishes != null ? dishes.hashCode() : 0);
        return result;
    }
}
