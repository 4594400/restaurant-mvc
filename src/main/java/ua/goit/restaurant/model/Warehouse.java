package ua.goit.restaurant.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "warehouse")
public class Warehouse implements Serializable{


    @Id
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ingredientId")
    private Ingredient ingredient;

    @Column(name = "quantity")
    private Double quantity;

    @Column(name = "measure")
    @Enumerated(EnumType.STRING)
    private Measure measure;

    public Warehouse() {
    }

    public Warehouse(Double quantity, Measure measure, Ingredient ingredient) {
        this.quantity = quantity;
        this.measure = measure;
        this.ingredient = ingredient;
    }



    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public Double getQuantity(int i) {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Measure getMeasure() {
        return measure;
    }

    public void setMeasure(Measure measure) {
        this.measure = measure;
    }

    @Override
    public String toString() {
        return "Warehouse{" +
                ", quantity=" + quantity +
                ", measure=" + measure +
                ", ingredient=" + ingredient +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Warehouse)) return false;

        Warehouse warehouse = (Warehouse) o;

        if (quantity != null ? !quantity.equals(warehouse.quantity) : warehouse.quantity != null) return false;
        if (measure != warehouse.measure) return false;
        return ingredient != null ? ingredient.equals(warehouse.ingredient) : warehouse.ingredient == null;

    }

    @Override
    public int hashCode() {
        int result = quantity != null ? quantity.hashCode() : 0;
        result = 31 * result + (measure != null ? measure.hashCode() : 0);
        result = 31 * result + (ingredient != null ? ingredient.hashCode() : 0);
        return result;
    }
}
