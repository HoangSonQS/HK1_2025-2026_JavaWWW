package iuh.fit.se.tuan08_frontend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class Tuan08FrontEndApplication {

	public static void main(String[] args) {
		SpringApplication.run(Tuan08FrontEndApplication.class, args);
	}

}
