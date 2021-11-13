package kim.nikita.model;


import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="dishes")
@NamedQueries({

        @NamedQuery(name = "GET_ALL_DISHES", query = "SELECT d FROM Dish d ORDER BY d.name")
})
public class Dish extends AbstractNamedEntity{

    public Dish()
        {

        }

    public Dish(Integer id,String name)
        {
            super(id,name);
        }

    @Override
    public String toString() {
        return "Dish{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
