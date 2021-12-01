package kim.nikita.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;


@NamedQueries({

        @NamedQuery(name = "GET_ALL_VOTES", query = "SELECT v FROM Vote v")
})
@Entity
@Table(name = "votes")
public class Vote extends AbstractBaseEntity {

    @OneToOne(cascade = CascadeType.MERGE)
    @JsonIgnore
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;


    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "restaurant_id", insertable = true, updatable = true)
    private Restaurant restaurant;


    public Vote() {

    }

    public Vote(Integer id, User user, Restaurant restaurant) {
        super(id);
        this.user = user;
        this.restaurant = restaurant;
    }

    @Override
    public String toString() {
        return "Vote{" +
                "id=" + id +
                ", user=" + user +
                ", restaurant=" + restaurant +
                '}';
    }
}
