package iuh.fit.se.springdatacommon;

import iuh.fit.se.springdatacommon.dao.EmployeeDAO;
import iuh.fit.se.springdatacommon.dao.impl.EmployeeDAOImpl;
import iuh.fit.se.springdatacommon.entity.Employee;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class SpringPureJdbcxmlConfigApplication {
    @SuppressWarnings("resources")
    public static void main(String[] args) throws SQLException {
        ApplicationContext context = new ClassPathXmlApplicationContext("databaseConfig.xml");
        DataSource dataSource = context.getBean("dataSource", DataSource.class);
        System.out.println(dataSource.getConnection());

        EmployeeDAO employeeDAO = context.getBean("employeeDAOImpl", EmployeeDAOImpl.class);

    }
}
