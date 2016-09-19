package ua.goit.restaurant.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Cook extends Employee{

    @JsonIgnore
    @OneToMany
    @JoinColumn(name = "employeeId")
    private List<PreparedDish> preparedDishes;

    public List<PreparedDish> getPreparedDishes() {
        return preparedDishes;
    }

    public void setPreparedDishes(List<PreparedDish> preparedDishes) {
        this.preparedDishes = preparedDishes;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Waiter {\n");
        sb.append("   id = ").append(getId()).append("\n");
        sb.append("   name = ").append(getName()).append("\n");
        sb.append("   surname = ").append(getSurname()).append("\n");
        sb.append("   birthday = ").append(getBirthday()).append("\n");
        sb.append("   phone number = ").append(getPhoneNumber()).append("\n");
        sb.append("   position = ").append(getPosition()).append("\n");
        sb.append("   salary = ").append(getSalary()).append("\n");
        sb.append("         orders = {\n");
        preparedDishes.forEach(order -> sb.append("    ").append(order).append("\n"));
        sb.append("    }\n");
        sb.append(" }\n");



        return sb.toString();
    }
}
