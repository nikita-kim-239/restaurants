package kim.nikita.web;

import kim.nikita.model.Restaurant;
import kim.nikita.model.User;
import kim.nikita.service.MainService;
import kim.nikita.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class MainController {

    @Autowired
    private MainService service;

    @Autowired
    private UserService userService;


    @GetMapping(value = "/restaurants")
    public ResponseEntity<List<Restaurant>> getRestaurants() {
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<List<Restaurant>>(service.getAllRestaurants(), httpHeaders, HttpStatus.OK);
    }

    @GetMapping(value = "/admin/users")
    public ResponseEntity<List<User>> getUsers() {
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<List<User>>(userService.getUsers(), httpHeaders, HttpStatus.OK);
    }
}
