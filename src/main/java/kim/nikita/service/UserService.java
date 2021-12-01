package kim.nikita.service;


import kim.nikita.model.User;
import kim.nikita.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {


    @Autowired
    private UserRepository repository;

    public List<User> getUsers() {
        return repository.getAll();
    }

}
