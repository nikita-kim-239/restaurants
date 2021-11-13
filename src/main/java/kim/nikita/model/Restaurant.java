package kim.nikita.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name="restaurants")
public class Restaurant extends AbstractNamedEntity{

    @Column(name = "address", nullable = false,unique = true)
    @NotBlank
    @Size(min = 5, max = 40)
    private String address;

    public Restaurant(int id, String name, String address) {
        super(id,name);
        this.address = address;
    }

    public Restaurant() {
    }



    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
