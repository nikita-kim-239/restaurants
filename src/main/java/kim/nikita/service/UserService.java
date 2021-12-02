package kim.nikita.service;


import kim.nikita.model.AuthorizedUser;
import kim.nikita.model.User;
import kim.nikita.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserService implements UserDetailsService {


    @Autowired
    private UserRepository repository;

    public List<User> getUsers() {
        return repository.getAll();
    }

    public User register(User user) {
        return repository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.getByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new AuthorizedUser(user);
    }
}
