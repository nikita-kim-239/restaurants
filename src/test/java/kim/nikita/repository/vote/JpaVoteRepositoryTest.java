package kim.nikita.repository.vote;



import kim.nikita.model.Vote;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static kim.nikita.VoteTestData.*;
import static kim.nikita.VoteTestData.VOTE1;
import static kim.nikita.VoteTestData.VOTE2;

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

}
