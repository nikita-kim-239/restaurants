package kim.nikita.repository.user;

import kim.nikita.model.User;

import java.util.List;

public interface UserRepository {

    User save(User user);

    boolean delete(int id);

    User get(int id);

    List<User> getAll();

}
