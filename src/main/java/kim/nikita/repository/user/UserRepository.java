package kim.nikita.repository.user;

import kim.nikita.model.User;

import java.util.List;

public interface UserRepository {

    User save(User User);

    boolean delete(Integer id);

    User get(Integer id);

    List<User> getAll();

}
