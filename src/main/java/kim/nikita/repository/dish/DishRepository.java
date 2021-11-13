package kim.nikita.repository.dish;

import kim.nikita.model.Dish;
import kim.nikita.model.User;

import java.util.List;

public interface DishRepository {

    Dish save(Dish dish);

    boolean delete(int id);

    Dish get(int id);

    List<Dish> getAll();

}
