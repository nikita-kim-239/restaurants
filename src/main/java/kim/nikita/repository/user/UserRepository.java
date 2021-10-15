package kim.nikita.repository.user;

import kim.nikita.model.User;

import java.util.List;

public interface UserRepository {

    List<User> getAll();

}
