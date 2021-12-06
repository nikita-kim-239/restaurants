package kim.nikita.service;


import kim.nikita.model.Dish;
import kim.nikita.model.Restaurant;
import kim.nikita.model.Vote;
import kim.nikita.repository.dish.DishRepository;
import kim.nikita.repository.restaurant.RestaurantRepository;
import kim.nikita.repository.vote.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MainService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private DishRepository dishRepository;

    @Autowired
    private VoteRepository voteRepository;

    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.getAll();
    }

    public List<Dish> getAllDishes() {
        return dishRepository.getAll();
    }

    public Dish createDish(Dish dish) {
        return dishRepository.save(dish);
    }

    public Vote makeVote(Vote vote) {
        return voteRepository.save(vote);
    }

    public Restaurant getRestaurantById(Integer id) {
        return restaurantRepository.get(id);
    }

    public Restaurant createRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }
}
