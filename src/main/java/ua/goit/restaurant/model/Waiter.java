package ua.goit.restaurant.model;


import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Waiter extends Employee {

    @OneToMany
    @JoinColumn(name = "employeeId")
    //@Fetch(FetchMode.JOIN)
    private List<Order> orders;

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
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
        orders.forEach(order -> sb.append("    ").append(order).append("\n"));
        sb.append("    }\n");
        sb.append(" }\n");



        return sb.toString();
    }
}
