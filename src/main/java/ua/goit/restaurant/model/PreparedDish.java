package ua.goit.restaurant.model;


import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "prepared_dishes")
public class PreparedDish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "dishId")
    private Dish dish;

    @Column
    @Type(type = "date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date preparingDate;

    @OneToOne
    @JoinColumn(name = "employeeId")
    private Employee cooker;

    public PreparedDish() {
    }

    public PreparedDish(Dish dish, Date date, Employee cooker) {
        this.dish = dish;
        this.preparingDate = date;
        this.cooker = cooker;
    }

    ///////////////////////////////
    public boolean isNew() {
        return (this.id == null);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    public Date getPreparingDate() {
        return preparingDate;
    }

    public void setPreparingDate(Date preparingDate) {
        this.preparingDate = preparingDate;
    }

    public Employee getCooker() {
        return cooker;
    }

    public void setCooker(Employee cooker) {
        this.cooker = cooker;
    }

    @Override
    public String toString() {
        return "PreparedDish{" +
                "id=" + id +
                ", dish=" + dish +
                ", preparingDate=" + preparingDate +
                ", cooker=" + cooker +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PreparedDish)) return false;

        PreparedDish that = (PreparedDish) o;

        if (dish != null ? !dish.equals(that.dish) : that.dish != null) return false;
        if (preparingDate != null ? !preparingDate.equals(that.preparingDate) : that.preparingDate != null)
            return false;
        return cooker != null ? cooker.equals(that.cooker) : that.cooker == null;

    }

    @Override
    public int hashCode() {
        int result = dish != null ? dish.hashCode() : 0;
        result = 31 * result + (preparingDate != null ? preparingDate.hashCode() : 0);
        result = 31 * result + (cooker != null ? cooker.hashCode() : 0);
        return result;
    }
}
