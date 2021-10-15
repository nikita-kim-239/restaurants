package kim.nikita.model;

import java.time.LocalDateTime;
import java.util.Set;

public class User {

    private int id;
    private String name;
    private String email;
    private LocalDateTime registered;
    private boolean admin;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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


    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public User(int id, String name, String email, LocalDateTime registered, boolean admin) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.registered = registered;
        this.admin = admin;
    }
}
