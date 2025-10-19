package iuh.fit.se.springdatacommon;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.sql.DriverManager;

//@Configuration
//@PropertySource("classpath:database.properties")
public class AppConfig {
//    @Value("${app.datasource.url}")
//    private String url;
//    @Value("${app.datasource.username}")
//    private String userName;
//    @Value("${app.datasource.password}")
//    private String password;
//    @Value("${app.datasource.driver-class-name}")
//    private String driver;
//
//    @Bean(name = "dataSource")
//    DataSource getDataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName(driver);
//        dataSource.setUrl(url);
//        dataSource.setUsername(userName);
//        dataSource.setPassword(password);
//
//        return dataSource;
//    }
}
