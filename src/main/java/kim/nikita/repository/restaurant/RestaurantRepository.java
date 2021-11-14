package kim.nikita.repository.restaurant;

import kim.nikita.model.Restaurant;

import java.util.List;

public interface RestaurantRepository {

    Restaurant save(Restaurant Restaurant);

    boolean delete(Integer id);

    Restaurant get(Integer id);

    List<Restaurant> getAll();
    
}
