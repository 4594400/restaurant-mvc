package ua.goit.restaurant.model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "warehouse")
public class Warehouse implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    //@Id
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
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

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public Double getQuantity() {
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
                "id=" + id +
                ", ingredient=" + ingredient +
                ", quantity=" + quantity +
                ", measure=" + measure +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Warehouse)) return false;

        Warehouse warehouse = (Warehouse) o;

        if (ingredient != null ? !ingredient.equals(warehouse.ingredient) : warehouse.ingredient != null) return false;
        if (quantity != null ? !quantity.equals(warehouse.quantity) : warehouse.quantity != null) return false;
        return measure == warehouse.measure;

    }

    @Override
    public int hashCode() {
        int result = ingredient != null ? ingredient.hashCode() : 0;
        result = 31 * result + (quantity != null ? quantity.hashCode() : 0);
        result = 31 * result + (measure != null ? measure.hashCode() : 0);
        return result;
    }
}
