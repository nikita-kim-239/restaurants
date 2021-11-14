package kim.nikita.repository.restaurant;

import kim.nikita.model.Dish;
import kim.nikita.model.Restaurant;

import java.util.List;

public interface RestaurantRepository {


    Restaurant save(Restaurant restaurant);

    boolean delete(int id);

    Restaurant get(int id);

    List<Restaurant> getAll();
}
