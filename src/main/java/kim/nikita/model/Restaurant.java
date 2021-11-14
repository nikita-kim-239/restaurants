package kim.nikita.model;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;


@NamedQueries({

        @NamedQuery(name = "GET_ALL_RESTAURANTS", query = "SELECT r FROM Restaurant r ORDER BY r.name")
})
@Entity
@Table(name="restaurants")
public class Restaurant extends AbstractNamedEntity{



    @OneToMany
    @JoinColumn(name = "restaurant_id")
    private Set<Vote> votes;

    public Restaurant(Integer id, String name) {
        super(id,name);

    }

    public Restaurant() {
    }


    @Override
    public String toString() {
        return "Restaurant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
