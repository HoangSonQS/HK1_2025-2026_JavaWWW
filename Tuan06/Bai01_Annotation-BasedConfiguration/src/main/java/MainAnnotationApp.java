import config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.MyFormatterService;

public class MainAnnotationApp {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        MyFormatterService service = context.getBean(MyFormatterService.class);
        service.printFormat(1000d);
    }
}