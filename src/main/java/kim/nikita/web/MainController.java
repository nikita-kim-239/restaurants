package kim.nikita.web;

import kim.nikita.model.*;
import kim.nikita.service.MainService;
import kim.nikita.service.UserService;
import kim.nikita.util.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class MainController {


    private final MainService service;

    private final UserService userService;


    @Autowired
    public MainController(MainService service, UserService userService) {
        this.service = service;
        this.userService = userService;
    }

    @GetMapping(value = "/restaurants")
    public ResponseEntity<List<Restaurant>> getRestaurants() {
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>(service.getAllRestaurants(), httpHeaders, HttpStatus.OK);
    }

    @GetMapping(value = "/dishes")
    public ResponseEntity<List<Dish>> getDishes() {
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>(service.getAllDishes(), httpHeaders, HttpStatus.OK);
    }

    @GetMapping(value = "/admin/users")
    public ResponseEntity<List<User>> getUsers() {
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>(userService.getUsers(), httpHeaders, HttpStatus.OK);
    }

    @PostMapping(value = "/admin/restaurants")
    public ResponseEntity<Restaurant> createRestaurant(@RequestBody Restaurant restaurant) {
        Restaurant created = service.createRestaurant(restaurant);
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>(created, httpHeaders, HttpStatus.CREATED);
    }

    @PostMapping(value = "/admin/dishes")
    public ResponseEntity<Dish> createDish(@RequestBody Dish dish) {
        Dish created = service.createDish(dish);
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>(created, httpHeaders, HttpStatus.CREATED);
    }

    @PostMapping(value = "/register")
    public ResponseEntity<User> register(@RequestBody User user) {
        User registered = userService.register(user);
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>(registered, httpHeaders, HttpStatus.CREATED);

    }

    @PostMapping(value = "/restaurant/{restaurant_id}/vote")
    public ResponseEntity<Vote> vote(@PathVariable String restaurant_id) {
        Restaurant restaurant = service.getRestaurantById(Integer.parseInt(restaurant_id));
        User user = userService.getUserByUsername(SecurityUtil.authUserName());
        Vote newVote = service.makeVote(new Vote(null, user, restaurant));
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>(newVote, httpHeaders, HttpStatus.CREATED);

    }

}
