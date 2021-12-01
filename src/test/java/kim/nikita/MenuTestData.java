package kim.nikita;

import kim.nikita.model.Dish;
import kim.nikita.model.Menu;
import kim.nikita.model.Role;
import kim.nikita.model.User;

import java.util.Arrays;
import java.util.Collections;

import static kim.nikita.DishTestData.*;
import static kim.nikita.RestaurantTestData.*;
import static kim.nikita.model.AbstractBaseEntity.START_SEQ;
import static org.assertj.core.api.Assertions.assertThat;

public class MenuTestData {

    public static final int MENU1_ID = START_SEQ + 14;
    public static final int MENU2_ID = START_SEQ + 15;
    public static final int MENU3_ID = START_SEQ + 16;
    public static final int MENU4_ID = START_SEQ + 17;
    public static final int MENU5_ID = START_SEQ + 18;

    public static final Menu MENU1 = new Menu(MENU1_ID, RUSSIAN_RESTAURANT, MEAT, 100);
    public static final Menu MENU2 = new Menu(MENU2_ID, RUSSIAN_RESTAURANT, SALAD, 200);
    public static final Menu MENU3 = new Menu(MENU3_ID, FRENCH_RESTAURANT, JUICE, 50);
    public static final Menu MENU4 = new Menu(MENU4_ID, ITALIAN_RESTAURANT, TEA, 90);
    public static final Menu MENU5 = new Menu(MENU5_ID, FRENCH_RESTAURANT, WATER, 300);


    public static final Menu MENU_UPDATED = new Menu(MENU5_ID, FRENCH_RESTAURANT, BREAD, 10);

    public static Menu getNewMenu() {
        return new Menu(ITALIAN_RESTAURANT, SALAD, 500);
    }

    public static void assertMatch(Iterable<Menu> actual, Menu... expected) {
        assertMatch(actual, Arrays.asList(expected));
    }

    public static void assertMatch(Iterable<Menu> actual, Iterable<Menu> expected) {
        assertThat(actual).isEqualTo(expected);
    }


}
