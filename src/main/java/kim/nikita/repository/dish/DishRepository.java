package kim.nikita.repository.dish;

import kim.nikita.model.Dish;

import java.util.List;

public interface DishRepository {

    Dish save(Dish dish);

    boolean delete(Integer id);

    Dish get(Integer id);

    List<Dish> getAll();
}
