package configs;

import models.Group;
import models.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import services.UserService;

@Configuration
public class UserServiceConfig {

    @Bean
    public Group groupBean() {
        return new Group("Admin Group");
    }

    @Bean
    public User userBean() {
        return new User("User 01 - Java Config", groupBean());
    }

    @Bean
    public UserService userService() {
        return new UserService(userBean());
    }
}
