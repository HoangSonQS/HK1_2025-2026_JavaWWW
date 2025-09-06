package iuh.fit.se.lab2_restapi.jakartarestapi;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.glassfish.jersey.server.ResourceConfig;
import jakarta.ws.rs.ApplicationPath;

@ApplicationPath("/api")
public class UserApplication extends ResourceConfig {
    public UserApplication() {
        packages("iuh.fit.se.lab2_restapi.jakartarestapi");
        register(org.glassfish.jersey.jackson.JacksonFeature.class);

        // Đăng ký tính năng tự động phát hiện các resource
        property("jersey.config.server.provider.classnames",
                "org.glassfish.jersey.jackson.JacksonFeature");
    }
}