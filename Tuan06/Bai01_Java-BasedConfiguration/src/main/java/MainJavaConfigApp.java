import configs.UserServiceConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import services.UserService;

public class MainJavaConfigApp {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(UserServiceConfig.class);

        UserService userService = context.getBean(UserService.class);

        userService.displayUserInfo();
    }
}
