package kim.nikita.service;


import kim.nikita.model.Dish;
import kim.nikita.model.Restaurant;
import kim.nikita.repository.dish.DishRepository;
import kim.nikita.repository.restaurant.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MainService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private DishRepository dishRepository;

    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.getAll();
    }

    public List<Dish> getAllDishes() {
        return dishRepository.getAll();
    }

    public Dish createDish(Dish dish) {
        return dishRepository.save(dish);
    }

    public Restaurant createRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }
}
