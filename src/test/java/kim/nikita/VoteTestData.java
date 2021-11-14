package kim.nikita;

import kim.nikita.model.Restaurant;
import kim.nikita.model.Role;
import kim.nikita.model.User;
import kim.nikita.model.Vote;

import java.util.Arrays;
import java.util.Collections;

import static kim.nikita.RestaurantTestData.*;
import static kim.nikita.model.AbstractBaseEntity.START_SEQ;
import static kim.nikita.UserTestData.*;
import static org.assertj.core.api.Assertions.assertThat;

public class VoteTestData {

    public static final int VOTE1_ID=START_SEQ+12;
    public static final int VOTE2_ID=START_SEQ+13;

    public static final Vote VOTE1= new Vote(VOTE1_ID,user,RUSSIAN_RESTAURANT);
    public static final Vote VOTE2= new Vote(VOTE2_ID,admin,FRENCH_RESTAURANT);

    public static final Vote UPDATED_VOTE= new Vote(VOTE2_ID,admin,ITALIAN_RESTAURANT);

    public static Vote getNewVote()
    {
        return new Vote(null,admin,CHINESE_RESTAURANT);
    }

    public static void assertMatch(Iterable<Vote> actual, Vote... expected) {
        assertMatch(actual, Arrays.asList(expected));
    }

    public static void assertMatch(Iterable<Vote> actual, Iterable<Vote> expected) {
        assertThat(actual).isEqualTo(expected);
    }
}
