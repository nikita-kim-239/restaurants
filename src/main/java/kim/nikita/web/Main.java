package kim.nikita.web;

import kim.nikita.repository.user.UserRepository;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {

        ConfigurableApplicationContext appCtx = new ClassPathXmlApplicationContext("spring/spring-app.xml","spring/spring-db.xml");
        UserRepository userRepository = appCtx.getBean(UserRepository.class);
        System.out.println(userRepository.getAll());
        }
}
