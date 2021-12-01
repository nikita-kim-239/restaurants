package kim.nikita.model;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "dishes")
@NamedQueries({

        @NamedQuery(name = "GET_ALL_DISHES", query = "SELECT d FROM Dish d ORDER BY d.name")
})
public class Dish extends AbstractNamedEntity {


    @OneToOne(mappedBy = "dish")
    private Menu menu;

    public Dish() {

    }

    public Dish(Integer id, String name) {
        super(id, name);

    }

    @Override
    public String toString() {
        return "Dish{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }
}
