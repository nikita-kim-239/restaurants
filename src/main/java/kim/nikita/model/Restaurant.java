package kim.nikita.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;


@NamedQueries({

        @NamedQuery(name = "GET_ALL_RESTAURANTS", query = "SELECT r FROM Restaurant r ORDER BY r.name")
})
@Entity
@Table(name = "restaurants")
public class Restaurant extends AbstractNamedEntity {


    @OneToMany(mappedBy = "restaurant", fetch = FetchType.EAGER)
    private Set<Menu> menus;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "restaurant_id")
    private Set<Vote> votes;


    public Restaurant(Integer id, String name) {
        super(id, name);

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
