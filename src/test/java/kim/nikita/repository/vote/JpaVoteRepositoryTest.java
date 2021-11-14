package kim.nikita.repository.vote;



import kim.nikita.model.Restaurant;
import kim.nikita.model.User;
import kim.nikita.model.Vote;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static kim.nikita.UserTestData.*;
import static kim.nikita.UserTestData.updatedUser;
import static kim.nikita.VoteTestData.*;
import static kim.nikita.VoteTestData.VOTE1;
import static kim.nikita.VoteTestData.VOTE2;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

@ContextConfiguration({
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
})
@RunWith(SpringRunner.class)
@Sql(scripts = "classpath:db/populateDB.sql", config = @SqlConfig(encoding = "UTF-8"))
public class JpaVoteRepositoryTest {

    @Autowired
    private VoteRepository repository;

    @Test
    public void getAll()
    {
        List<Vote> all=repository.getAll();
        assertMatch(all,VOTE1,VOTE2);
    }


    @Test
    public void create()
    {
        Vote actual =getNewVote();
        Vote expected=repository.save(actual);
        Integer newId=expected.getId();
        actual.setId(newId);
        assertEquals(expected,actual);
        assertEquals(repository.get(newId),actual);
    }

    @Test
    public void delete()
    {

        assertTrue(repository.delete(VOTE1_ID));
        assertNull(repository.get(VOTE1_ID));
    }

    @Test
    public void deleteNotFound()
    {

        assertFalse(repository.delete(-1));

    }

    @Test
    public void getById()
    {
        assertEquals(VOTE1,repository.get(VOTE1_ID));
    }

    @Test
    public void update()
    {

        assertEquals(UPDATED_VOTE,repository.save(UPDATED_VOTE));
    }

}
