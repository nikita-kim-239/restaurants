package kim.nikita;

import kim.nikita.model.Role;
import kim.nikita.model.User;

import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;

import static kim.nikita.model.AbstractBaseEntity.START_SEQ;
import static org.assertj.core.api.Assertions.assertThat;


public class UserTestData {

    public static final int USER_ID=START_SEQ;
    public static final int ADMIN_ID=START_SEQ+1;


    public static final User user = new User(USER_ID, "Ivan", "ivan@yandex.ru", "password", EnumSet.of(Role.USER));
    public static final User admin = new User(ADMIN_ID, "Petr", "petr@gmail.com", "admin", EnumSet.of(Role.ADMIN));
    public static final User updatedUser=new User(USER_ID,"Fedor","ivan@yandex.ru", "password", EnumSet.of(Role.USER));


    public static User getNew()
        {
            return new User(null,"Sidor","new@yahoo.com","newPass", Collections.singleton(Role.USER));
        }


    public static void assertMatch(User actual, User expected) {
        assertThat(actual).usingRecursiveComparison().ignoringFields("registered", "roles").isEqualTo(expected);
    }

    public static void assertMatch(Iterable<User> actual, User... expected) {
        assertMatch(actual, Arrays.asList(expected));
    }

    public static void assertMatch(Iterable<User> actual, Iterable<User> expected) {
        assertThat(actual).usingRecursiveComparison().ignoringFields("registered", "roles","vote").isEqualTo(expected);
    }
}
