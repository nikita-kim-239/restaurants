package kim.nikita.model;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

@NamedQueries({

        @NamedQuery(name = "GET_ALL_SORTED", query = "SELECT u FROM User u LEFT JOIN FETCH u.roles ORDER BY u.name, u.email")
})
@Entity
@Table(name="users")
public class User extends AbstractNamedEntity{


    @Column(name="email",nullable=false,unique=true)
    @Email
    @NotBlank
    @Size(max=50)
    private String email;

    @Column(name="registered",nullable = false,columnDefinition = "timestamp default now()")
    @NotNull
    private LocalDateTime registered = LocalDateTime.now();

    @Column(name = "password", nullable = false)
    @NotBlank
    @Size(min = 5, max = 100)
    private String password;

    @Column(name = "enabled", nullable = false, columnDefinition = "bool default true")
    private boolean enabled=true;

    @Enumerated(EnumType.STRING)
    @CollectionTable(name="user_roles",joinColumns = @JoinColumn(name="user_id"))
    @Column(name="role")
    @ElementCollection(fetch = FetchType.EAGER)
    private Set<Role> roles;

    @OneToOne(mappedBy="user")
    private Vote vote;

    public User()
        {

        }

    public User(Integer id, String name, String email,  String password, Set<Role> roles) {
        super(id, name);
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getRegistered() {
        return registered;
    }

    public void setRegistered(LocalDateTime registered) {
        this.registered = registered;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", registered=" + registered +
                ", password='" + password + '\'' +
                ", enabled=" + enabled +
                ", roles=" + roles +
                '}';
    }
}
