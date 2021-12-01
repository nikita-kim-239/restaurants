package kim.nikita.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@NamedQueries({

        @NamedQuery(name = "GET_ALL_MENUS", query = "SELECT m FROM Menu m")
})
@Entity
@Table(name = "menus")
public class Menu extends AbstractBaseEntity {

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    @JsonIgnore
    private Restaurant restaurant;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "dish_id", referencedColumnName = "id")
    private Dish dish;

    private Integer price;

    public Menu() {

    }

    public Menu(Integer id, Restaurant restaurant, Dish dish, Integer price) {
        super(id);
        this.restaurant = restaurant;
        this.dish = dish;
        this.price = price;
    }

    public Menu(Restaurant restaurant, Dish dish, Integer price) {

        this.restaurant = restaurant;
        this.dish = dish;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", restaurant=" + restaurant +
                ", dish=" + dish +
                ", price=" + price +
                '}';
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
