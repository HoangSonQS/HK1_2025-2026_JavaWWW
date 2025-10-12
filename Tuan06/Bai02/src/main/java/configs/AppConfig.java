package configs;

import models.Address;
import models.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public Address javaAddress() {
        return new Address("Da Nang", "VN-DAN", "Vietnam");
    }

    @Bean
    public Employee javaEmployee() {
        return new Employee(103, "Le Van Lu (Java Config)", javaAddress());
    }
}
